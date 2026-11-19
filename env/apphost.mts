// AppHost Aspire (TypeScript) : environnement de développement local.
// Lancement : `aspire run` depuis ce dossier.
// WSL Containers : $env:ASPIRE_CONTAINER_RUNTIME = "wslc" (PowerShell)

import { ContainerLifetime, createBuilder } from './.aspire/modules/aspire.mjs';

const builder = await createBuilder();

const password = await builder.addParameter('postgres-password', { value: 'asta', secret: true });
const user = await builder.addParameter('postgres-user', { value: 'asta' });

// Base applicative : port 5432, initialisée avec les scripts de ./db/init
await builder
    .addPostgres('db', { userName: user, password, port: 5432 })
    .withImage('postgres', { tag: 'latest' })
    .withEnvironment('POSTGRES_DB', 'asta')
    .withBindMount('./db/init', '/docker-entrypoint-initdb.d', { isReadOnly: true })
    .withLifetime(ContainerLifetime.Persistent);

// Base de Keycloak : port 5433
const userDb = await builder
    .addPostgres('user-db', { userName: user, password, port: 5433 })
    .withImage('postgres', { tag: 'latest' })
    .withEnvironment('POSTGRES_DB', 'asta')
    .withBindMount('./user-db', '/docker-entrypoint-initdb.d', { isReadOnly: true })
    .withLifetime(ContainerLifetime.Persistent);

// Keycloak : port 8090, realm importé depuis ./auth
await builder
    .addKeycloak('auth', { port: 8090, adminUsername: user, adminPassword: password })
    .withImageTag('26.6.0')
    .withRealmImport('./auth')
    .withEnvironment('KC_DB', 'postgres')
    .withEnvironment('KC_DB_URL', 'jdbc:postgresql://user-db:5432/asta')
    .withEnvironment('KC_DB_USERNAME', 'asta')
    .withEnvironment('KC_DB_PASSWORD', 'asta')
    .withEnvironment('KC_HOSTNAME', 'localhost')
    .waitFor(userDb);

await builder.build().run();

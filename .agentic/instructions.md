# Mode d'emploi du projet (pour les agents)

`asta-starter-kit` est une application fullstack :

- **Frontend** : Angular 21, gestionnaire de paquets npm (`npm@11`), dans `sources/frontend`.
- **Backend** : Spring Boot 4 / Java 25 / Maven, dans `sources/backend`.
- **Modele** : gere avec TopModel dans `model/` (contrats generes cote back et front).
- **Infra locale** : PostgreSQL + Keycloak via `env/docker-compose.yml` ; infra AWS via Terraform.

## Demarrer l'environnement

Base de donnees + Keycloak : `docker compose up -d` dans `env/`.
(Utilisateur applicatif Keycloak : `asta` / mot de passe `asta`, realm `asta`.)

## Build

- Frontend : `cd sources/frontend && npm ci && npm run build`.
- Backend : `cd sources/backend && mvn -q clean install`.

## Tests

- Frontend : `cd sources/frontend && npm test` (Vitest ; en CI, mode non-watch).
  `npm run build` DOIT compiler sans erreur.
- Backend : `cd sources/backend && mvn test` DOIT etre VERT.

## Regles

- Branches : `chore/<sujet>` ou `feat/<sujet>` ; commits conventionnels, AUCUNE attribution IA.
- Ne pas regenerer le modele TopModel sans necessite, et ne pas casser les contrats generes.

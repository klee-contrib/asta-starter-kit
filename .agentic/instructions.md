# Mode d'emploi du projet (pour les agents)

Ce fichier est injecte dans CHAQUE prompt (producteur + juge) de chaque workflow.

**Documentation agent** : [docs/AGENTS.md](docs/AGENTS.md)  
**Index documentation** : [docs/README.md](docs/README.md)

## Demarrer l'environnement

```bash
task up    # Docker (php, db, node, selenium…)
task app   # composer, assets, BDD
```

URLs : `http://{module}.ges3x.local:8080` (ex. `gescom.ges3x.local:8080`).

## Build

Pas de build Maven/npm hors Docker. Les watchers front tournent dans les conteneurs `node`, `sass`, `typescript`.

```bash
task warmup   # recharger les caches Symfony (tous modules)
```

## Tests

Les tests doivent etre VERTS avant commit :

```bash
task quality-fix && task quality
task tests-unit          # si logique touchee
task tests-migrations    # si entites / schema touches
task tests-functional    # si controllers / routes touches
```

Test cible : `task test-phpunit -- tests/Unit/Gescom/...`  
Behat : `MODULE=gescom task test-behat -- features/gescom/...`

## Regles

- **MODULE** : un seul module actif — toujours l'identifier avant modification (`config/modules/`, `src/Ges{module}/`).
- **Entites** : toujours dans `src/Gescore/Entity/{Module}/`, jamais dans `src/Ges{module}/`.
- **Migrations** : obligatoirement testees (`tests/Migrations/` + dumps before/after). Voir [docs/05-development/migrations.md](docs/05-development/migrations.md).
- **Qualite** : ECS + PHPStan (`task quality`) avant commit.
- **Pas de dependance inter-modules** : un `Gescom\*` n'importe pas un service `Gesmar\*` directement.

Detail : [docs/AGENTS.md](docs/AGENTS.md)

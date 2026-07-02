# .agentic/ - configuration agentique du projet

Ce dossier definit comment la plateforme execute des workflows d'agents sur ce repo.

## Fichiers

- `agentic.config.yml` : config du projet (nom, depot, image de run, options). A COMPLETER (TODO repo/image).
- `workflows/angular-upgrade.yml` : un workflow (suite d'etapes). GENERE par le Builder.
- `agents.yml` : les agents PROPRES au projet (les agents par defaut restent herites). GENERE par le Builder.
- `Dockerfile` : l'image de run (toolchain). TEMPLATE a adapter a ta stack.
- `instructions.md` : le mode d'emploi injecte dans chaque prompt. A COMPLETER.
- `mcp.yml` : catalogue d'outils MCP (optionnel ; `servers: {}` par defaut).

## Image de run : deux modes (dans agentic.config.yml)

- `image: { dockerfile: .agentic/Dockerfile }` : la plateforme BUILD l'image au runtime.
- `image: { ref: <registre>/<image>:<tag> }` : ton CI a deja construit l'image, la plateforme la PULL (zero build).
  Dans les deux cas, l'image doit etre `FROM agentic/agent-runner` (verifie via le label `agentic.runner`).

## MCP (outils des agents)

Deux facons de donner un outil a un agent :
- INLINE (le plus simple), dans `agents.yml` :
  ```yaml
  mcpServers:
    mon-outil: { type: http, url: https://.../mcp, headers: { Authorization: "Bearer <token>" } }
  ```
- CATALOGUE : declare l'outil UNE fois dans `mcp.yml` sous `servers:`, puis reference-le :
  ```yaml
  mcpServers:
    mon-outil: { use: mon-outil }
  ```
  Utile quand PLUSIEURS agents partagent le meme outil, et pour mapper les secrets par nom.

Les serveurs MCP exposent leurs outils (`tools/list`) ; le LLM les DECOUVRE et CHOISIT automatiquement
d'apres leurs descriptions. Oriente-le via le `systemPrompt` de l'agent si besoin.

## docker-in-docker (testcontainers / docker compose)

Mets `sandbox: { docker: true }` dans la config si tes runs ont besoin d'un Docker dans le run
(testcontainers, docker compose). Necessite `AGENTIC_ALLOW_DIND=1` cote worker.

## Lancer

Enregistre le projet (depuis la Console / l'API) avec l'URL de ce repo, puis lance un workflow.
Tu peux surcharger la branche d'un run avec le champ `ref` au lancement (defaut : repo.ref).

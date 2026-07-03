# Image de run du projet. Le stage final DOIT etendre agentic/agent-runner :
# le runner SDK (Cursor + OpenCode) et l'auto-decouverte des outils vivent dedans.
# Decommente/adapte la (les) toolchain(s) dont ton projet a besoin.
FROM agentic/agent-runner:latest

# --- Java 25 (Temurin) + Maven 3 ---
RUN apt-get update && apt-get install -y --no-install-recommends wget gnupg \
    && wget -qO /etc/apt/keyrings/adoptium.asc https://packages.adoptium.net/artifactory/api/gpg/key/public \
    && echo "deb [signed-by=/etc/apt/keyrings/adoptium.asc] https://packages.adoptium.net/artifactory/deb bookworm main" \
       > /etc/apt/sources.list.d/adoptium.list \
    && apt-get update && apt-get install -y --no-install-recommends temurin-25-jdk maven \
    && rm -rf /var/lib/apt/lists/*
ENV JAVA_HOME=/usr/lib/jvm/temurin-25-jdk-amd64
ENV MAVEN_OPTS="-Dmaven.repo.local=/root/.m2/repository"

# --- Node + pnpm 9 ---
# RUN npm install -g pnpm@9 --no-audit --no-fund

# (Optionnel) prechauffage des deps pour des runs rapides. Copie SEULEMENT les lockfiles
# (pas tout le source) -> la couche ne se reconstruit que quand les deps changent, pas a
# chaque commit. Exemples :
# COPY **/pom.xml /opt/seed/
# RUN (cd /opt/seed && mvn -DskipTests dependency:go-offline) ; rm -rf /opt/seed
# COPY pnpm-lock.yaml /opt/pnpm-seed/
# RUN (cd /opt/pnpm-seed && pnpm fetch) ; rm -rf /opt/pnpm-seed

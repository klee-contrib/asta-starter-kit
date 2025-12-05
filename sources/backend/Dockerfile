FROM maven:3-openjdk-25
WORKDIR /asta
COPY ./target/asta.jar /asta/asta.jar
ENTRYPOINT [ "java", "-jar", "asta.jar" ]
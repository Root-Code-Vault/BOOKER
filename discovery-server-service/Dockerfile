FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

COPY target/discovery-server-service-0.0.1-SNAPSHOT.jar /app/discovery-server-service-0.0.1-SNAPSHOT.jar

EXPOSE 9090

ENTRYPOINT ["java", "-jar", "discovery-server-service-0.0.1-SNAPSHOT.jar"]
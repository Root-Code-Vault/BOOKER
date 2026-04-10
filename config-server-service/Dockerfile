FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

COPY target/config-server-service-0.0.1-SNAPSHOT.jar /app/config-server-service-0.0.1-SNAPSHOT.jar

EXPOSE 9091

ENTRYPOINT ["java", "-jar", "config-server-service-0.0.1-SNAPSHOT.jar"]
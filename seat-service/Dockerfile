FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

COPY target/seat-service-0.0.1-SNAPSHOT.jar /app/seat-service-0.0.1-SNAPSHOT.jar

EXPOSE 9096

ENTRYPOINT ["java", "-jar", "seat-service-0.0.1-SNAPSHOT.jar"]
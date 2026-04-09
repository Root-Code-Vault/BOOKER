FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

COPY target/gateway-0.0.1-SNAPSHOT.jar /app/gateway-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "gateway-0.0.1-SNAPSHOT.jar"]
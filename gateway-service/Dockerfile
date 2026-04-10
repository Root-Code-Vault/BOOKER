FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

COPY target/gateway-service-0.0.1-SNAPSHOT.jar /app/gateway-service-0.0.1-SNAPSHOT.jar

EXPOSE 9098

ENTRYPOINT ["java", "-jar", "gateway-service-0.0.1-SNAPSHOT.jar"]
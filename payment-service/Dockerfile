FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

COPY target/payment-service-0.0.1-SNAPSHOT.jar /app/payment-service-0.0.1-SNAPSHOT.jar

EXPOSE 9095

ENTRYPOINT ["java", "-jar", "payment-service-0.0.1-SNAPSHOT.jar"]
FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

COPY target/booking-service-0.0.1-SNAPSHOT.jar /app/booking-service-0.0.1-SNAPSHOT.jar

EXPOSE 9097

ENTRYPOINT ["java", "-jar", "booking-service-0.0.1-SNAPSHOT.jar"]
FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY target/config_service-0.0.1-SNAPSHOT.jar /app/config_service-0.0.1-SNAPSHOT.jar

EXPOSE 8763

CMD ["java", "-jar", "config_service-0.0.1-SNAPSHOT.jar"]
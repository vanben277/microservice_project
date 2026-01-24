# Sử dụng image JDK 21 chính thức
FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY target/api_gateway-0.0.1-SNAPSHOT.jar /app/api_gateway-0.0.1-SNAPSHOT.jar

EXPOSE 8762

CMD ["java", "-jar", "api_gateway-0.0.1-SNAPSHOT.jar"]
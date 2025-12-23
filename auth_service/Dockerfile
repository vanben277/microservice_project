# Sử dụng image JDK 21 chính thức
FROM eclipse-temurin:21-jdk

LABEL authors="vanben277"

# Tạo thư mục ứng dụng trong container
WORKDIR /app

# Sao chép file JAR vào thư mục làm việc trong container
COPY target/auth_service-0.0.1-SNAPSHOT.jar /app/auth_service-0.0.1-SNAPSHOT.jar

EXPOSE 8083

# Chạy ứng dụng khi container khởi động
ENTRYPOINT ["java", "-jar", "/app/auth_service-0.0.1-SNAPSHOT.jar"]
# Sử dụng image JDK 21 chính thức
FROM eclipse-temurin:21-jdk

# Tạo thư mục ứng dụng trong container
WORKDIR /app

# Sao chép file JAR vào thư mục làm việc trong container
COPY target/department_service-0.0.1-SNAPSHOT.jar /app/department_service-0.0.1-SNAPSHOT.jar

EXPOSE 8080

# Chạy ứng dụng khi container khởi động
ENTRYPOINT ["java", "-jar", "/app/department_service-0.0.1-SNAPSHOT.jar"]
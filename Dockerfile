# 1️⃣ Use a lightweight Java 17 runtime image
FROM eclipse-temurin:17-jre-jammy

# 2️⃣ Set working directory inside container
WORKDIR /app

# 3️⃣ Copy the JAR from target folder into container
COPY target/banking-app-0.0.1-SNAPSHOT.jar app.jar

# 4️⃣ Expose application port
EXPOSE 8080

# 5️⃣ Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]

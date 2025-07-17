# Stage 1: Build the Spring Boot application using Gradle
# We use a Gradle image that includes a JDK, which is necessary for building Java applications.
FROM gradle:8.8-jdk17-alpine AS builder

# Set the working directory inside the container
WORKDIR /app

# Copy Gradle wrapper files and build scripts first to leverage Docker cache.
# If these files don't change, Docker can reuse the layer for dependencies.
COPY gradlew .
COPY gradle gradle/
COPY build.gradle .
COPY settings.gradle .

# Grant execute permissions to the Gradle wrapper script
RUN chmod +x gradlew

# Download dependencies without building the app to cache them.
# This step will only rerun if build.gradle or settings.gradle changes.
RUN ./gradlew dependencies

# Copy the entire source code into the container
COPY src src/

# Build the Spring Boot application into an executable JAR
# The 'bootJar' task creates a fat JAR that includes all dependencies.
RUN ./gradlew bootJar

# Stage 2: Create the final Docker image with the built JAR
# We use a smaller JRE-only image for the final application to reduce image size.
# Using Alpine Linux for minimal footprint.
FROM eclipse-temurin:17-jre-alpine

RUN apk add --no-cache sqlite

# Set the working directory for the application
WORKDIR /app

# Copy the built JAR file from the 'builder' stage into the current stage
# The JAR is typically found in build/libs/your-app-name-version.jar
# Adjust 'your-app-name-version.jar' to match your actual JAR file name.
# You can find the exact name by checking the 'build/libs' directory after a local build.
# A common pattern is 'project-name-version.jar'.
# For example, if your project name is 'my-spring-app' and version is '0.0.1-SNAPSHOT',
# it would be 'my-spring-app-0.0.1-SNAPSHOT.jar'.
COPY --from=builder /app/build/libs/*.jar app.jar
COPY docker/init.sql init.sql
RUN  touch lotto.sqlite.db && sqlite3 --init ./init.sql lotto.sqlite.db .quit

# Expose the port that your Spring Boot application listens on (default is 8080)
EXPOSE 8200

# Define the entry point for the container.
# This command will be executed when the container starts.
# It runs the Spring Boot application using the java -jar command.
ENTRYPOINT ["java", "-jar", "app.jar"]


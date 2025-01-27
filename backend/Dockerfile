# Use a base image with OpenJDK (choose the version that fits your app)
FROM openjdk:17-jdk-slim as build

# Set the working directory in the container
WORKDIR /app

# Copy the .jar file from your target directory
COPY target/muzik-0.0.1-SNAPSHOT.jar /app/muzik.jar

# Copy the .env file
COPY .env /app/.env

# Expose the port your app will run on
EXPOSE 8080

# Set the entry point for the container to run the application
ENTRYPOINT ["java", "-jar", "/app/muzik.jar"]

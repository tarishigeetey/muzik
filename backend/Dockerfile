# Use a base image with OpenJDK 
FROM openjdk:21

# Expose the port your app will run on
EXPOSE 8080

# Add the .jar file from your target directory
ADD target/muzik-0.0.1-SNAPSHOT.jar muzik-app.jar

# Set the entry point for the container to run the application
ENTRYPOINT ["java", "-jar", "muzik-app.jar"]

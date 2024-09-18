# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app

# Add the JAR file built by Maven/Gradle to the container
COPY target/my-app.jar my-app.jar

# Run the JAR file
ENTRYPOINT ["java", "-jar", "my-app.jar"]

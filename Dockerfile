# Start with a base image containing Java runtime
FROM eclipse-temurin:17-jre-focal

# Set the working directory inside the container
WORKDIR /app

# Copy the packaged jar file into the container
COPY target/*.jar /app/devopsjava.jar

# Expose the port on which your Spring Boot application runs
EXPOSE 8080

# Specify the command to run your Spring Boot application using environment variables
CMD ["java", "-jar", "/app/devopsjava.jar"]
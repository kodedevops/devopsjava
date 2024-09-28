# Getting Started

### Reference Documentation

Public Url to Test After deployment
```
http://IP_ADDRESS:PORT/java-service/first/
http://IP_ADDRESS:PORT/java-service/first/hello
http://IP_ADDRESS:PORT/java-service/first/health
http://IP_ADDRESS:PORT/java-service/first/list
http://IP_ADDRESS:PORT/java-service/first/map          

http://IP_ADDRESS:PORT/hello/
http://IP_ADDRESS:PORT/hello/health
```

PORTS: 
```
JAVA   : 8080
KOTLIN : 8080
PYTHON : 5000
NODE   : 3000
```


### Guides
RESTFul Java Services for deployment in AWS/GCP/Azure cloud environment. 


# Read Me First
When managing external properties in a container-based deployment environment, it's crucial to follow best practices to ensure security, flexibility, and ease of management. Here’s a structured approach to managing and configuring external properties:

Use Environment Variables:

- **Advantages**: Environment variables are a common method for injecting configuration into containers because they are easy to manage, support different types of values, and are accessible by applications without changes to application code.
- **Implementation**: Set environment variables either in your container orchestration platform (like Kubernetes ConfigMaps or Docker Swarm secrets) or directly in your container definition files (Dockerfile or Kubernetes YAML).


Step-by-Step Example: Using Environment Variables in Docker with Spring Boot
1. Modify application.properties or application.yml
   In your Spring Boot application's configuration file (src/main/resources/application.properties or src/main/resources/application.yml), replace sensitive information with placeholders that will be supplied via environment variables.

For example, in application.properties:

```
simulation.datasource.url=${DATABASE_URL}
simulation.datasource.username=${DATABASE_USERNAME}
simulation.datasource.password=${DATABASE_PASSWORD}
```
2. Dockerfile Configuration
   Create a Dockerfile in the root of your Spring Boot project to build a Docker image for your application. Here’s a basic example:

```
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
```
3. Build the Docker Image
   Navigate to the directory containing your Dockerfile and build the Docker image:
```
docker build -t devopsjava .
```

4. Run the Docker Container
   Run the Docker container, ensuring you pass the required environment variables (DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD) using the -e option:

```
docker run -p 8080:8080 devopsjava


docker run -d \
-e DATABASE_URL=jdbc:mysql://localhost:3306/mydatabase \
-e DATABASE_USERNAME=myuser \
-e DATABASE_PASSWORD=mypassword \
-p 8080:8080 \
devopsjava
```
-d: Runs the container in detached mode (in the background).
-e: Specifies environment variables for your Spring Boot application.
-p: Maps port 8080 from the container to port 8080 on the host machine (adjust as needed).



# Push to Dockerhub
```
docker login
docker build -t devopsjava .
docker tag devopsjava santoshmondal/devopsjava:latest
docker push santoshmondal/devopsjava:latest
```

# Specify the platform
```
docker login
docker buildx create --use
docker buildx inspect --bootstrap

docker buildx build --platform linux/amd64,linux/arm64 -t santoshmondal/devopsjava:latest --push .
docker buildx build --platform linux/amd64,linux/arm64 -t santoshmondal/devopsjava:1.0.1 --push .

docker run -p 8080:8080 santoshmondal/devopsjava
```







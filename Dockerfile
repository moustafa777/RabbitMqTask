# Use the official Gradle image to create a build artifact.
# This is a multi-stage build. In the first stage we're just building the JAR file.
FROM gradle:jdk17 as builder

# Set the working directory inside the container to /app
WORKDIR /app

# Copy the source code into the container
COPY . .

# Use Gradle to build the project, skipping tests
RUN gradle clean build -x test --no-daemon

# Now, we set up the second stage to set up the runtime container.
FROM openjdk:17-jdk

# Set the working directory in this stage to /app
WORKDIR /app

# Copy the JAR from the previous stage into the current stage
COPY --from=builder /app/build/libs/*.jar RabbitQTask.jar

# Expose port 8080 to the outside world
EXPOSE 8080

# Run the Spring Boot application
CMD ["java", "-jar", "RabbitQTask.jar"]

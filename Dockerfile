# Start from the jre-alpine base image
from java:8-jre-alpine

# Copy the generated artefact into the container
COPY target/hello-java.jar /home/hello-java.jar

# Make port 80 available to the world outside this container
EXPOSE 8080

# Define environment variable
ENV NAME Hello-Java

# Run the application when the container starts
CMD ["java", "-jar", "/home/hello-java.jar"]
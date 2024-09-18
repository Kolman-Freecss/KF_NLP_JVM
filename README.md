# **NLP Application with Spring Boot, Docker, Kubernetes, and Jenkins**

This project demonstrates how to build a simple **Java** backend application using **Spring Boot** that integrates a Natural Language Processing (NLP) model for sentiment analysis via a REST API. The application is containerized using **Docker** and deployed to **Kubernetes**. Continuous Integration/Continuous Deployment (CI/CD) is handled by **Jenkins**.

## **Features**
- **REST API** built with **Spring Boot** to process NLP tasks.
- **Docker** containerization for easy deployment.
- **Kubernetes** deployment for scalability.
- **Jenkins** pipeline for automated build, test, and deployment.
- Integration with **Hugging Face API** for NLP (sentiment analysis).

## **Prerequisites**

- **Java 11** or higher installed.
- **Maven** for building the project.
- **Docker** installed for containerization.
- **Kubernetes** cluster for deployment (can use **minikube** for local testing).
- **Jenkins** setup for CI/CD.
- **Hugging Face API key** for accessing NLP services.

## **Getting Started**

1. Clone the Repository
2. Setting up the Hugging Face API**

- Sign up at [Hugging Face](https://huggingface.co/) and get an API key. You will need this to perform sentiment analysis.

3. Build the Spring Boot Application**

```bash
mvn clean package
```
4. Kubernetes Deployment**

You can deploy the Docker container to Kubernetes using the provided \`deployment.yaml\`:

```bash
kubectl apply -f deployment.yaml
```

This will create a **Deployment** with 2 replicas of your application, and expose it as a **LoadBalancer** service.

6. Jenkins Setup for CI/CD**

You can automate the build and deployment process using **Jenkins**. The **Jenkinsfile** provided in the project will help automate:
- Building the project.
- Creating the Docker image.
- Deploying it to the Kubernetes cluster.


7. Running the Application Locally**

You can also run the application locally without Docker or Kubernetes:

```bash
java -jar target/my-app.jar
```

### **9. API Usage**

The application exposes a REST endpoint \`/api/analyze\` to perform sentiment analysis. You can send a POST request with a text payload to this endpoint.

#### Example Request:

```bash
curl -X POST http://localhost:8080/api/analyze \
     -H "Content-Type: application/json" \
     -d '{"text":"I love this product!"}'
```

#### Example Response:

```
{
  "label": "POSITIVE",
  "score": 0.999
}
```

## **Project Structure**
- **src/main/java**: Source code for the Spring Boot application.
- **Dockerfile**: Instructions to build the Docker image.
- **deployment.yaml**: Kubernetes deployment configuration.
- **Jenkinsfile**: Pipeline configuration for Jenkins.
- **run.sh**: Script for manual build and deployment.

## **Technologies Used**
- **Java** (Spring Boot)
- **Docker**
- **Kubernetes**
- **Jenkins**
- **Hugging Face API**

## **Future Improvements**
- Add more advanced NLP tasks like text summarization or classification.
- Implement more complex Jenkins pipelines for testing and monitoring.
- Integrate **Helm** charts for Kubernetes deployment.
- Add monitoring and logging solutions like **Prometheus** and **Grafana**.

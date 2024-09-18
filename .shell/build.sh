#!/bin/bash
echo "Building and deploying the application"
mvn clean package
docker build -t my-nlp-image:latest .
kubectl apply -f deployment.yaml

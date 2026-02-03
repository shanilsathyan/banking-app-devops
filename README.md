📘 Banking Application – End-to-End DevOps Project
📌 Project Overview

This project demonstrates a complete DevOps lifecycle for a Spring Boot–based Banking application, implemented using Azure VMs, Jenkins CI/CD, Docker, Kubernetes (kubeadm), and Prometheus & Grafana monitoring.
The application is deployed on a multi-node Kubernetes cluster (1 master + 3 worker nodes) with CI/CD automation and monitoring.

🛠️ Tech Stack
Application
•	Java 17
•	Spring Boot
•	Spring Data JPA
•	H2 In-Memory Database
•	DevOps & Cloud
•	Azure Virtual Machines (Free Tier)
•	Jenkins (Pipeline as Code)
•	Docker
•	Kubernetes (kubeadm cluster)
•	Helm
•	Prometheus & Grafana
•	GitHub Webhooks


⚙️ CI/CD Pipeline Flow (Jenkins)
1.	Code Commit to GitHub
2.	GitHub Webhook triggers Jenkins automatically
3.	Jenkins Pipeline stages:
o	Checkout source code
o	Maven build & test
o	Generate test reports
o	Docker image build
o	Push image to Docker Hub
o	Deploy/update application in Kubernetes
4.	Kubernetes performs rolling update of pods

☸️Kubernetes Setup
•	Cluster created using kubeadm
•	Nodes:
o	1 Master Node
o	3 Worker Nodes
•	Application deployed using:
o	Deployment
o	NodePort Service
o	ConfigMap & Secret
•	Health management:
o	Readiness & Liveness probes
•	Scaling:
o	Horizontal Pod Autoscaler (HPA) using Metrics Server

🔐 Configuration Management
•	ConfigMaps used for:
o	Spring application configuration
•	Secrets used for:
o	Database credentials
•	Environment variables injected into pods

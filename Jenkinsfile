pipeline {
    agent any

    environment {
        JAVA_HOME = "/usr/lib/jvm/java-17-openjdk-amd64"
        PATH = "${JAVA_HOME}/bin:${env.PATH}"
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                sh '''
		     echo "=== Java used by Jenkins ==="
                     java -version
                     echo "=== Maven environment ==="
		     mvn -v
                     mvn clean package
                '''
            }
        }

        stage('Archive Test Report') {
            steps {
                archiveArtifacts artifacts: 'target/reports/**', fingerprint: true, allowEmptyArchive: true
            }
        }

        stage('Docker Build') {
            steps {
                sh '''
                    echo "=== Building Docker Image ==="
                    docker build -t banking-app:1.0 .
                '''
            }
        }
    }
}

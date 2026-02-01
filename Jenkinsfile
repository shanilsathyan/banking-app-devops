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
	stage('Docker Push') {
	    steps {
        	withCredentials([usernamePassword(
            	credentialsId: 'dockerhub-creds',
            	usernameVariable: 'DOCKER_USER',
            	passwordVariable: 'DOCKER_PASS'
       		 )]) {
           	 sh '''
                echo "$DOCKER_PASS" | docker login -u "$DOCKER_USER" --password-stdin

                docker tag banking-app:1.0 $DOCKER_USER/banking-app:1.0
                docker tag banking-app:1.0 $DOCKER_USER/banking-app:latest

                docker push $DOCKER_USER/banking-app:1.0
                docker push $DOCKER_USER/banking-app:latest
            '''
        }
    }
}

    }
}

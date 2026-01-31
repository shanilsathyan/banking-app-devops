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
                    mvn clean test surefire-report:report
                '''
            }
        }

        stage('Archive Test Report') {
            steps {
                archiveArtifacts artifacts: 'target/reports/**', fingerprint: true
            }
        }
    }
}

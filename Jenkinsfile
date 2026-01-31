pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                sh 'mvn clean test surefire-report:report'
            }
        }

        stage('Archive Test Report') {
            steps {
                archiveArtifacts artifacts: 'target/reports/**', fingerprint: true
            }
        }
    }
}

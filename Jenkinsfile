pipeline {
    agent {
        label 'alpine'
    }
    tools {
        maven '3.9.7'
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Create Docker Image') {
            steps {
                script {
                    docker.build('jenkins-exercise:0.0.1')
                }
            }
        }
    }
}

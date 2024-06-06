pipeline {
    agent {
        label 'alpine'
    }
    tools {
        dockerTool 'docker'
        maven '3.9.7'
        git 'Default'
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
                    docker.withRegistry('${ DOCKER_HOST }') {
                        docker.build('jenkins-exercise:0.0.1')
                    }
                }
            }
        }
    }
}

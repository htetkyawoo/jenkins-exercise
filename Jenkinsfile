pipeline {
    agent {
        label 'jenkins_alpine_agent'
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
                docker.build('jenkins-exercise:0.0.1')
            }
        }
    }
}

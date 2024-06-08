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
        stage('Check image And Delete') {
            steps {
                sh 'docker image ls | grep jenkins-exercise:0.0.1 | docker rm jenkins-exercise:0.0.1'
            }
        }
        stage('Create Docker Image') {
            steps {
                sh 'docker build -t jenkins-exercise:0.0.1 .'
            }
        }
        stage('Run Container') {
            sh 'docker run jenkins-exercise:0.0.1'
        }
    }
}

pipeline {
    agent any
    tools {
        maven 'maven_3_5_0'
    }
    stages {
        stage ('Build Maven'){
            step{
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/htetkyawoo/jenkins-exercise.git']])
                sh 'mvn clean install'
            }
        }

    }
}
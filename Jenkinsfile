pipeline {
    agent any
    stages {
        stage('Build Maven') {
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/htetkyawoo/jenkins-exercise.git']])
                sh 'mvn clean install'
            }
        }
    }
}

pipeline {
    agent any
    stages {
        stage('Build Maven') {
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/htetkyawoo/jenkins-exercise.git']])
                withMaven {
                    sh 'mvn clean install'
                }
            }
        }
    }
}

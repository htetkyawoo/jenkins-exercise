pipeline {
    node {
        docker.withServer('tcp://172.18.0.3:2375', '') {
            docker.image('maven').withRun('-v C:/Users/USER/.m2:/root/.m2') {
            }
        }
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
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
    }
}

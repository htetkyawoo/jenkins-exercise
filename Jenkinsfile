pipeline {
    environment {
        imageName = 'jenkins-exercise:0.0.1'
    }
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
        stage('Stop and Remove Running Container ') {
            steps {
                script {
                    def RunningID = sh(
                            script: 'docker container ls -aq -f status=running -f ancestor=\${imageName}',
                            returnStdout: true
                    )
                    RunningID = RunningID.replaceAll('(\\t|\\r?\\n)+', ' ')
                    echo "Running Containers : ${RunningID}"
                    if ("${RunningID}" != '') {
                        echo "Stopping ${RunningID} ..."
                        sh "docker stop ${RunningID}"
                        echo "Stopped ${RunningID}"
                    }else {
                        echo 'No Container is Running'
                    }
                    def CreatedID = sh(
                        script: 'docker container ls -aqf ancestor=\${imageName}',
                        returnStdout: true
                    )
                    CreatedID = CreatedID.replaceAll('(\\t|\\r?\\n)+', ' ')
                    if ("${CreatedID}" != '') {
                        echo "Removing ${CreatedID} ..."
                        sh "docker rm ${CreatedID}"
                        echo "Removed ${CreatedID}"
                    }else {
                        echo 'No Container to remove'
                    }
                }
            }
        }
        stage('Checking Image and Delete') {
            steps {
                script {
                    def oldImageID = sh(
                                            script: 'docker images -qf reference=\${imageName}',
                                            returnStdout: true
                                        )

                    echo 'Image Name: ' + "${imageName}"
                    echo "Old Image: ${oldImageID}"

                    if ("${oldImageID}" != '') {
                        echo "Deleting image id: ${oldImageID}..."
                        sh "docker rmi -f ${oldImageID}"
                    } else {
                        echo 'No image to delete...'
                    }
                }
            }
        }
        stage('Create Docker Image') {
            steps {
                sh 'docker build -t jenkins-exercise:0.0.1 .'
            }
        }
        stage('Run Container') {
            steps {
                sh 'docker run -d -p 8080:8080 jenkins-exercise:0.0.1'
            }
        }
    }
}

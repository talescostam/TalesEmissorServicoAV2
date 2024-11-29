pipeline {
    agent any

    environment {
        DOCKER_IMAGE = 'talesemissormicroservico'
    }

    stages {
        stage('Build') {
            steps {
                script {
                    // Clean and package the application using Maven
                    sh 'mvn clean package'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    // Build the Docker image
                    sh "docker build -t ${DOCKER_IMAGE} ."
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                script {
                    // Push the Docker image to a registry (e.g., Docker Hub)
                    sh "docker tag ${DOCKER_IMAGE} talescostam${DOCKER_IMAGE}"
                    sh "docker push talescostam/${DOCKER_IMAGE}"
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    // Deploy the Docker container
                    sh "docker run -d -p 8083:8083 ${DOCKER_IMAGE}"
                }
            }
        }
    }
}
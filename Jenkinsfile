pipeline {
    agent any

    tools {
        maven "Maven" // Replace "Maven" with the Maven version configured in Jenkins
        jdk "jdk"     // Replace "jdk" with the JDK version configured in Jenkins
    }

    environment {
        DOCKER_IMAGE_NAME = 'calculator'
        GITHUB_REPO_URL = 'https://github.com/Priyansuvaish/calculator_final.git'
        SONAR_PROJECT_KEY = 'calculator_final'
        SONAR_PROJECT_NAME = 'calculator_final'
        SONAR_HOST_URL = 'http://localhost:9000'
        SONAR_TOKEN = 'sqp_c8bb2fe655dfe32984cb510d2fccd69ffb3e2776' // Replace with your actual token
    }

    stages {
        stage('Checkout') {
            steps {
                script {
                    git branch: 'master', url: "${GITHUB_REPO_URL}"
                }
            }
        }

        stage('Build') {
            steps {
                script {
                    mvnHome = tool 'Maven' 
                    sh "${mvnHome}/bin/mvn clean package"
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    sh "${mvnHome}/bin/mvn test"
                }
            }
        }

        stage('SonarQube Analysis') {
            steps {
                script {
                    withSonarQubeEnv('SonarQube') { // Ensure 'SonarQube' matches your Jenkins server configuration
                        sh """
                        ${mvnHome}/bin/mvn clean verify sonar:sonar \
                            -Dsonar.projectKey=${SONAR_PROJECT_KEY} \
                            -Dsonar.projectName=${SONAR_PROJECT_NAME} \
                            -Dsonar.host.url=${SONAR_HOST_URL} \
                            -Dsonar.token=${SONAR_TOKEN}
                        """
                    }
                }
            }
        }

        stage('Archive') {
            steps {
                archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
            }
        }

        // Uncomment below stages to enable Docker and Ansible steps
        // stage('Build Docker Image') {
        //     steps {
        //         script {
        //             docker.build("${DOCKER_IMAGE_NAME}", '.')
        //         }
        //     }
        // }

        // stage('Push Docker Image') {
        //     steps {
        //         script {
        //             docker.withRegistry('', 'docker-hub-credentials-id') { // Replace with your Jenkins credential ID
        //                 sh 'docker tag calculator <your-dockerhub-username>/calculator:latest'
        //                 sh 'docker push <your-dockerhub-username>/calculator:latest'
        //             }
        //         }
        //     }
        // }

        // stage('Run Ansible Playbook') {
        //     steps {
        //         script {
        //             ansiblePlaybook(
        //                 playbook: 'deploy.yml',
        //                 inventory: 'inventory'
        //             )
        //         }
        //     }
        // }
    }

    post {
        success {
            echo 'Build succeeded.'
        }
        failure {
            echo 'Build failed.'
        }
    }
}

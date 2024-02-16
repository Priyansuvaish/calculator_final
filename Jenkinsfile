pipeline {
    agent any

    tools {
        maven "Maven" 
        jdk "jdk" 
    }
  environment {
        GITHUB_REPO_URL = 'https://github.com/Priyansuvaish/Calculator.git'
    }

    stages {
        stage('Checkout') {
            steps {
                script {
                    // Checkout the code from the GitHub repository
                    git branch: 'master', url: "${GITHUB_REPO_URL}"
                }
            }
        }

        stage('Build') {
            steps {
                // Run Maven build
                script {
                    mvnHome = tool 'Maven' // Retrieves the Maven installation configured in Jenkins global tools
                    sh "${mvnHome}/bin/mvn clean package"
                }
            }
        }

        stage('Test') {
            steps {
                // Run tests
                script {
                    sh "${mvnHome}/bin/mvn test"
                }
            }
        }

        stage('Archive') {
            steps {
                // Archive the built artifacts
                archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
            }
        }
    }

    post {
        // Define actions to take in case of build failure or success
        success {
            echo 'Build succeeded.'
        }
        failure {
            echo 'Build failed.'
        }
    }
}

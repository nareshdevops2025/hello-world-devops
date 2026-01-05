pipeline {
  agent any

  tools {
        maven 'maven-3'
        jdk 'JDK'
    }

  environment {
    IMAGE_NAME = "hello-world"
    REGISTRY = "localhost:5000"
  }

  stages {

    stage('Checkout') {
      steps {
        git branch: 'main',
            url: 'https://github.com/nareshdevops2025/hello-world-devops.git'
      }
    }

      stage('Build Image') {
            steps {
                dir('app') {
                    sh 'mvn clean package -DskipTests'
                }
            }
        }

     stage('SonarQube') {
      steps {
         dir('app') {
                   sh 'mvn sonar:sonar'
                }
      }
    }
    /*stage('Scan Image') {
      steps {
        sh 'trivy image $REGISTRY/$IMAGE_NAME:${BUILD_NUMBER}'
      }
    }

    stage('Push Image') {
      steps {
        sh 'docker push $REGISTRY/$IMAGE_NAME:${BUILD_NUMBER}'
      }
    }

    stage('Deploy to Dev') {
      steps {
        sh 'helm upgrade --install hello ./helm --namespace dev'
      }
    }

    stage('Prod Approval') {
      steps {
        input "Deploy to Production?"
      }
    }

    stage('Deploy to Prod') {
      steps {
        sh 'helm upgrade --install hello ./helm --namespace prod'
      }
    } */
  }
}

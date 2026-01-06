pipeline {
  agent any

  tools {
        maven 'maven-3'
        jdk 'JDK'
    }

  environment {
    IMAGE_NAME = "hello-world"
    REGISTRY = "localhost:5000"
    SONAR_HOST_URL = 'http://localhost:9000'
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

     stage('sonar') {
      steps {
         dir('app') {
           withSonarQubeEnv('sonar') {
             sh 'mvn -U clean verify sonar:sonar -Dsonar.projectKey=helloword-devops -Dsonar.host.url=http://localhost:9000 -Dsonar.login=sqp_2518aa810088c1d42a1a9ebb83612e6f111f0be1'
         }
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

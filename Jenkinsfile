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

    stage('Unit Tests') {
      steps {
       sh 'cd app && mvn clean package'
      }
    }

    stage('Build Image') {
      steps {
        sh '''
        mvn clean package -DskipTests
        docker build -t $REGISTRY/$IMAGE_NAME:${BUILD_NUMBER} .
        '''
      }
    }

    stage('Scan Image') {
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
    }
  }
}

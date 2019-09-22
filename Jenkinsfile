pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh 'mvn install -DskipTests'
                sh 'chmod a+x src/test/resources/chromedriver'
            }
        }
        stage('Junit test prep'){
            steps {
                sh 'docker-compose down'
            }
        }
        stage('Junit Tests') {
            steps {
                sh 'mvn test -Dtest=AppControllerServiceSuite'
            }
        }
        stage('Deploy') {
            steps {
                sh 'docker-compose build'
                sh 'docker-compose up -d'
            }
        }
        stage('Selenium Tests') {
            steps {
                sh 'mvn test -Dtest=SeleniumSuite'
            }
        }
    }
}
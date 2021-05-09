pipeline {
    agent any
    stages {
        stage ('Build Backend') {
            steps {
                bat 'mvn clean package -DskipTests=true'
            }
        }
        stage ('Unit Tests') {
            steps {
                bat 'mvn test'
            }
        }
        stage ('Deploy Backend') {
            steps {
                deploy adapters: [tomcat8(credentialsId: 'TomCatLogin', path: '', url: 'http://localhost:8001/')], contextPath: 'tasks-backend', war: 'target/tasks-backend.war'
            }
        }
        stage ('API Test') {
            steps {
                dir('api-test') {
                    git 'https://github.com/RonaldoFaustino/tasks-api-test.git'
                    bat 'mvn test'
                }
            }
        }
        stage ('Deploy Frontend') {
            steps {
                dir('frontend') {
                    git 'https://github.com/RonaldoFaustino/tasks-frontend'
                    bat 'mvn clean package -DskipTests=true'
                    deploy adapters: [tomcat8(credentialsId: 'TomCatLogin', path: '', url: 'http://localhost:8001/')], contextPath: 'tasks', war: 'target/tasks.war'
                }  
            }
        }
        stage ('Functional Test') {
            steps {
                dir('functional-test') {
                    git 'https://github.com/RonaldoFaustino/tasks-funcional-tests'
                    bat 'mvn test'
                }
            }
        }
        stage ('Deploy Prod') {
            steps {
                bat 'docker-compose build'
                bat 'docker-compose up -d'
            }
        }
        stage ('Health Ckeck') {
            steps {
                sleep(5)
                dir('functional-test') {
                    bat 'mvn verify -Dskip.surefire.tests'
                }
            }
        }
    }
}



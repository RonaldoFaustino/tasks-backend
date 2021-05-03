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
        stage ('Sonar Analisys') {
            environment {
                scannerHome = tool 'SONAR_SCANNER'
            }
            steps {
                withSonarQubeEnv('SONAR_LOCAL') {
                    bat "${scannerHome}/bin/sonar-scanner -e -Dsonar.projectKey=DeployBack -Dsonar.host.url=http://localhost:9000 -Dsonar.login=6a36373c8a974b24d0caf5e16be39dbf1456120f -Dsonar.java.binaries=target -Dsonar.coverage.exclusions=**MavenWrapperDownloader.java,**/src/test/**,**/model/**,**Aplication.java"
                }                
            }
        }
    }
}


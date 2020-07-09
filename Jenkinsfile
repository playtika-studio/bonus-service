pipeline {
    agent any

    tools {
        maven "M3"
    }

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git branch: 'bonus-docker', url: 'https://github.com/playtika-studio/bonus-service.git'

                // Run Maven on a Unix agent.
                sh "mvn clean install"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                                    junit '**/target/surefire-reports/TEST-*.xml'
                                    archiveArtifacts 'target/*.jar'
                        }
            }
        }
    }
}
pipeline {
    agent any
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }

        stage ('Build') {
            steps {
                sh 'mvn clean package'
            }
            post {
                 always {
                       junit 'target/surefire-reports/**/*.xml'
                 }

                success {
                     mail cc: "${env.ATTENDENCE_EMAIL_TUSI}", body: "<b>Attendance Check-in/out successfully from pipeline</b><br>Build Number: ${env.BUILD_NUMBER}<br>Build URL: ${env.BUILD_URL}", bcc: '', charset: 'UTF-8', from: '', mimeType: 'text/html', replyTo: '', subject: "Office Check-in/out notification from pipeline", to: "shariba@surecash.net";

                }

                failure {
                                    mail bcc: "${env.ATTENDENCE_EMAIL_TUSI}", body: "<b></b><br>Project: ${env.JOB_NAME} <br>Build Number: ${env.BUILD_NUMBER} <br>Build URL: ${env.BUILD_URL}", cc: '', charset: 'UTF-8', from: '', mimeType: 'text/html', replyTo: '', subject: "ERROR CI: Project name -> ${env.JOB_NAME}", to: "shariba@surecash.net";
                         }

            }

        }

    }
}
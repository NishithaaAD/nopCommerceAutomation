node {

    stage('Checkout') {
        checkout scm
    }

    stage('Clean') {
        bat 'mvn clean'
    }

    stage('Execute TestNG Tests') {
        bat 'mvn test'
    }

    stage('Publish Results') {
        junit '**/target/surefire-reports/*.xml'
    }

}

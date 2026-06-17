node {

    stage('Checkout') {
        checkout scm
    }

    stage('Clean') {
        bat 'mvn clean -Dmaven.repo.local=C:\\Users\\adhav\\.m2\\repository'
    }

    stage('Execute TestNG Tests') {
        bat 'mvn test -Dmaven.repo.local=C:\\Users\\adhav\\.m2\\repository'
    }

    stage('Publish Results') {
        junit '**/target/surefire-reports/*.xml'
    }
}

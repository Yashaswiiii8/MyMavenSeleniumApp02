pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Yashaswiiii8/MyMavenSeleniumApp02.git'
            }
        }

        stage('Run Selenium') {
            steps {
                sh 'mvn clean compile exec:java -Dexec.mainClass="com.example.App"'
            }
        }
    }

    post {
        success {
            echo 'Selenium executed successfully ✅'
        }
        failure {
            echo 'Selenium execution failed ❌'
        }
    }
}

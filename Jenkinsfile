pipeline {
    agent any
    tools{
        maven 'apache-maven-3.9.1'
    }

    stages{
        stage('Build'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: 'desarrollo']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/DRosero/PruebaDevsu']]])
                sh 'mvn clean install'
            }
        }
        stage('Build docker image'){
            steps{
                script{
                    sh 'docker build --tag devsu .'
                }
            }
        }

        /*stage('Push image to Hub'){
            steps{
                script{
                   withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockerhubpwd')]) {
                   sh 'docker login -u javatechie -p ${dockerhubpwd}'

}
                   sh 'docker push javatechie/devops-integration'
                }
            }
        }*/
        stage('Deploy to k8s'){
            steps{
                script{
                    kubernetesDeploy (configs: 'DeploymentServiceK8S.yml.yml',kubeconfigId: 'k8sconfigpwd')
                }
            }
        }
    }
}
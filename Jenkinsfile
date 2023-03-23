pipeline {
    agent any
    tools{
        maven 'apache-maven-3.9.1'
    }

    stages{

        stage('SonarQube Analysis') {
            steps{
                script{
                    withSonarQubeEnv(credentialsId: 'jenkins-sonar') {
                    sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.9.1.2184:sonar'
                    //sh 'mvn sonar:sonar'
                    }
                }
            }
        }

        stage('Build'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: 'desarrollo']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/DRosero/PruebaDevsu']]])
                sh 'mvn clean install'
            }
        }

        stage('Build docker image'){
            steps{
                script{
                    sh 'docker build --tag drosero01/devsu .'
                }
            }
        }

        stage('Push image to Docker Hub'){
            steps{
                script{
                    withCredentials([string(credentialsId: 'dockerhub-pas', variable: 'dockerhubpass')]) {
                        sh 'docker login -u drosero01 -p ${dockerhubpass}'
                    }
                   sh 'docker push drosero01/devsu'
                }
            }
        }

        stage('Create namespace'){
                    steps{
                        script{
                            kubernetesDeploy(configs: 'namespace.yml', kubeconfigId: 'devsuk8s')
                        }
                    }
        }

        stage('Deploy to k8s'){
            steps{
                script{
                    kubernetesDeploy(configs: 'deploymentservicek8s.yml', kubeconfigId: 'devsuk8s')
                }
            }
        }

        /*stage('Create ingress'){
                    steps{
                        script{
                            kubernetesDeploy(configs: 'ingress.yml', kubeconfigId: 'devsuk8s')
                        }
                    }
                }*/

    }
}
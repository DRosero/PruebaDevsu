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

        stage('SonarQube Analysis') {
            withSonarQubeEnv(credentialsId: 'jenkins-sonar') {
                sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.7.0.1746:sonar'
            }
        }

        /*stage('Build docker image'){
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
        stage('Deploy to k8s'){
            steps{
                script{
                    kubernetesDeploy(configs: 'deploymentservicek8s.yml', kubeconfigId: 'devsuk8s')
                        //sh 'kubectl apply -f deploymentservicek8s.yml --context minikube'
    // some block


                    //sh "kubectl get pods"


                    //kubernetesDeploy configs: '', kubeConfig: [path: ''], kubeconfigId: 'devsuk8sp', secretName: '', ssh: [sshCredentialsId: '*', sshServer: ''], textCredentials: [certificateAuthorityData: '', clientCertificateData: '', clientKeyData: '', serverUrl: 'https://']

                }
            }
        }*/
    }
}
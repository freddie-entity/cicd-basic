def gv

pipeline {
    agent any
    tools { 
      maven 'maven-3.8' 
    }
    stages {
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                    // sh "Pipeline in branch $BRANCH_NAME"
                }
            }
        }
        stage("build jar") {
            steps {
                script {
                    gv.buildJar()
                }
            }
        }
        stage("build image") {
            steps {
                script {
                    gv.buildImage()
                }
            }
        }
        stage("deploy") {
            when {
                expression {
                    BRANCH_NAME == 'main'
                }
            }
            steps {
                script {
                    gv.deployApp()
                }
            }
        }
    }   
}

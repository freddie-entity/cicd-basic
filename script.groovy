def buildJar() {
    echo "building the application..."
    sh 'mvn package'
} 

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]) {
        sh 'docker build -t freddieentity/java-maven:1.0 .'
        sh "echo $PASSWORD | docker login -u $USERNAME --password-stdin"
        sh 'docker push freddieentity/java-maven:1.0'
    }
} 

def deployApp() {
    echo 'deploying the application...'
} 

def skipDeploy() {
    echo 'skipping deploy stage...'
}

return this

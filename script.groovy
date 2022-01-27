def buildJar() {
    echo "building the application..."
    sh 'mvn package'
} 

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'DOCKER_CREDENTIALS', passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]) {
        sh 'docker build -t freddieentity/java-maven:1.0 .'
        sh "echo $PASSWORD | docker login -u $USERNAME --password-stdin"
        sh 'docker push freddieentity/java-maven:1.0'
    }
} 

def deployApp() {
    echo 'deploying the application...'
} 

return this

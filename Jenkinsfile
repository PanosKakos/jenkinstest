node {
    stage 'Clone the project'
    git 'https://github.com/PanosKakos/jenkinstest.git'
   
   
        stage("Compilation ") {
                sh "./mvnw clean install "
        }
         
         stage("Testing stage ") {
                sh "echo $hello"
        }
            
}

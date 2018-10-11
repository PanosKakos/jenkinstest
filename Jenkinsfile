node {
    stage 'Clone the project'
    git 'https://github.com/PanosKakos/jenkinstest.git'
   
   
        stage("Compilation ") {
                sh "mvn clean install -Dmaven.test.skip=true "
        }
         
         stage("Testing stage ") {
                sh "echo $hello"
        }
            
}

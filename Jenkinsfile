node {
    stage 'Clone the project'
    git 'https://github.com/PanosKakos/jenkinstest.git'
   
   
        stage("Compilation ") {
                sh "mvn clean install -Dmaven.test.skip=true "
        }
         
         stage("Show simple message ") {
                sh "echo finished"
        }
    
    stage("Running tests"){
     sh "mvn test"
    }
            
}

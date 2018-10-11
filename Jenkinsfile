node {
    stage 'Clone the project'
    git 'https://github.com/PanosKakos/jenkinstest.git'
   
   
        stage("Compilation ") {
                sh "mvn clean install -Dmaven.test.skip=true "
        }
             
    stage("Running Unit tests"){
     sh "mvn test"
    }
    
    stage("Slack Notification"){
        slackNotifier(currentBuild.currentResult)
    }
            
}

    def call(String buildResult) {
  if ( buildResult == "SUCCESS" ) {
    slackSend color: "good", message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_NUMBER} was successful"
  }
  else if( buildResult == "FAILURE" ) { 
    slackSend color: "danger", message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_NUMBER} was failed"
  }
  else if( buildResult == "UNSTABLE" ) { 
    slackSend color: "warning", message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_NUMBER} was unstable"
  }
  else {
    slackSend color: "danger", message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_NUMBER} its resulat was unclear"	
  }
}

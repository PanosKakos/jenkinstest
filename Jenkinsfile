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
        script{
            echo '$will send slack not...'
        }
     slackSend baseUrl: 'https://hooks.slack.com/services/', 
         channel: '#jenkinschannel', 
         color: 'good',
         message: 'Build message to Panos', 
         tokenCredentialId: 'slack-demo'
    
    }
            
}



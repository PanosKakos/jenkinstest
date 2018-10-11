node {
    
   environment {
      ORG 		        = 'jenkinsx'
      APP_NAME          = 'test-spring-boot-app'
      GIT_CREDS         = credentials('jenkins-x-git')
      CHARTMUSEUM_CREDS = credentials('jenkins-x-chartmuseum')

      GIT_USERNAME      = "$GIT_CREDS_USR"
      GIT_API_TOKEN     = "$GIT_CREDS_PSW"
      JOB_NAME          = "$JOB_NAME"
      BUILD_NUMBER      = "$BUILD_NUMBER"
    }
    
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
         message: 'Build message to Panos for build:' + BUILD_NUMBER, 
         tokenCredentialId: 'slack-demo'
    
    }
            
}



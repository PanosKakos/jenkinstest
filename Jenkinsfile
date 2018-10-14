node {
    
   environment {
      REPO              = "https://github.com/PanosKakos/jenkinstest.git"
      APP_NAME          = 'test-spring-boot-app'
      JOB_NAME          = "$JOB_NAME"
      BUILD_NUMBER      = "$BUILD_NUMBER"
    }
    
    stage ("Clone the project"){
        git 'https://github.com/PanosKakos/jenkinstest.git'
    }
    stage("Compilation ") {
         sh "mvn clean install -Dmaven.test.skip=true "
    }
    stage("Checkstyle") {
           sh "./mvnw checkstyle:checkstyle"
                    step([$class: 'CheckStylePublisher',
                      canRunOnFailed: true,
                      defaultEncoding: '',
                      healthy: '100',
                      pattern: '**/target/checkstyle-result.xml',
                      unHealthy: '90',
                      useStableBuildAsReference: true
                    ])
    }
             
    stage("Running Unit tests"){
             try {
                     sh "./mvnw test -Punit"  
             } catch(err) {
                     step([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/TEST-*UnitTest.xml'])
                     throw err
             }
                     step([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/TEST-*UnitTest.xml'])
  }
    
  stage("Runing integration tests") {
           try {
                sh "./mvnw test -Pintegration"
           } catch(err) {
                step([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/TEST-'+ '*IntegrationTest.xml'])
                throw err
           }
                step([$class: 'JUnitResultArchiver', testResults:  '**/target/surefire-reports/TEST-'+ '*IntegrationTest.xml'])
}

stage("Deploy and run Application") {
                sh "pid=\$(lsof -i:8989 -t); kill -TERM \$pid "
                  + "|| kill -KILL \$pid"
                withEnv(['JENKINS_NODE_COOKIE=dontkill']) {
                    sh 'nohup ./mvnw spring-boot:run -Dserver.port=8989 &'
                }   
            }
    
 stage("Slack Notification"){
             slackSend baseUrl: 'https://hooks.slack.com/services/', 
                 channel: '#jenkinschannel', 
                 color: 'good',
                 message: 'Build message to Panos for build:' + BUILD_NUMBER, 
                 tokenCredentialId: 'slack-demo'
    
    }
            
}



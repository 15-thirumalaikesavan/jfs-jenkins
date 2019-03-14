#PIPELINE
[PipelineProject] springbootapp-pipeline

##github checkout
Sample Step > step: git: Git
Repository URL : https://github.com/crafted-coded/jfs-jenkins.git
Branch master
[script] git 'https://github.com/crafted-coded/jfs-jenkins.git'

##execute maven pipeline job
[configure] Piepline > Pipeline Syntax > Sample Step
bat: Windows Batch Script
mvn clean package

[script] bat label: '', script: 'mvn clean package'

##archiving
Sample Step > step: General Build Step
archive: Archive artifacts
Files to archive cs01a-springboot-unittest/target/_
[script] archiveArtifacts 'target/*.jar'

##node
node: Allocate node
node {
// some block
}

##dir
dir: Change current directory
dir('cs01a-springboot-unittest') {

}

[script]
node {
git 'https://github.com/crafted-coded/jfs-jenkins.git'
dir('cs01a-springboot-unittest') {
bat label: '', script: 'mvn clean package'
archiveArtifacts 'target/*.jar'  
}
}

#stages
stage: Stage

[script]
node {
stage 'checkout'
git 'https://github.com/crafted-coded/jfs-jenkins.git'

dir('cs01a-springboot-unittest') {
stage 'compile, test & package'
bat label: '', script: 'mvn clean package'
stage 'archive'
    archiveArtifacts 'target/*.jar'  
}
}

#triggers
Build Triggers
Poll SCM
Schedule * * * * * (every minute)
[verify] make changes to project, commit to github

https://linuxconfig.org/linux-crontab-reference-guide


#READY RECKONER

To clear build history
delete content under below folder and restart jenkins
C:\Program Files (x86)\Jenkins\jobs\springbootapp-pipeline<projectname>

[ArchiveLocation] C:\Program Files (x86)\Jenkins\jobs\springbootapp-pipeline\builds\(buildno)\archive



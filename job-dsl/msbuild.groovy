job('MSBuild Test') {
  scm {
    git {
      remote {
        github('git@github.com:ecg-protool/REGAIT.MX.git', 'ssh')
        credentials('jenkins-ssh')
      }
    }
  }
  triggers {
    scm('H/5 * * * *')
  }
  steps {
    msBuild {
      msBuildInstallation('MSBuild-14')
      buildFile('MX.sln')
    }
  }
}
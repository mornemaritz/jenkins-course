job('MSBuild Test') {
  scm {
    git {
      remote {
        github('ecg-protool/REGAIT.MX.git', 'ssh')
        credentials('jenkins-ssh')
      }
      branches('master')
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

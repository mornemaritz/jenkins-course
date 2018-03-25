job('MX - Web') {
  scm {
    git {
      remote {
        github('ecg-protool/REGAIT.MX', 'ssh')
        credentials('jenkins-ssh')
      }
      branches('jenkins-prototype')
    }
  }
  triggers {
    scm('H/5 * * * *')
  }
  steps {
    msBuild {
      msBuildInstallation('MSBuild-15')
      buildFile('MX.sln')
      args('/p:Configuration=Release')
    }
  }
}

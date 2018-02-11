job('MSBuild Test') {
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
      msBuildInstallation('MSBuild-14')
      buildFile('MX.sln')
      args('/p:Configuration=Release')
      args('/t:restore')
    }
  }
}

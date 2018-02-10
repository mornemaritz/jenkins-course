job('MSBuild Test') {
  scm {
    git('git@github.com:ecg-protool/REGAIT.MX.git') { msbuild ->
      msbuild / gitConfigName('My DSL User')
      msbuild / gitConfigEmail('mornemaritz@gmail.com')
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

job('MSBuild Test') {
  scm {
    git('git@github.com:ecg-protool/REGAIT.MX.git') { msbuild ->
      msbuild / gitConfigName('jenkins-ssh')
      msbuild / gitConfigEmail('morne.maritz@entelect.co.za')
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

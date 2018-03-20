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
      msBuildInstallation('MSBuild-14')
      buildFile('MX.sln')
      args('/p:Configuration=Release')
    }
    batchFile('C:\\JenkinsTools\\NUnit.Console-3.8.0\\nunit3-console.exe MX.UnitTest\\bin\\Release\\MX.UnitTest.dll --result=nunit-result.xml')
  }
  publishers {
    archiveXUnit {
      nUnit {
        pattern('nunit-result.xml')
      }
    }
  }
}

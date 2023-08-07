# VamShop

## Requirements

Java 16 
<br>
Google Chrome 114 or above

## How to run
In order to run the application you will need to set up JUnit run configuration

[![run-config.png](https://i.postimg.cc/rmf7sZzC/run-config.png)](https://postimg.cc/xJb6FRvc)

## List of params to pass to the run config
-ea
<br>
-Dcourgette.runLevel=SCENARIO
<br>
-Dcourgette.threads=10
<br>
-Dcourgette.rerunFailedScenarios=false
<br>
-Dcourgette.rerunAttempts=1
<br>
-Dcucumber.tags="@regression"
<br>
-Dbrowser=chrome
<br>
-DenvironmentUrl="https://demo.vamshop.com"
<br>
-DadminUsername="admin"
<br>
-DadminPassword="password"
<br>

## Reporting 
After runing the tests you can find the html report in /targer/courgette-report/index.html that looks like

[![report.png](https://i.postimg.cc/nL3t9hPD/report.png)](https://postimg.cc/f3SP6DZz)

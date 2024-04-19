# JUnit5_Parallel_Execution
This is repository for demo JUnit5 Parallel Execution

### Why is parallel execution needed?
* Parallel testing is a process where multiple tests are executed simultaneously/in parallel in different thread processes.
* The main purpose of running tests in parallel mode is to reduce execution time and do maximum environment coverage (browsers/devices/environment) in less time.

### Junit 5 – Parallel Execution
* By default, JUnit Jupiter tests are run sequentially in a single thread.
* This feature available as an opt-in feature since version 5.3.

### Setup
* Create simple maven project.
* Add these below dependencies to `pom.xml'.
    ** Go to maven dependency [JUnit Jupiter Engine](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-engine/).
    ** In this demo I also used playwright to run, so we will need this dependency as well [Playwright Main Library](https://mvnrepository.com/artifact/com.microsoft.playwright/playwright/).


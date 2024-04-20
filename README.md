# JUnit5_Parallel_Execution
This is repository for demo JUnit5 Parallel Execution.

### Why is parallel execution needed?
* Parallel testing is a process where multiple tests are executed simultaneously/in parallel in different thread processes.
* The main purpose of running tests in parallel mode is to reduce execution time and do maximum environment coverage (browsers/devices/environment) in less time.

### Junit 5 – Parallel Execution
* By default, JUnit Jupiter tests are run sequentially in a single thread.
* This feature available as an opt-in feature since version 5.3.


### Prerequisite

```
    Eclipse/IntelliJ
    Java
```

### Setup
1.  Create simple maven project.
2.  Add these below dependencies to `pom.xml`.
    -   Go to maven dependency [JUnit Jupiter Engine](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-engine/).
    -   In this demo I also used playwright to run, so we will need this dependency as well [Playwright Main Library](https://mvnrepository.com/artifact/com.microsoft.playwright/playwright/).
3. Create a `junit-platform.properties` file in `src/test/resources`.
4. To enable parallel execution, set the `junit.jupiter.execution.parallel.enabled=true`.
5. Configuration parameters to execute all tests in parallel:
```
    junit.jupiter.execution.parallel.enabled = true
    junit.jupiter.execution.parallel.mode.default = concurrent

```
6. Configuration parameters to execute top-level classes in parallel but methods in same thread:
```
    junit.jupiter.execution.parallel.mode.classes.default = concurrent

```


### Execution Mode
1. (same_thread, same_thread) – all tests run sequentially.
2. (same_thread, concurrent) – tests from one class run sequentially, but multiple classes run in parallel.
3. (concurrent, same_thread) – tests from one class run parallel, but each class run separately.
4. (concurrent, concurrent) – tests run in parallel.

![Execution mode](https://junit.org/junit5/docs/snapshot/user-guide/images/writing-tests_execution_mode.svg)


### Execution Stragegy
* Properties such as the desired parallelism and the maximum pool size can be configured using a `ParallelExecutionConfigurationStrategy`. The JUnit Platform provides two implementations out of the box: `dynamic` and `fixed`.
* To select a strategy, set the `junit.jupiter.execution.parallel.config.strategy` configuration parameter to one of the following options.

1. dynamic
    - Computes the desired parallelism based on the number of available processors/cores multiplied by the `junit.jupiter.execution.parallel.config.dynamic.factor` configuration parameter (defaults to 1). The optional `junit.jupiter.execution.parallel.config.dynamic.max-pool-size-factor` configuration parameter can be used to limit the maximum number of threads.
2. fixed
    - Uses the mandatory `junit.jupiter.execution.parallel.config.fixed.parallelism` configuration parameter as the desired parallelism. The optional `junit.jupiter.execution.parallel.config.fixed.max-pool-size` configuration parameter can be used to limit the maximum number of threads.
3. custom
    - Uses the mandatory `junit.jupiter.execution.parallel.config.fixed.parallelism` configuration parameter as the desired parallelism. The optional `junit.jupiter.execution.parallel.config.fixed.max-pool-size` configuration parameter can be used to limit the maximum number of threads.


### Synchronization
* In ideal situations, all our unit tests are independent and isolated. However, sometimes that’s hard to implement because they depend on shared resources. Then, when running tests in parallel, we need to synchronize over common resources in our tests. JUnit5 provides us with such mechanisms in the form of `@ResourceLock` annotation.
* `@ResourceLock` allows us to specify which resource is shared and the type of lock we want to use (default is `ResourceAccessMode.READ_WRITE`). With the current setup, the JUnit engine will detect that our tests both use a shared resource and will execute them sequentially.

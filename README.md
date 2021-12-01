# Integration Testing using PostgreSQL

Integration testing plays an important role in the application development cycle by verifying the end-to-end behavior of a system.
This project template uses [JUnit 5](https://junit.org/junit5/) and [Testcontainers](https://www.testcontainers.org/) to test a [Spring](https://spring.io/) REST API with a [PostgreSQL](https://www.postgresql.org/) database.

## Overview

The controllers bear many responsibilities, such as listening to the HTTP request, validating the input, calling the business logic, serializing the output, and translating the exceptions to a proper response.

With the `@SpringBootTest` annotation, Spring Boot provides a convenient way to start up an application context to be used in a test.
Common projects use a database for data persistence.
In local development, you need to provide a connection to a `PostgreSQL` instance.

You can use the following docker command:

```bash
docker run -d -p 5432:5432 -e POSTGRES_DB=spring -e POSTGRES_USER=root -e POSTGRES_PASSWORD=secret postgres
```

Using the `@DataJpaTest` test slice annotation, you can easily write integration tests for our JPA persistence layer.
The `@DataJpaTest` meta-annotation contains the `@Transactional` annotation.
This ensures our test execution is wrapped with a transaction that gets rolled back after the test.

While the default configuration expects an embedded database, this project demonstrates how to test any Spring Data JPA repository with a running database server using `Testcontainers`.

## Project structure

This project was generated with [Spring Initializr](https://start.spring.io/).
All of the app's code goes in a folder named `src/main`.
The **unit tests** and **integration tests** are in the `src/test` and `src/integrationTest` folders.
Static files are placed in `src/main/resources` folder.

## Available gradle tasks

The tasks in [build.gradle](build.gradle) file were built with simplicity in mind to automate as much repetitive tasks as possible and help developers focus on what really matters.

The next tasks should be executed in a console inside the root directory:

- `./gradlew tasks` - Displays the tasks runnable from root project 'app'.
- `./gradlew bootRun` - Runs this project as a Spring Boot application.
- `./gradlew check` - Runs all checks.
- `./gradlew test` - Runs the unit tests.
- `./gradlew integrationTest` - Run the integration tests.
- `./gradlew clean` - Deletes the build directory.
- `./gradlew build` - Assembles and tests this project.
- `./gradlew help` - Displays a help message.

For more details, read the [Command-Line Interface](https://docs.gradle.org/current/userguide/command_line_interface.html) documentation in the [Gradle User Manual](https://docs.gradle.org/current/userguide/userguide.html).

## Running unit tests

Unit tests are responsible for testing of individual methods or classes by supplying input and making sure the output is as expected.

Use `./gradlew test` to execute the unit tests via [JUnit 5](https://junit.org/junit5/), [Mockito](https://site.mockito.org/) and [AssertJ](https://assertj.github.io/doc/).
Use `./gradlew test -t` to keep executing unit tests in real time while watching for file changes in the background.
You can see the HTML report opening the [index.html](build/reports/tests/test/index.html) file in your web browser.

It's a common requirement to run subsets of a test suite, such as when you're fixing a bug or developing a new test case.
Gradle provides different mechanisms.
For example, the following command lines run either all or exactly one of the tests in the `SomeTestClass` test case:

```bash
./gradlew test --tests SomeTestClass
```

For more details, you can see the [Test filtering](https://docs.gradle.org/current/userguide/java_testing.html#test_filtering) section of the Gradle documentation.

This project uses [JaCoCo](https://www.eclemma.org/jacoco/) which provides code coverage metrics for Java.
The minimum code coverage is set to 80%.
You can see the HTML coverage report opening the [index.html](build/reports/jacoco/test/html/index.html) file in your web browser.

## Running integration tests

Integration tests determine if independently developed units of software work correctly when they are connected to each other.

Use `./gradlew integrationTest` to execute the integration tests via [JUnit 5](https://junit.org/junit5/), [Testcontainers](https://www.testcontainers.org/) and [AssertJ](https://assertj.github.io/doc/).
Use `./gradlew integrationTest -t` to keep executing your tests while watching for file changes in the background.
You can see the HTML report opening the [index.html](build/reports/tests/integrationTest/index.html) file in your web browser.

Like unit tests, you can also run subsets of a test suite.
See the [Test filtering](https://docs.gradle.org/current/userguide/java_testing.html#test_filtering) section of the Gradle documentation.

## Debugging

You can debug the source code, add breakpoints, inspect variables and view the application's call stack.
Also, you can use the IDE for debugging the source code, unit and integration tests.
You can customize the [log verbosity](https://docs.gradle.org/current/userguide/logging.html#logging) of gradle tasks using the `-i` or `--info` flag.

This project includes [Swagger](https://swagger.io/). To get a visual representation of the interface and send requests for testing purposes go to <http://localhost:8080/swagger-ui.html>.

## Reference Documentation

For further reference, please consider the following articles:

- [Official Gradle documentation](https://docs.gradle.org)
- [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.5.5/gradle-plugin/reference/html/)
- [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
- [Accessing JPA Data with REST](https://spring.io/guides/gs/accessing-data-rest/)
- [Spring Data JPA Persistence Layer Tests With @DataJpaTest](https://rieckpil.de/test-your-spring-boot-jpa-persistence-layer-with-datajpatest/)
- [Testing JPA Queries with Spring Boot and @DataJpaTest](https://reflectoring.io/spring-boot-data-jpa-test/)
- [Testing with Spring Boot and @SpringBootTest](https://reflectoring.io/spring-boot-test/)
- [Testcontainers Postgres Module Reference Guide](https://www.testcontainers.org/modules/databases/postgres/)

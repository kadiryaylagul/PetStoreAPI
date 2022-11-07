test-automation-API-petstore
The API framework is created using Cucumber with Java programming language.

Concepts Included
Cucumber BDD testing for API
Shared state across cucumber step definitions
Dependency injection
Page Object pattern


Tools
Maven
Cucumber-JVM
JUnit
TestNG
Selenium Webdriver
RestAssured


Requirements
In order to utilise this project you need to have the following installed locally:
Maven 3.6.3
Chrome and Chromedriver (UI tests use Chrome by default, can be changed in config)
Java 15 - version 15.0.2
IntelliJ IDEA - version 2021.3.3

Dependencies:
In order to utilise this project you need to have following dependencies in pom.xml
and you can find them https://mvnrepository.com

Selenium-version 3.141.59
Cucumber-java - version 5.7.0
Cucumber-junit - version 5.7.0
Rest-assured - version 4.3.2
Java-Faker - version 1.0.2
Junit - version 4.12

Plugins
maven-compiler-plugin - version 3.8.1
maven-surefire-plugin - version 3.0.0-M4
maven-cucumber-reporting - version 5.0.0


To run API modules, navigate to petStoreAPI-src-test-runners directory and run:
TestRunnerApi class

API acceptance tests result in a HTML report for each feature in
petStoreApi\target\xml-report\cucumber.xml

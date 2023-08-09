# Merchant Solution
Sample Trading Application Assignment

### High Level Solution

![](https://i.imgur.com/xCa7Xjp.png)

## Requirements

For building and running the application you need:

- [JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven 4](https://maven.apache.org)

## Running the application locally

There are several ways to run this on your local machine. One way is to execute the `main` method in the `com.db.TradingApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

## Running unit tests

You can run unit tests using following command

```shell
mvn test
```
# Merchant Solution
Sample Trading Application Assignment

### High Level Solution

![](https://i.imgur.com/6kv3vBu.png)

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

## How to Test Manually

You can add a new json record with a new signal id and desired operations to data.json and run the project. 
Following are the operation keywords

- do
- cancel
- reverse
- submitMarket
- performCalculation
- setup

## Improvements to be done

Cache the signal spec list
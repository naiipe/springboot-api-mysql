# springboot-api-mysql
An API wrote in Java8 Spring-boot that connect with MysqlDB running basic CRUD operations

API Documentation:
https://documenter.getpostman.com/view/2500522/SVtN5CFk?version=latest

In order to run this application you will need to generate a mock information based on you local mysql.


# Build Spring Boot Project with Maven

To be able to run your Spring Boot app you will need to first build it. To build and package a Spring Boot app into a single executable Jar file with a Maven, use the below command. You will need to run it from the project folder which contains the pom.xml file.

    maven package

or you can also use

    mvn install

# Run Spring Boot app with java -jar command

To run your Spring Boot app from a command line in a Terminal window you can you the java -jar command. This is provided your Spring Boot app was packaged as an executable jar file.

    java -jar target/mywebserviceapp-0.0.1-SNAPSHOT.jar

# Run Spring Boot app using Maven

You can also use Maven plugin to run your Spring Boot app. Use the below example to run your Spring Boot app with Maven plugin:

    mvn spring-boot:run

Thanks!
If you found any issue, please, let me know.

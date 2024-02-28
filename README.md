This app is one of my personal project that I plan to implement in my home. This will track all the major savings/expenses in my house. Currently only providing endpoints for the backend. 
Will add the front-end for this after I finish my Angular course in Udemy

I plan to implement the things listed below. This repository will also serve as my refresher for future projects in case I need to implement the same things or some.

done:
* externalized properties file - ok. can be done using spring.config.import=file:C:/Users/robert.dela.cruz/laptop-files/dev/application.properties
  * can also be done by terminal when launching the jar file during deployment
* profiles - dev, test, uat, prod - done. can be done using application properties file. Just change the database connection accordingly and change also other properties
* springdoc entity-controllers: done using openapi springdoc dependencies and enabling @RepositoryRestResource in Repository classes (refer to pom)
* banner - can be done by introducing a banner.txt in resources directory
* enable properties filtering - <filtering>true</filtering> add this to your pom resources to resolve properties from pom file
* JUnit = providing @Test methods in the Test classes
* JaxB = see pom for JaxB dependencies. This uses JaxBContext to marshal or unmarshal java objects and xml

not done:

* Mapper and mapper implementation: mapstruct
* Projections - https://www.baeldung.com/spring-data-jpa-projections#interface-based-projections
* testing: JUnit and Mockito
* jenkins automate build
* auth - jwt security - register, log-in, log-out
* docker
* kubernetes
* enable database auditing
* jasperReports
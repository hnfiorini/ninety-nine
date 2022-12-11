# ninety-nine project

This challenge has two projects.
The **backend** project is in which we developed the logic to get the share price of the companies.
The **data-provider-mock** project is a mock project to simulate a service that return the share price of companies in that specific moment.

## Steps

* Clone this repository or download these projects.
* Must run the data-provider-mock project first. In the root directory of this project run
	> mvn spring-boot:run
	
*	Can check if it is working well in the url: http://localhost:8081/companies . It should show 3 companies with their share prices. These should change randomly for each time we access this url.
*	After that you can start the backend project. In the root of this project run
	> mvn spring-boot:run

-   It can be used with different endpoints
	> 
	* http://localhost:8081/companies
	* http://localhost:8080/companies/MSFT/history?searchType=DAILY (this  will get the share price history of the company MSFT. The request params are not working but the search type param is required)
	
## Pending tasks

* Finish share prices history search with different parameters.
* Add unit test and integration test
* Add Swagger
* Add logs and delete println
* Depending on the scope of the project we could add a service discovery as Eureka server

## Tools

* Java v11
* Spring boot v2.7.6
* Lombok
* h2 database

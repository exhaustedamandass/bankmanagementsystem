# Description

Welcome to the bank management system project's repository. 

Project is built using Spring Boot. 

It represents a client-server application. 

## Server Part

Server part represents a three-layer application
1. Persistence layer
2. Business layer
3. Presentation layer

The presentation layer of the application adheres to RESTful principles

Application is powered by Azure DB for PostgreSQL.

Contains automated tests.

Sample API calls can be accessed via this link https://documenter.getpostman.com/view/32039034/2sA2r824NB

## Client Part

Uses REST API of the server as the backend.

Has a complex business logic operation.

Developed using Thymeleaf.

When Client is trying to create a new transaction, there are two http requests:

1. Create a new transaction
2. Update the account record.
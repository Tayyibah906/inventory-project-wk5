Week 5 Inventory Management System

This is the week 5 inventory management system project, which allows end users to update the inventory database. 
The system is able to let users: insert, read, update and delete entries. 

Getting Started

a copy of the project can be found at git clone https://github.com/Tayyibah906/inventory-project-wk5.git
for you to download on your local machine for development and testing purposes. 
This project was built with the Eclipse IDE version 2020-03 (4.15.0)
https://maven.apache.org/ dependency management

Prerequisites

What things you need to install the software:
•You need to have JDK 1.8 and Java SE Runtime Environment 1.8
•You also need to have Apache Maven 3.6.3 installed
•To run it locally you need MySQL 5.7 or 8


Installing

Install Java from Oracle webpage
Install mySQL Workbench
Install Eclipse IDE 
Install Maven


Unit Tests

A unit test is a piece of code written by a developer that executes a specific functionality in the code to be tested and asserts a certain behaviour or state. The percentage of code which is tested by unit tests is typically called test coverage. A unit test targets a small unit of code, e.g., a method or a class. 
External dependencies should be removed from unit tests by replacing the dependency with a test implementation or a (mock) object created by a test framework using technology such as Mockito. In this project Maven Junit testing was carried out to test methods, however Mockito could also be used in the future to carry out wider testing on the application.

Integration Tests

Unit tests are not suitable for testing complex user interface or component interaction. For this, we should develop integration tests. An integration test aims to test the behaviour of a component or the integration between a set of components. The term functional test is sometimes used as synonym for integration test. Integration tests check that the whole system works as intended, therefore they are reducing the need for intensive manual tests.
These kinds of tests allow you to translate your user stories into a test suite. The test would resemble an expected user interaction with the application. Integration testing was carried out on the DAO part of this project. 

Continuous Integration 

Jenkins was used to automate the testing, building phase of the project and Sonarqube was used to for continuous inspection of the code to highlight any code smell, bugs and vulnerabilities, while Nexus was used as a private artefact repository to hold the project. 


Built With
•Maven - Dependency Management

Versioning

We use Git for versioning

Authors
•Tayyibah Ali

Acknowledgments
•Piers Barber
•Christopher Perrins
•Alan Davis
•Jordan Harrison

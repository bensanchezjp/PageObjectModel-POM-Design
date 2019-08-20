# PageObjectModel-POM-Design

Page Object Model (POM) Design with Selenium *

Test Unit Framework:  TestNG (Test Next Generation)

Maven Project Name: FreeCRMTest

Project Description:  The purpose of this project is to show the advantages of using a design pattern called Page Object Model (POM) using an Apache Maven Project so that if any Page Object changes in the future the tester can make adjustments only to that particular Page Object and not to all the related test cases.

Page Object Model (POM)

A Page Object is a Design Pattern which has become popular in test automation for enhancing test maintenance and reducing code duplication. A page object is an object-oriented class that serves as an interface to a page of your AUT. The tests then use the methods of this page object class whenever they need to interact with the UI of that page. The benefit is that if the UI changes for the page, the tests themselves don’t need to change, only the code within the page object needs to change. Subsequently all changes to support that new UI are located in one place. [1]

Advantages

1. There is a clean separation between test code and page specific code such as locators (or their use if you’re using a UI Map) and layout.
2. There is a single repository for the services or operations offered by the page rather than having these services scattered throughout the tests. [1]
The Application Under Test (AUT) is FreeCRM. The tests are run using Selenium WebDriver with Java 1.8 using Eclipse IDE for Enterprise Java Developers Version: 2019-06 (4.12.0) on Mac OS X, v.10.14.6. The test can be run with any Selenium WebDriver supported driver, however, this particular test is designed to be run with either Chrome Driver or Firefox’s geckodriver. 

The Page Objects tested are the Home, Contacts and Login Page using a Data Driven approach with Apache POI (Poor Obfuscation Implementation) to read the data from an excel sheet.  This test framework also takes a screenshot if any exceptions are present.

CI/CD - Jenkins

The tests can be run either manually by running a TestNG XML file locally. The code is uploaded to GitHub using GIT as the version control system and the test can also be run via a popular CI/CD (Continuous Integration/ Continuous Delivery) pipe line tool known as Jenkins.

Reports – HTML, XML, TestNG, Extent

The tests generate HTML, XML, TestNG and Extent reports.  

* I would like to give credit to Naveen @NaveenAutomationLabs http://www.naveenautomationlabs.com and his easy to follow YouTube Tutorials I followed to understand this topic.

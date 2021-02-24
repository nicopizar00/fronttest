
# API Testing

  

This is a practice project for Web Testing in Selenium. It uses Maven and TestNG... and other few libraries.
It uses Google Chrome to run.
  

## The tested Website

  

[Demoblaze.com](https://www.demoblaze.com/) is a ecommerce mockup site. It serves to practice automation. 

## Test Scenario

  

### Purchase any product
The goal is to certify if is possible to generate a purchase, passing by all the necessary elements.

  

#### Test Cases

- Do a purchase correctly.
  

## Execution

Before execute the project is needed to install chromedriver in 

	src/test/resources/driver/
You can download it from [here](https://chromedriver.chromium.org/downloads) 

Then just run the project itself

	mvn clean test

Simple ¯\_(ツ)_/¯
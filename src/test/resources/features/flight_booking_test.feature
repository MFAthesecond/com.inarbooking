#Author: BE-BD
#Date: 2024-29-01
#Description: This is a test case for smoke test

#Test Case: BK_FL_001
#Test Title: Validate the successful flight reservation process

@example
Feature: Flight Filtering

  Background:
    Given Navigation to the baseURL
    And Click on the Booking Link


Scenario: Validate that passenger flight information

  When Click on the Flight Tab
  And Click on round trip checkbox
  And Select "First Class" for flight class
  And Select "Spain" for from dropdown and select "Italy" for to dropdown
  And Click on search flight button
  And Click on select ticket button for #1 flight
  And Click on select ticket button for #1 flight
  And Click on select who's flying button
  And Fill "bburak@gmail.com" as contact email
  And Select "+33 (FR)" for country code dropdown and fill "4445756661" as phone number
  And Fill in first name "Burak" last name "Doğan" for passenger
  And Select in the Gender as "Male" from the gender dropdown for the 1st passenger
  And Select the year "1990", month "1", day "15" as the date of birth
  Then Verify that the "Invalid email address" message is not displayed
  And Verify that the "Invalid phone number" message is not displayed

  Scenario: Validate that passenger flight information

    When Click on the Flight Tab
    And Click on round trip checkbox
    And Select "First Class" for flight class
    And Select "USA" for from dropdown and select "Japan" for to dropdown
    And Select "2" adults and "1" child and click on search flight button
    And Click on select ticket button for #1 flight
    And Click on select ticket button for #1 flight
    And Click on select who's flying button
    And Fill "bbbbb@gmail.com" as contact email
    And Select "+33 (FR)" for country code dropdown and fill "4445756661" as phone number
    And Fill in "Ali" as the name, "Veli" as the surname, "Female" as the gender, "1995" as the year, "4" as the month, "3" as the day for the #1 passenger
    And Fill in "Ali" as the name, "Veli" as the surname, "Female" as the gender, "1905" as the year, "4" as the month, "3" as the day for the #2 passenger
    And Fill in "John" as the name, "Eris" as the surname, "Male" as the gender, "2005" as the year, "2" as the month, "6" as the day for the #3 passenger
    Then Verify that the "Please select a gender." message is not displayed



  Scenario: Validate that flight fare calculation

    When Click on the Flight Tab
    And Click on round trip checkbox
    And Select "Business" for flight class
    And Select "USA" for from dropdown and select "Japan" for to dropdown
    And Select "2" adults and "2" child and click on search flight button
    And Click on select ticket button for #1 flight
    And Click on select ticket button for #1 flight
    And Click on select who's flying button
    And Calculate total price
    Then Verify that total flight fare

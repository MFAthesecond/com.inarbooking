#Author: MFA-NA
#Date: 2024-31-01
#Description: This is a test case for smoke test

#Test Case: BK_HP_001
#Test Title: Validate the successful hotel reservation process

@example
Feature: Stay Filtering

  Background:
    Given Navigation to the baseURL
    And Click on the Booking Link
    And Click on the Stays Tab

  Scenario Outline: Validate that the successful hotel reservation process


    When Type the destination "<destination>" where you will be staying
    And Select date as "<daynum1>" and "<daynum2>" days of next month
    And Select "<adultnum>" adults and "<childnum>" child and "<roomnum>"room and click on search flight button
    Then Validate the user is on hotel selection page


    Examples:
      | destination | daynum1 | daynum2 | adultnum | childnum | roomnum |
      | Istanbul    | 1       | 7       | 2        | 1        | 4       |
      | New York    | 3       | 14      | 5        | 2        | 6       |
      | Paris       | 21      | 28      | 10       | 5        | 12      |

  Scenario: Validate that the stays selection process

    When Choose "Istanbul" where to stay
    And Click on search hotels button
    And Select "Bicyle Rental" and select "Fitness" for fun things to do
    And Select "Free WiFi" for additional features
    And Click on search button
    And Click on the see availability button for #1 hotel
    Then Verify that the user is on the details page

  Scenario:Validate that the successful hotel reservation process 1

    When Choose "Istanbul" where to stay
    And Select date as "Feb 12, 2024" and "Feb 16, 2024"
    And Select "6" adults and "3" child and click on search hotels button
    Then Validate the user is on hotels selection page


    #Test Cases for Hotels Selection Page

  Scenario: Verify that fun things are selectable
    When  Click on search hotels button
    And  Select "Cycling" and "Fitness" for fun things to do
    And click on search button
    And Click on the see availability button for #1 hotel
    Then verify that the user is on the details page


  Scenario: Verify that additional features are selectable
    When  Click on search hotels button
    And  Select "Free Parking" and "Heating" and "Non-smoking rooms" for additional features
    And click on search button
    And  Click on the see availability button for #1 hotel
    Then verify that the user is on the details page

  Scenario: Verify that hotels are selectable
    When  Click on search hotels button
    And  Select "City Center Suites" and "Grand Plaza Hotel" for hotels and click on search button
    And  Click on the see availability button for #2 hotel
    Then verify that the user is on the details page

  Scenario Outline: Validate that the textarea ,slide , checkboxes and radio buttons functionality for round trip #
    #metni düzenle yanlış bu
   # And Select date as "<daynum1>" and "<daynum2>" days of next month
    When Type the destination "<destination>" where you will be staying
   # And Select date as "<daynum1>" and "<daynum2>" days of next month
    And Slide to min price
    And Slide to max price
    And Select "<adultnum>" adults and "<childnum>" child
    And Select "<FunThingsToDo1>" and select "<FunThingsToDo2>" and "<FunThingsToDo3>" for fun things to do
    And Select "AdditionalFeatures1>" and select "AdditionalFeatures2>" for additional features
    And Select "<Hotels1>" for hotels
    And Select "<NumberRoom>" for number of bedrooms spinner overflow
    Then Verify that destination is written as "<destination>", "<adultnum>" for adult "<childnum>" for child
    # üste ne yazıca
    And Verify that  "<FunThingsToDo1>" and select "<FunThingsToDo2>" and "<FunThingsToDo3>" for fun things to do dropdown is selected
    And Verify that "<Hotels1>" for hotels and "<NumberRoom>" for number of bedrooms

    Examples:
      | destination | adultnum | childnum | FunThingsToDo1 | FunThingsToDo2 | FunThingsToDo3 | AdditionalFeatures1 | AdditionalFeatures2 | Hotels1             | NumberRoom |
      | Amsterdam   | 3        | 4        | Bicycle rental | Fitness        | Cycling        | Free WiFi           | Elevator            | Coastal Breeze Inn  | 2          |
      | New York    | 3        | 4        | Cycling        | Walking Tours  | Fitness        | Baggage storage     | Daily housekeeping  | City Center Suites  | 10         |
      | Sydney      | 10       | 9        | Walking Tours  | Bicycle rental | Skate Parkour  | Private Parking     | Non-smoking rooms   | Vintage Manor Hotel | 5          |





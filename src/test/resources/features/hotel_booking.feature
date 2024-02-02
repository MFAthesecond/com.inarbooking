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
    And Select date as "<daynum1>" and "<daynum2>" days of next
    And Select "<adultnum>" adults and "<childnum>" child and "<roomnum>"room
    And click on search flight button
    Then Validate the user is on hotel selection page


    Examples:
      | destination | daynum1 | daynum2 | adultnum | childnum | roomnum |
      | Istanbul    | 1       | 7       | 2        | 1        | 4       |
      | New York    | 3       | 14      | 5        | 2        | 6       |
      | Paris       | 21      | 28      | 10       | 5        | 12      |

  Scenario: Validate that the stays selection process
    Given Navigation to the Hotel Details Page
    When Choose "Istanbul" where to stay
    And Select "Skate Parkour" and select "Cycling" for fun things to do
    And Select "Free parking" for additional features
    And Click on search hotels button
    And Click on the see availability button for #1 hotel
    Then Verify that the user is on the details page

  Scenario: Verify that hotels are selectable
    Given Navigation to the Hotel Details Page
    When  Click on search hotels button
    And  Select "City Center Suites" and "Grand Plaza Hotel" for hotels
    And Click on search hotels button
    And  Click on the see availability button for #2 hotel
    Then Verify that the user is on the details page

  Scenario Outline: Validate that the textarea ,slide , checkboxes and radio buttons functionality for round trip
    #metni düzenle yanlış bu
    When Type the destination "<destination>" where you will be staying
    And Select "<adultnum>" adults and "<childnum>" child and "<NumberRoom>"room
    And click on search flight button
    And Select "<FunThingsToDo1>" and select "<FunThingsToDo2>" for fun things to do
    And Select "<AdditionalFeatures1>" select "<AdditionalFeatures2>" for additional features
    And Select "<Hotel>" for hotels
    And Select "<NumberRoom>" for number of bedrooms spinner overflow
    And Click on search hotels button
    And Click on the see availability button for #1 hotel
    And Verify that "<Hotel>" selected
    Then Verify that "<FunThingsToDo1>" and "<FunThingsToDo2>" for fun things to do are selected

    Examples:
      | destination | adultnum | childnum | FunThingsToDo1 | FunThingsToDo2 | AdditionalFeatures1 | AdditionalFeatures2 | Hotel               | NumberRoom |
      | Amsterdam   | 3        | 4        | Bicycle rental | Fitness        | Free WiFi           | Elevator            | Coastal Breeze Inn  | 2          |
      | New York    | 3        | 4        | Cycling        | Walking Tours  | Baggage storage     | Daily housekeeping  | Ocean View Resort   | 10         |
      | Istanbul    | 10       | 9        | Walking Tours  | Skate Parkour  | Private Parking     | Non-smoking rooms   | Vintage Manor Hotel | 5          |

#
#


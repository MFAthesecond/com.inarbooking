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

  Scenario Outline: Validate that the successful flight reservation process

    When Click on the Flight Tab
    And Click on round trip checkbox
    And Select "<flight class>" for flight class
    And Select "<country1>" for from dropdown and select "<country2>" for to dropdown
    And Select date as "<daynum1>" and "<daynum2>" days of next month
    And Select "<adultnum>" adults and "<childnum>" child and click on search flight button
    Then Validate the user is on flight selection page
    Examples:
      | flight class | country1       | country2 | daynum1 | daynum2 | adultnum | childnum |
      | Business     | Germany        | France   | 3       | 8       | 5        | 3        |
      | Economy      | USA            | China    | 20      | 25      | 3        | 7        |
      | First Class  | United Kingdom | Spain    | 8       | 11      | 15       | 7        |



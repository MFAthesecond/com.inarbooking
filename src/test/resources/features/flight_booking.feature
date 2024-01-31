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


  Scenario: Validate that the flight selection process

    When Click on the Flight Tab
    And Click on "Round Trip" trip checkbox
    And Select "USA" for from dropdown and select "Canada" for to dropdown
    And Click on search flight button
    And Unselect "Business" and Unselect "Economy" for cabin class
    And Select "Airline C" for airlines
    And Select "6 hours" for duration (hours)
    And Click on search button
    And Click on select ticket button for #1 flight
#    Then Verify that the user on flight fare page


  Scenario: Validate that the successful flight reservation process 1

    When Click on the Flight Tab
    And Click on round trip checkbox
    And Select "Economy" for flight class
    And Select "Spain" for from dropdown and select "Italy" for to dropdown
    And Select date as "Feb 12, 2024" and "Feb 16, 2024"
    And Select "6" adults and "3" child and click on search flight button
    Then Validate the user is on flight selection page

#Test Cases for Flight Selection Page

  Scenario: Validate that the cheapest functionality on flight selection page

    When Click on the Flight Tab
    And Select "USA" for from dropdown and select "Canada" for to dropdown
    And Click on search flight button
    And Click on "Cheapest" tab
    Then Verify that the the cheapest flight is the first flight

  Scenario: Validate that the fastest functionality on flight selection page

    When Click on the Flight Tab
    And Select "USA" for from dropdown and select "Canada" for to dropdown
    And Click on search flight button
    And Click on "Fastest" tab
    Then Verify that the the fastest flight is the first flight


  Scenario: Validate that the successful flight selection for Round Trip as Trip Type

    When Click on the Flight Tab
    And Select "USA" for from dropdown and select "Canada" for to dropdown
    And Click on search flight button
    And Click on select ticket button for #1 flight
    And Click on select return ticket button for #1 flight
    Then Verify that the user on flight fare page

  Scenario Outline: Validate that the dropdowns , checkboxes and radio buttons functionality for round trip

    When Click on the Flight Tab
    And Select "<Origin>" for from dropdown and select "<Destination>" for to dropdown
    And Click on search flight button
    And Select "<OriginSelection>" from origin drop down
    And Select "<DestinationSelection>" from destination drop down
    And Select "<AdultNum>" for Adult dropdown
    And Select "<ChildNum>" for Children dropdown
    And Unselect "<CabinClass1>" and Unselect "<CabinClass2>" for cabin class
    And Select "<Airline>" for airlines
    And Select "<Duration>" for duration (hours)
    Then Verify that "<OriginSelection>" for origin, "<DestinationSelection>" for destination "<AdultNum>" for adult "<ChildNum>" for children dropdown is selected
    And Verify that "<CabinClass1>" and "<CabinClass2>" unselected for for cabin class, "<Airline>" selected for airlines , "<Duration>" selected for duration
    Examples:
      | Origin | Destination | OriginSelection | DestinationSelection | AdultNum | ChildNum | CabinClass1 | CabinClass2 | Airline   | Duration |
      | USA    | Canada      | United Kingdom  | Germany              | 5        | 7        | Business    | Economy     | Airline Z | 6 hours  |
      | France | Italy       | China           | Brazil               | 3        | 4        | First Class | Business    | Airline A | 14 hours |
      | Japan  | Spain       | India           | Australia            | 10       | 9        | Economy     | First Class | Airline C | 24 hours |


  Scenario: Validate that the fare type selection functionality on fare page

    When Click on the Flight Tab
    And Select "Germany" for from dropdown and select "France" for to dropdown
    And Click on search flight button
    And Click on select ticket button for #1 flight
    And Click on select return ticket button for #1 flight
    Then Verify that the user on flight fare page
    And Verify that the departure route "Germany to France" and the return route "France to Germany"
    When Click on "First Class" for departure fare type
    And Click on "Refundable Main" for return fare type
    Then Verify that the "First Class" is selected for departure fare type and "Refundable Main" is selected for return fare type
    And Click on select who's flying button
#    Then Verify that the user is on passenger information page
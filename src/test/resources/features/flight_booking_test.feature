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


  Scenario Outline: Verify the functionality of the flight booking tab with end-to-end testing
    When Click on the Flight Tab
    And Click on round trip checkbox
    And Select "<Flight class>" for flight class
    And Select "<Origin>" for from dropdown and select "<Destination>" for to dropdown
    And Select date as "<First Date>" and "<Last Date>"
    And Select "<Adult Number>" adults and "<Child Number>" child and click on search flight button

    Then Validate the user is on flight selection page
    When Click on "Cheapest" tab
    Then Verify that the the cheapest flight is the first flight
    When Click on "Fastest" tab
    Then Verify that the the fastest flight is the first flight
    And Click on search button
    And Get the #1 flight information and click on select ticket button
    And Get the #1 flight information and click on select return ticket button

    Then Verify that the user on flight fare page
    And Get departure route information and Click on "<Departure Fare Type>" for departure fare type
    And Get return route information and Click on "<Return Fare Type>" for return fare type
    And Click on select who's flying button

    Then Verify that the user is on flight Passenger Information Page
    And Verify that total flight fare
    When Fill "<Gmail>" as contact email
    And Select "<Country Code>" for country code dropdown and fill "<Phone Number>" as phone number
    And Fill the traveler information
      | John  | Chris | Male   | 1985 | 10 | 15 | 1 |
      | user  | will  | Female | 1999 | 9  | 11 | 2 |
      | sally | james | Other  | 1900 | 3  | 31 | 3 |
    And Click on select extras button

    Then Verify that the user is on Flight Extras Page
    And Select "<Meal>" , "<Extras1>" , "<Extras2>"
    Then Verify that "<Meal>" , "<Extras1>" , "<Extras2>" is selected
    And Verify that total price calculation is correct after "<Meal>" , "<Extras1>" , "<Extras2>" selections
    And Click on go to checkout  button

    Then Verify that the user is on Flight Check And Pay Page
    Then Verify that total price on check and pay page
    When Fill in "<Name>" as the cardholder's name
    And Fill in "<Card Number>" as the card number
    And Fill in "<Expiration Date>" as the expiration date
    And Fill in "<CVC Code>" as the cvc code
    And Click on complete booking button

    Then Validate the user is on confirmation page
    And Verify that "<Gmail>" , route and ticket information on confirmation page for departure and return
    When Click on close button on confirmation page
    And Verify that the user is Flight Home Page
    Examples:
      | Flight class | Origin | Destination | First Date   | Last Date    | Adult Number | Child Number | Departure Fare Type | Return Fare Type | Gmail            | Country Code | Phone Number | Meal              | Extras1            | Extras2            | Name   | Card Number      | Expiration Date | CVC Code |
      | Business     | USA    | Canada      | Feb 14, 2024 | Feb 27, 2024 | 1            | 0            | Refundable Main     | Business         | bbb@gmail.com    | +44 (UK)     | 4444444444   | Kosher Meal - $20 | Extra Comfort Kit  | Extra Legroom Seat | Ben    | 4569875412365897 | 0424            | 325      |
      | First Class  | Spain  | Italy       | Mar 5, 2024  | Mar 30, 2024 | 2            | 1            | Main                | First Class      | Gmail@gmail.com  | +61 (AU)     | 2546987452   | Halal Meal - $16  | Travel Insurance   | Extra Legroom Seat | Furkan | 3658974521236589 | 1126            | 254      |
      | Economy      | China  | Germany     | May 1, 2024  | May 31, 2024 | 2            | 0            | First Class         | Refundable Main  | berkan@gmail.com | +81 (JP)     | 9875641236   | Halal Meal - $16  | Extra Legroom Seat | Travel Insurance   | Nafiz  | 9632587412546987 | 1229            | 985      |





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

#Tests for Flight Selection Page

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
    And Select departure date as "<Departure Date>"
    And Select return date as "<Return Date>"
    Then Verify that "<Departure Date>" and "<Return Date>" is selected
    And Select "<AdultNum>" for Adult dropdown
    And Select "<ChildNum>" for Children dropdown
    And Unselect "<CabinClass1>" and Unselect "<CabinClass2>" for cabin class
    And Select "<Airline>" for airlines
    And Select "<Duration>" for duration (hours)
    Then Verify that "<OriginSelection>" for origin, "<DestinationSelection>" for destination "<AdultNum>" for adult "<ChildNum>" for children dropdown is selected
    And Verify that "<CabinClass1>" and "<CabinClass2>" unselected for for cabin class, "<Airline>" selected for airlines , "<Duration>" selected for duration
    Examples:
      | Origin | Destination | OriginSelection | DestinationSelection | Departure Date | Return Date | AdultNum | ChildNum | CabinClass1 | CabinClass2 | Airline   | Duration |
      | USA    | Canada      | United Kingdom  | Germany              | 03/03/2024     | 10/03/2024  | 5        | 7        | Business    | Economy     | Airline Z | 6 hours  |
      | France | Italy       | China           | Brazil               | 06/15/2025     | 06/20/2025  | 3        | 4        | First Class | Business    | Airline A | 14 hours |
      | Japan  | Spain       | India           | Australia            | 12/05/2025     | 12/05/2024  | 10       | 9        | Economy     | First Class | Airline C | 24 hours |

  #Tests for Flight Fare Page
  Scenario Outline: Validate that the fare type selection functionality on fare page

    When Click on the Flight Tab
    And Select "<Origin>" for from dropdown and select "<Destination>" for to dropdown
    And Click on search flight button
    And Click on select ticket button for #1 flight
    And Click on select return ticket button for #1 flight
    Then Verify that the user on flight fare page
    And Verify that the departure route "<Departure Route>" and the return route "<Return Route>"
    When Click on "<Departure Fare Type>" for departure fare type
    And Click on "<Return Fare Type>" for return fare type
    Then Verify that the "<Departure Fare Type>" is selected for departure fare type and "<Return Fare Type>" is selected for return fare type
    And Click on select who's flying button
    Then Verify that the user is on passenger information page
    Examples:
      | Origin | Destination | Departure Route   | Return Route      | Departure Fare Type | Return Fare Type |
      | USA    | Canada      | USA to Canada     | Canada to USA     | Refundable Main     | First Class      |
      | France | Germany     | France to Germany | Germany to France | First Class         | Business         |
      | Japan  | Brazil      | Japan to Brazil   | Brazil to Japan   | Main                | Refundable Main  |

#Tests for Flight Extras Page
  Scenario Outline: Validate that the extras selection functionality on extras page

    When Click on the Flight Tab
    And Select "<Origin>" for from dropdown and select "<Destination>" for to dropdown
    And Click on search flight button
    And Click on select ticket button for #1 flight
    And Click on select return ticket button for #1 flight
    And Click on "<Departure Fare Type>" for departure fare type
    And Click on "<Return Fare Type>" for return fare type
    And Click on select who's flying button
    And Fill "<Gmail>" as contact email
    And Select "<Country Code>" for country code dropdown and fill "<Phone Number>" as phone number
    And Fill in "<Traveler Name>" as the name, "<Traveler Surname>" as the surname, "<Gender>" as the gender, "<Birth Year>" as the year, "<Birth Month>" as the month, "<Birth Day>" as the day for the #1 passenger
    And Click on select extras button
    And Select "<Meal>" , "<Extras1>" , "<Extras2>"
    Then Verify that total price calculation is correct after "<Meal>" , "<Extras1>" , "<Extras2>" selections
    Then Verify that "<Meal>" , "<Extras1>" , "<Extras2>" is selected
    And Click on go to checkout  button
#    Then Verify that the user is on check and pay page
    Examples:
      | Origin  | Destination | Departure Fare Type | Return Fare Type | Gmail                 | Country Code | Phone Number | Traveler Name | Traveler Surname | Gender | Birth Year | Birth Month | Birth Day | Meal                   | Extras1            | Extras2           |
      | USA     | Canada      | Refundable Main     | First Class      | john15@gmail.com      | +33 (FR)     | 4445756661   | John          | Curtis           | Male   | 1995       | 4           | 3         | Kosher Meal - $20      | Extra Legroom Seat | Lounge Access     |
      | Germany | France      | Main                | Business         | user+#15@gmail.com    | +44 (UK)     | 2345467789   | Sally         | Hawkins          | Female | 2003       | 8           | 17        | Gluten-free Meal - $18 | Extra Comfort Kit  | Travel Insurance  |
      | Japan   | Brazil      | Business            | Refundable Main  | willJames15@gmail.com | +81 (JP)     | 1122233332   | Will          | James            | Other  | 1978       | 12          | 31        | Diabetic Meal - $19    | Travel Insurance   | Extra Comfort Kit |

    Scenario: Validate that the Confirmation Page Information for Round Trip

      When Click on the Flight Tab
      And Select "USA" for from dropdown and select "Canada" for to dropdown
      And Click on search flight button
      And Get the #1 flight information and click on select ticket button
      And Get the #1 flight information and click on select return ticket button
      And Get departure route information and Click on "Refundable Main" for departure fare type
      And Get return route information and Click on "First Class" for return fare type
      And Click on select who's flying button
      And Fill "john15@gmail.com" as contact email
      And Select "+44 (UK)" for country code dropdown and fill "4445756661" as phone number
      And Fill in "Sally" as the name, "James" as the surname, "Male" as the gender, "2003" as the year, "8" as the month, "17" as the day for the #1 passenger
      And Click on select extras button
      And Click on go to checkout  button
      And Fill in "John" as the cardholder's name
      And Fill in "1234567891234567" as the card number
      And Fill in "11/25" as the expiration date
      And Fill in "345" as the cvc code
      And Click on complete booking button
      Then Verify that "john15@gmail.com" , route and ticket information on confirmation page for departure and return
#Author: BE-BD
#Date: 2024-29-01
#Description: This is a test case for smoke test

#Test Case: BK_FL_001
#Test Title: Validate the successful flight reservation process

@Flight
Feature: Flight Pages Test Scenarios

  Background:
    Given Navigation to the baseURL
    And Click on the Booking Link

  @Regression
  Scenario Outline: Validate that the successful flight search process

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

  @Smoke
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
    Then Verify that the user on flight fare page

  @Smoke
  Scenario: Validate that the successful flight reservation process 1

    When Click on the Flight Tab
    And Click on round trip checkbox
    And Select "Economy" for flight class
    And Select "Spain" for from dropdown and select "Italy" for to dropdown
    And Select date as "Feb 12, 2024" and "Feb 16, 2024"
    And Select "6" adults and "3" child and click on search flight button
    Then Validate the user is on flight selection page

#Tests for Flight Selection Page
  @Smoke
  Scenario: Validate that the cheapest functionality on flight selection page

    When Click on the Flight Tab
    And Select "USA" for from dropdown and select "Canada" for to dropdown
    And Click on search flight button
    And Click on "Cheapest" tab
    Then Verify that the the cheapest flight is the first flight

  @Smoke
  Scenario: Validate that the fastest functionality on flight selection page

    When Click on the Flight Tab
    And Select "USA" for from dropdown and select "Canada" for to dropdown
    And Click on search flight button
    And Click on "Fastest" tab
    Then Verify that the the fastest flight is the first flight

  @Smoke
  Scenario: Validate that the successful flight selection for Round Trip as Trip Type

    When Click on the Flight Tab
    And Select "USA" for from dropdown and select "Canada" for to dropdown
    And Click on search flight button
    And Click on select ticket button for #1 flight
    And Click on select return ticket button for #1 flight
    Then Verify that the user on flight fare page

  @Regression
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
      | Japan  | Spain       | India           | Australia            | 12/05/2025     | 12/05/2026  | 10       | 9        | Economy     | First Class | Airline C | 24 hours |

#    Test for invalid date acceptance on flight selection page
  @Smoke
  Scenario: Validate that invalid date selection process on flight selection page for round trip

    When Click on the Flight Tab
    And Select "USA" for from dropdown and select "Canada" for to dropdown
    And Click on search flight button
    And Select departure date as "12/05/2025"
    And Select return date as "12/05/2024"
    Then Verify that "12/05/2025" as departure date and "12/05/2024" as return date are not accepted on date picker

  #Tests for Flight Fare Page
  @Regression
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

#Tests For Flight Passenger Information Page
  @Regression
  Scenario: Validate that passenger flight information 1

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
    And Fill in first name "Brown" last name "Dan" for passenger
    And Select in the Gender as "Male" from the gender dropdown for the 1st passenger
    And Select the year "1990", month "1", day "15" as the date of birth
    Then Verify that the "Invalid email address" message is not displayed
    And Verify that the "Invalid phone number" message is not displayed

  @Regression
  Scenario: Validate that passenger flight information 2

    When Click on the Flight Tab
    And Click on round trip checkbox
    And Select "First Class" for flight class
    And Select "USA" for from dropdown and select "Japan" for to dropdown
    And Select "2" adults and "1" child and click on search flight button
    And Click on select ticket button for #1 flight
    And Click on select return ticket button for #1 flight
    And Click on select who's flying button
    And Fill "bbbbb@gmail.com" as contact email
    And Select "+33 (FR)" for country code dropdown and fill "4445756661" as phone number
    And Fill in "Ali" as the name, "Veli" as the surname, "Female" as the gender, "1995" as the year, "4" as the month, "3" as the day for the #1 passenger
    And Fill in "Scarlett" as the name, "John" as the surname, "Female" as the gender, "1992" as the year, "4" as the month, "3" as the day for the #2 passenger
    And Fill in "John" as the name, "Eris" as the surname, "Male" as the gender, "2005" as the year, "2" as the month, "6" as the day for the #3 passenger
    Then Verify that the "Please select a gender." message is not displayed
    Then Verify that the "Please enter a name." message is not displayed
    Then Verify that the "Please enter a surname." message is not displayed

  @Smoke
  Scenario: Validate that flight fare calculation

    When Click on the Flight Tab
    And Click on round trip checkbox
    And Select "Business" for flight class
    And Select "USA" for from dropdown and select "Canada" for to dropdown
    And Select "2" adults and "2" child and click on search flight button
    And Click on select ticket button for #1 flight
    And Click on select ticket button for #1 flight
    And Click on select who's flying button
    Then Verify that total flight fare

#Tests for Flight Extras Page
  @Regression
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
    Then Verify that the user is on Flight Check And Pay Page
    Examples:
      | Origin  | Destination | Departure Fare Type | Return Fare Type | Gmail                 | Country Code | Phone Number | Traveler Name | Traveler Surname | Gender | Birth Year | Birth Month | Birth Day | Meal                   | Extras1            | Extras2           |
      | USA     | Canada      | Refundable Main     | First Class      | john15@gmail.com      | +33 (FR)     | 4445756661   | John          | Curtis           | Male   | 1995       | 4           | 3         | Kosher Meal - $20      | Extra Legroom Seat | Lounge Access     |
      | Germany | France      | Main                | Business         | user+#15@gmail.com    | +44 (UK)     | 2345467789   | Sally         | Hawkins          | Female | 2003       | 8           | 17        | Gluten-free Meal - $18 | Extra Comfort Kit  | Travel Insurance  |
      | Japan   | Brazil      | Business            | Refundable Main  | willJames15@gmail.com | +81 (JP)     | 1122233332   | Will          | James            | Other  | 1978       | 12          | 31        | Diabetic Meal - $19    | Travel Insurance   | Extra Comfort Kit |

#  Tests For Flight Check And Pay Page
  @Regression
  Scenario: Validate that the successful check and pay

    When Click on the Flight Tab
    And Click on round trip checkbox
    And Select "Economy" for flight class
    And Select "USA" for from dropdown and select "Canada" for to dropdown
    And Select "1" adults and "0" child and click on search flight button
    And Click on select ticket button for #1 flight
    And Click on select ticket button for #1 flight
    And Click on select who's flying button
    And Fill "bbbbb@gmail.com" as contact email
    And Select "+33 (FR)" for country code dropdown and fill "4445756661" as phone number
    And Fill in "Ali" as the name, "Veli" as the surname, "Female" as the gender, "1995" as the year, "4" as the month, "3" as the day for the #1 passenger
    And Click on select extras button
    And Click on go to checkout  button
    And Fill in "John" as the cardholder's name
    And Fill in "1234567891234567" as the card number
    And Fill in "11/25" as the expiration date
    And Fill in "345" as the cvc code
    And Click on complete booking button
    Then Validate the user is on confirmation page

#    Tests with invalid credentials on the check and pay page
  @Regression
  Scenario: Validate That CardHolder's Name Information During The Check And Pay Process

    When Click on the Flight Tab
    And Click on round trip checkbox
    And Select "Economy" for flight class
    And Select "USA" for from dropdown and select "Canada" for to dropdown
    And Select "1" adults and "0" child and click on search flight button
    And Click on select ticket button for #1 flight
    And Click on select ticket button for #1 flight
    And Click on select who's flying button
    And Fill "ashta@gmail.com" as contact email
    And Select "+33 (FR)" for country code dropdown and fill "4445756661" as phone number
    And Fill in "Ali" as the name, "Veli" as the surname, "Female" as the gender, "1995" as the year, "4" as the month, "3" as the day for the #1 passenger
    And Click on select extras button
    And Click on go to checkout  button
    And Fill in "23425" as the cardholder's name
    And Fill in "1234567891234567" as the card number
    And Fill in "11/25" as the expiration date
    And Fill in "345" as the cvc code
    And Click on complete booking button
    Then Verify that the user is on Flight Check And Pay Page

  @Regression
  Scenario: Validate That Expiration Date Of Card During The Check And Pay Process

    When Click on the Flight Tab
    And Click on round trip checkbox
    And Select "Economy" for flight class
    And Select "USA" for from dropdown and select "Canada" for to dropdown
    And Select "1" adults and "0" child and click on search flight button
    And Click on select ticket button for #1 flight
    And Click on select ticket button for #1 flight
    And Click on select who's flying button
    And Fill "ashta@gmail.com" as contact email
    And Select "+33 (FR)" for country code dropdown and fill "4445756661" as phone number
    And Fill in "Ali" as the name, "Veli" as the surname, "Female" as the gender, "1995" as the year, "4" as the month, "3" as the day for the #1 passenger
    And Click on select extras button
    And Click on go to checkout  button
    And Fill in "23425" as the cardholder's name
    And Fill in "1234567891234567" as the card number
    And Fill in "11/11" as the expiration date
    And Fill in "345" as the cvc code
    Then Verify that the expiration of date invalid message is displayed

#    Tests For Flight Confirmation Page
  @Regression
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

  @Daily @End2End
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
      | Economy      | Brazil | Australia   | May 1, 2024  | May 31, 2024 | 2            | 0            | First Class         | Refundable Main  | berkan@gmail.com | +81 (JP)     | 9875641236   | Halal Meal - $16  | Extra Legroom Seat | Travel Insurance   | Nafiz  | 9632587412546987 | 1229            | 985      |


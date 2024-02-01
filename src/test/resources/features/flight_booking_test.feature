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


  Scenario: Validate that flight fare calculation

    When Click on the Flight Tab
    And Click on round trip checkbox
    And Select "Business" for flight class
    And Select "USA" for from dropdown and select "Canada" for to dropdown
    And Select "2" adults and "2" child and click on search flight button
    And Click on select ticket button for #1 flight
    And Click on select ticket button for #1 flight
    And Click on select who's flying button
    And Calculate total price
    Then Verify that total flight fare


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
    And Fill in "1125" as the expiration date
    And Fill in "345" as the cvc code
    And Click on complete booking button
    Then Validate the user is on confirmation page


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
    When Select "<Airlines>" for airlines
    And Click on search button
    And Click on select ticket button for #1 flight
    And Click on select return ticket button for #1 flight
    And Click on "<Departure Fare Type>" for departure fare type
    And Click on "<Return Fare Type>" for return fare type
    And Click on select who's flying button
    And Calculate total price
    Then Verify that total flight fare
    When Fill "<Gmail>" as contact email
    And Select "<Country Code>" for country code dropdown and fill "<Phone Number>" as phone number
    And Fill in "John" as the name, "Chris" as the surname, "Male" as the gender, "1985" as the year, "10" as the month, "15" as the day for the #1 passenger
    And Click on select extras button
    And Select "<Meal>" , "<Extras1>" , "<Extras2>"
    Then Verify that total price calculation is correct after "<Meal>" , "<Extras1>" , "<Extras2>" selections
    Then Verify that "<Meal>" , "<Extras1>" , "<Extras2>" is selected
    And Click on go to checkout  button
    When Calculate total price
    Then Verify that total flight fare
    When Fill in "<Name>" as the cardholder's name
    And Fill in "<Card Number>" as the card number
    And Fill in "<Expiration Date>" as the expiration date
    And Fill in "<CVC Code>" as the cvc code
    And Click on complete booking button
    Then Validate the user is on confirmation page
    Examples:
      | Flight class | Origin | Destination | First Date   | Last Date    | Adult Number | Child Number | Airlines  | Departure Fare Type | Return Fare Type | Gmail            | Country Code | Phone Number | Meal              | Extras1            | Extras2            | Name   | Card Number      | Expiration Date | CVC Code |
      | Business     | USA    | Canada      | Feb 14, 2024 | Feb 27, 2024 | 1            | 0            | Airline Z | Refundable Main     | Business         | bbb@gmail.com    | +44 (UK)     | 4444444444   | Kosher Meal - $20 | Extra Comfort Kit  | Extra Legroom Seat | Ben    | 4569875412365897 | 0424            | 325      |
      | Flight Class | Spain  | Italy       | Mar 5, 2024  | Mar 30, 2024 | 0            | 1            | Airline X | Main                | First Class      | Gmail@gmail.com  | +61 (AU)     | 2546987452   | Gluten-free Meal  | Travel Insurance   | Lounge Access      | Furkan | 3658974521236589 | 1126            | 254      |
      | Economy      | China  | Germany     | May 1, 2024  | May 31, 2024 | 1            | 0            | Airline Y | First Class         | Refundable Main  | berkan@gmail.com | +81 (JP)     | 9875641236   | Halal Meal - $16  | Extra Legroom Seat | Travel Insurance   | Nafiz  | 9632587412546987 | 1229            | 985      |





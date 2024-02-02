#Author: MFA-NA
#Date: 2024-31-01
#Description: This is a test case for smoke test

#Test Case: BK_HP_001
#Test Title: Validate the successful hotel reservation process

@hotel
Feature: Stay Filtering

  Background:
    Given Navigation to the baseURL
    And Click on the Booking Link

  @functional
  Scenario: Hotel Reservation with Visitor Details and Finalization

    When Click on the search hotels button
    And Click on the see availability button for #1 hotel
    And Click on the reserve or book now button
    And Click on the no checkbox for are you traveling for business
    And Fill in first name "Nisanur" last name "Altuntas" for visitor
    And Fill in "nialandin@gmail.com" as contact email
    And Click on the I'm the main guest for checkbox
    And Write that you have no "<request>" requests
    And Choose unknown from the arrival time options
    And Click on the next, final details button
    Then Verify that you can pass the final step page

  @smoke
  Scenario: Complete Hotel Booking with Visitor and Payment Details

    When Click on the search hotels button
    And Click on the see availability button for #1 hotel
    And Click on the reserve or book now button
    And Fill in first name "Furkan" last name "Altun" for visitor
    And Fill in "frknmail@gmail.com" as contact email
    And Click on the booking for someone else for checkbox
    And Click on the next, final details button
    And Select "+1 (US)" for country code dropdown and fill in "7772228882" as phone number
    And Click yes checkbox for free paper approval
    And Click the yes checkbox to save the details
    And Write the Card Holder's Name as "Furkan Altun"
    And Enter card number as "7772228887779994"
    And Enter expiration date as "1222"
    And Enter cvv as "777"
    And Select both checkboxes to receive notification emails
    And Click on the complete booking button
    Then Confirm that you have successfully navigated to the "Urban Oasis Resort" confirmation page

  @functional
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

  @validate
  Scenario: Validate that the stays selection process
    Given Navigation to the Hotel Details Page
    When Choose "Istanbul" where to stay
    And Select "Skate Parkour" and select "Cycling" for fun things to do
    And Select "Free parking" for additional features
    And Click on search hotels button
    And Click on the see availability button for #1 hotel
    Then Verify that the user is on the details page

  @functional
  Scenario: Verify that hotels are selectable
    Given Navigation to the Hotel Details Page
    When  Click on search hotels button
    And  Select "City Center Suites" and "Grand Plaza Hotel" for hotels
    And Click on search hotels button
    And  Click on the see availability button for #2 hotel
    Then Verify that the user is on the details page

  @functional
  Scenario Outline: Validate that the textarea, slide, checkboxes and radio buttons functionality for round trip
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

  @EndToEnd
  Scenario:Verify the functionality of the hotel booking tab with end-to-end testing

    When Type the destination "Amsterdam" where you will be staying
    And Select "3" adults and "4" child and "2"room
    When Click on the search hotels button
    And Select "Bicycle rental" and select "Fitness" for fun things to do
    And Select "Free WiFi" select "Elevator" for additional features
    And Select "Coastal Breeze Inn" for hotels
    And Select "2" for number of bedrooms spinner overflow
    And Click on search hotels button
    And Click on the see availability button for #1 hotel
    And Verify that "Coastal Breeze Inn" selected
    And Click on the reserve or book now button
    And Click on the no checkbox for are you traveling for business
    And Fill in first name "Furkan" last name "Altun" for visitor
    And Fill in "frknmail@gmail.com" as contact email
    And Click on the I'm the main guest for checkbox
    And Write that you have no "I don't have any requests" requests
    And Choose your arrival time between 10 and 11
    And Click on the next, final details button
    And Select "+1 (US)" for country code dropdown and fill in "7772228882" as phone number
    And Click yes checkbox for free paper approval
    And Click the yes checkbox to save the details
    And Write the Card Holder's Name as "Furkan Altun"
    And Enter card number as "7772228887779994"
    And Enter expiration date as "1222"
    And Enter cvv as "777"
    And Select both checkboxes to receive notification emails
    And Click on the complete booking button
    Then Confirm that you have successfully navigated to the "Coastal Breeze Inn" confirmation page
    And Click on the close button


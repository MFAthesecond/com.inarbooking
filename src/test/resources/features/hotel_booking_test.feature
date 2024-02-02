#Author: MFA-NA
#Date: 2024-01-02
#Description: This is a test case for smoke test

#Test Case: BK_HP_001
#Test Title: Validate the successful hotel reservation process

@example
Feature: Hotel Filtering

  Background:
    Given Navigation to the baseURL
    And Click on the Booking Link
    And Click on the Stays Tab

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

  Scenario Outline:Verify the functionality of the hotel booking tab with end-to-end testing

    When Type the destination "<destination>" where you will be staying
    And Select "<adultnum>" adults and "<childnum>" child and "<NumberRoom>"room
    And Click on the search hotels button
    And Select "<FunThingsToDo1>" and select "<FunThingsToDo2>" for fun things to do
    And Select "<AdditionalFeatures1>" select "<AdditionalFeatures2>" for additional features
    And Select "<Hotel>" for hotels
    And Select "<NumberRoom>" for number of bedrooms spinner overflow
    And Click on search hotels button
    And Click on the see availability button for #1 hotel
    And Verify that "<Hotel>" selected
    And Click on the reserve or book now button
    And Click on the no checkbox for are you traveling for business
    And Fill in first name "<firstName>" last name "<lastName>" for visitor
    And Fill in "<contactEmail>" as contact email
    And Click on the I'm the main guest for checkbox
    And Write that you have no "<requests>" requests
    And Choose your arrival time between 10 and 11
    And Click on the next, final details button
    And Select "<countryCode>" for country code dropdown and fill in "<phoneNumber>" as phone number
    And Click yes checkbox for free paper approval
    And Click the yes checkbox to save the details
    And Write the Card Holder's Name as "<cardHolderName>"
    And Enter card number as "<cardNumber>"
    And Enter expiration date as "<expirationDate>"
    And Enter cvv as "<cvv>"
    And Select both checkboxes to receive notification emails
    And Click on the complete booking button
    Then Confirm that you have successfully navigated to the "Coastal Breeze Inn" confirmation page
    And Click on the close button

    Examples:
      | destination | adultnum | childnum | NumberRoom | FunThingsToDo1 | FunThingsToDo2 | AdditionalFeatures1 | AdditionalFeatures2 | Hotel                  | NumberRoom | firstName | lastName | contactEmail            | requests             | countryCode  | phoneNumber | cardHolderName | cardNumber       | expirationDate | cvv |
      | Amsterdam   | 3        | 4        | 2          | Bicycle rental | Fitness        | Free WiFi           | Elevator            | Coastal Breeze Inn     | 2          | Furkan    | Altun    | frknmail@gmail.com      | cookie               | +1 (US)      | 7772228882  | Furkan Altun   | 7772228887779994 | 1222           | 777 |
      | Paris       | 2        | 2        | 1          | Walking Tours  | Cycling        | Heating             | Baggage storage     | City Center Suites     | 1          | Emma      | Johnson  | emma.j@example.com      | No special requests  | +33 (France) | 33611223344 | Emma Johnson   | 5555444433331111 | 0523           | 123 |
      | New York    | 4        | 1        | 3          | Skate Parkour  | Fitness        | 24-hour front desk  | Daily housekeeping  | Mountain Lodge Retreat | 3          | James     | Smith    | james.smith@example.com | Extra pillows please | +1 (US)      | 6465551234  | James Smith    | 4111111111111111 | 0624           | 456 |
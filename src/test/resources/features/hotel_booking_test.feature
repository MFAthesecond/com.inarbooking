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
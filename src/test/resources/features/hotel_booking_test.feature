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

  Scenario:

    When Click on the search hotels
    And Click on the see availability button for #1 hotel
    And Click on the reserve or book now button
    And Click on the no checkbox for are you traveling for business
    And Fill in first name "Nisanur" last name "Altuntas" for passenger
    And Fill "nialandin@gmail.com" as contact email
    And Click on the I'm the main guest for chekcbox
    And Write that  you have no "<request>" requests
    And Choose unknown from the arrival time options
    And Click on the next, final details button
    Then Verify that you can pass the final step page

  Scenario:

    When Choose "Istanbul" where to stay
    And Select "2" adults and "1" child and "2" room and click done button
    And Click on search search hotels button
    And Click on the see availability button for #1 hotel
    And Click on the reserve or book now button
    And Click on the yes checkbox for are you traveling for business
    And Fill in first name "Furkan" last name "Altun" for passenger
    And Fill "frknmail@gmail.com" as contact email
    And Click on the booking for someone else for chekcbox
    And Click on the next, final details button
    And Select "+49 (DE)" for country code dropdown and fill "44457545654" as phone number
    And Click yes checkbox for free paper approval
    And Click the yes checkbox to save the details
    And Write the Card Holder's Name as "Furkan Altun"
    And Enter card number as "1234123412341223"
    And Enter expiration date as "1225"
    And Enter cvv as "564"
    And Select both checkboxes to receive notification emails
    And Click on the complete booking button
    Then Confirm that you have successfully navigated to the confirmation page
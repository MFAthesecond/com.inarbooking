@example
Feature: Car Rental Page Verification

  Background:
    Given Navigation to the baseURL
    And Click on the Booking Link
    And Navigation to the Car Rentals page

  Scenario: Test Car Rentals Page For Some Configurations
    When click On Search Button On The Inar Booking HomePage
    And Select The Drivers Age as '40'
    Then Verify That Driver Aged Button Clicked 'true'
    When Set the Pickup Location On Configpage as 'Grand Bazaar'
    When Select The Price Range from '20' to '350'
    And Select 'Automatic Transmission' '' 'Heated Seats' ''Car Specs
    And Select Transmission as 'Automatic'
    When Select From Car Category The 'Large'
    When Select From Car Category The 'Suv'
    When Select From Car Category The 'Minivan'
    When Click on search button In Car Rental Config Page
    When Sort The Cars By Lowest Price
    Then Verify That Cars Sorted By Lowest Price
    When Sort The Cars By Highest Price
    Then Verify That Cars Sorted By Highest Price
    Then Verify That Cars Are Only From 'Grand Bazaar'
    Then Verify That All Prices Are Within Given Range
    Then Verify That Transmission Is 'Automatic'
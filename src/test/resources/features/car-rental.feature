@example
Feature: Car Rental page verification

  Background:
    Given Navigation to the baseURL
    Given Click on the Booking Link
    And Navigation to the Car Rentals page
#
#  Scenario Outline: Tests Car Rentals On The Inar Booking HomePage
#    When Enter Pickup Location As '<Pickup Location>'
#    And Click on Pickup Date
#    And Click On Pickup Hour And Choose '<Pick up Hour>'
#    And Click On DropOff Date
#    And Click On Drop Hour And Set The Time as '<Drop-Off Hour>'
#
#    Then Verify That PickUp Location Inar Booking HomePage Is '<Pickup Location>'
#    And Verify That Pickup Date On The Inar Booking HomePage Is '<Pick up Hour>'
#    And Verify That DropOff Date On The Inar Booking HomePage Is '<Drop-Off Hour>'
#
#    When click On Search Button On The Inar Booking HomePage
#    Examples:
#      | Pickup Location  | Pick up Hour | Drop-Off Hour |
#      | Heathrow Airport | 05:30        | 14:00         |
#      | Heathrow Airport | 01:00        | 23:00         |
#      | Heathrow Airport | 00:00        | 00:30         |
#      | Grand Bazaar     | 15:00        | 20:30         |
#      | Taj Mahal        | 22:30        | 06:30         |


  Scenario: Tests Car Rentals Page For Some Configurations
    When click On Search Button On The Inar Booking HomePage
    When Select The Drivers Age as '35'
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
    Then Verify That All Prices Are Within '350'
    Then Verify That Transmission Is 'Automatic'


  Scenario: Test Cases for Check-out Process
    When click On Search Button On The Inar Booking HomePage
    When Set the Pickup Location On Configpage as 'Grand Bazaar'
    When Select From Car Category The 'Large'
    When Select From Car Category The 'Suv'
    When Select From Car Category The 'Minivan'
    When Select From Car Category The 'Small'
    When Select From Car Category The 'Medium'
    When Click on search button In Car Rental Config Page
    When Sort The Cars By Lowest Price
    And Click on '0' Car's View Deal Element
    When Click On Go To Book Element From Car Insurance Page


























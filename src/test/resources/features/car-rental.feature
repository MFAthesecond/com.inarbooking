@example
Feature: Car Rental page verification

  Background:
    Given Navigation to the baseURL
    Given Click on the Booking Link
    And Navigation to the Car Rentals page

  Scenario Outline: e: Tests Car Rentals On The Inar Booking HomePage
    When Enter Pickup Location As '<Pickup Location>'
    And Click on Pickup Date
    And Click On Pickup Hour And Choose '<Pick up Hour>'
    And Click On DropOff Date
    And Click On Drop Hour And Set The Time as '<Drop-Off Hour>'

    Then Verify That PickUp Location Inar Booking HomePage Is '<Pickup Location>'
    And Verify That Pickup Date On The Inar Booking HomePage Is '<Pick up Hour>'
    And Verify That DropOff Date On The Inar Booking HomePage Is '<Drop-Off Hour>'

    When click On Search Button On The Inar Booking HomePage
    Examples:
      | Pickup Location  | Pick up Hour | Drop-Off Hour |
      | Heathrow Airport | 05:30        | 14:00         |
      | Heathrow Airport | 01:00        | 23:00         |
      | Heathrow Airport | 00:00        | 00:30         |
      | Grand Bazaar     | 15:00        | 20:30         |
      | Taj Mahal        | 22:30        | 06:30         |














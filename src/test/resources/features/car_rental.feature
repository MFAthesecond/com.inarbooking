@bilal
Feature: Car Rental page verification

  Background:
    Given Navigation to the baseURL
    Given Click on the Booking Link
    And Navigation to the Car Rentals page

  Scenario Outline: Tests Car Rentals On The Inar Booking HomePage
    When Enter Pickup Location As '<Pickup Location>'
    When Set The Pick Up Date As '<Pick up Date>' In Car Rental Home Page
    And Set The Drop Off Date As '<Drop off Date>' In Car Rental Home Page
    And Click On Pickup Hour And Choose '<Pick up Hour>'
    And Click On Drop Hour And Set The Time as '<Drop-Off Hour>'
    Then Verify That PickUp Location Inar Booking HomePage Is '<Pickup Location>'
    And Verify That Pickup Date On The Inar Booking HomePage Is '<Pick up Hour>'
    And Verify That DropOff Date On The Inar Booking HomePage Is '<Drop-Off Hour>'
    And Verify That Pick Up Date Is '<Pick up Date>'
    And Verify That Drop Date Is As '<Drop off Date>'

    When click On Search Button On The Inar Booking HomePage
    Then Verify That Program Passed To Car Rental Config Page
    Examples:
      | Pickup Location | Pick up Hour | Drop-Off Hour | Pick up Date | Drop off Date |
      | Grand Bazaar    | 00.30        | 05:00         | 03/15/2024   | 03/19/2024    |
      | Central Park    | 14:00        | 22:00         | 12/15/2024   | 12/25/2024    |

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
    Then Verify That All Prices Are Within Given Range
    Then Verify That Transmission Is As Given


  Scenario: Test Cases for Insurance Page
    When click On Search Button On The Inar Booking HomePage
    When Set the Pickup Location On Configpage as 'Grand Bazaar'
    And Select From Car Category The 'Large'
    And Select From Car Category The 'Suv'
    And Select From Car Category The 'Minivan'
    And Select From Car Category The 'Small'
    And Select From Car Category The 'Medium'
    When Click on search button In Car Rental Config Page
    When Sort The Cars By Lowest Price
    And Click on '0' Car's View Deal Element
    Then Verify That Program Passed To Insurance Page
    When Click On Go To Book Element From Car Insurance Page
    Then Verify That Program Passed To CheckOut Page




  Scenario: Test Case for Configuration Process
    When Enter Pickup Location As 'Grand Bazaar'
    And Click On Pickup Hour And Choose '10:30'
    And Click On Drop Hour And Set The Time as '23:00'
    When click On Search Button On The Inar Booking HomePage
    When Select The Drivers Age as '35'
    When Select Car Category Via DataTable
      | Large   |
      | SUV     |
      | Minivan |
      | Small   |
      | Medium  |
    When Select Car Specs Via DataTable
      | Air Conditioning       |
      | 4+ Doors               |
      | GPS Navigation         |
      | Bluetooth Connectivity |
      | Automatic Transmission |
      | Leather Seats          |
      | Sunroof                |
      | Backup Camera          |
      | Heated Seats           |
      | Keyless Entry          |
    When Select The Price Range Via DataTable
      | $0-50    |
      | $50-100  |
      | $100-150 |
      | $150-200 |
      | $200-250 |
      | $250-300 |
      | $300-350 |
      | $350-400 |
      | $400-450 |
      | $450-500 |
    When Set The Car's Transmission Via DataTable
      | Automatic |
      | Manual    |
    Then Verify That Items Are Selected In In Car Rental Config Page
      | $100-150               |
      | $150-200               |
      | $200-250               |
      | $250-300               |
      | $300-350               |
      | Automatic Transmission |
      | Leather Seats          |
      | Sunroof                |
      | Backup Camera          |
      | Automatic              |
      | Manual                 |
      | SUV                    |
      | Minivan                |
      | Small                  |
      | Medium                 |
    When Click on search button In Car Rental Config Page
    And Sort The Cars By Highest Price
    Then Verify That All Prices Are Within Given Range
    Then Verify That Car Category is Formed By As Given
    And Click on '1' Car's View Deal Element
    Then Verify That Program Passed To Insurance Page


  Scenario: Test Cases For Insurance Page
    When Enter Pickup Location As 'Grand Bazaar'

    When Get The Order Details As Location Date And Hour

    When click On Search Button On The Inar Booking HomePage

    When Select Car Category Via DataTable
      | Large   |
      | SUV     |
      | Minivan |
      | Small   |
      | Medium  |
    When Click on search button In Car Rental Config Page

    And Get The Number Of Days For Rental In Config Page

    When Sort The Cars By Highest Price

    When Get The Price Of #'1' Car's In The Page

    And Get The Name Of #'1' Car's In Config Page

    And Click on '1' Car's View Deal Element

    When Get The Percentage Of Tax

    Then Verify That Total Car Price Breakdown Is Accurate In Insurance Page

    When Get The Order Details As Location Date And Hour On Insurance Page

    Then Verify That Order Details Date Place Hour As Given


  Scenario Outline: Car Rentals Checkout Process Validation45879

    When click On Search Button On The Inar Booking HomePage

    When Select Car Category Via DataTable
      | Large   |
      | SUV     |
      | Minivan |
      | Small   |
      | Medium  |
    When Click on search button In Car Rental Config Page

    And Click on '<nthCars>' Car's View Deal Element

    When Click On Go To Book Element From Car Insurance Page

    When Enter Your Name As '<Name>' In Car Rental Checkout Page
    And Enter Your LastName As '<LastName>' In Car Rental Checkout Page
    And Select The Country Code As '<countryCode>' For Telephone In Car Rental Checkout Page
    And Enter Your Phone Number As '<PhoneNumber>' In Car Rental Checkout Page
    And Enter Your Country As '<country>' In Car Rental Checkout Page
    And Enter Your Adress As '<address>' In Car Rental Checkout Page
    And Enter Your City As '<city>' In Car Rental Checkout Page
    And Enter Your As Postal Code '<postalCode>' In Car Rental Checkout Page
    And Enter Your Card Holder Name As '<CardHolderName>' In Car Rental Checkout Page
    And Enter Your  Card Number As '<cardNumber>' In Car Rental Checkout Page
    And Enter Your Expriration Date As '<expirationDate>' In Car Rental Checkout Page
    And Enter Your CVV As '<CVV>' In Car Rental Checkout Page
    Then Verify That Number Of Text Danger Message Is '<numberOfExpectedFaultMessage>'
    Examples:
      | nthCars | Name | LastName  | countryCode | PhoneNumber | country | address     | city    | postalCode | CardHolderName | cardNumber       | expirationDate | CVV | numberOfExpectedFaultMessage |
      | 1       | eric | capona    | +61         | 1234567890  | Canada  | Hull Street | Quebec  | 9652       | Eric Capona    | 1234567891234567 | 12/25          | 456 | 0                            |
      | 1       |      | Derenoğlu | +1          | 9632587412  |         | MCDaldre    | Chicago | 122563     | Han Derenoğlu  | 2587413697896541 | 10/32          | 450 | 2                            |


  Scenario: Test Cases About Message After Completation Of Order
    When Get The Pickup Date In Car Rental Home Page
    When click On Search Button On The Inar Booking HomePage
    And Click on '0' Car's View Deal Element
    When Get The Name Of Car In Insurance Page
    When Click On Go To Book Element From Car Insurance Page
    When Enter Your Name As 'Felix' In Car Rental Checkout Page
    And Enter Your LastName As 'Curt' In Car Rental Checkout Page
    And Select The Country Code As '+1' For Telephone In Car Rental Checkout Page
    And Enter Your Phone Number As '7895462130' In Car Rental Checkout Page
    And Enter Your Country As 'USA' In Car Rental Checkout Page
    And Enter Your Adress As 'New York' In Car Rental Checkout Page
    And Enter Your City As 'New York' In Car Rental Checkout Page
    And Enter Your As Postal Code '89747' In Car Rental Checkout Page
    And Enter Your Card Holder Name As 'Felix Curt' In Car Rental Checkout Page
    And Enter Your  Card Number As '2581473691236547' In Car Rental Checkout Page
    And Enter Your Expriration Date As '12/35' In Car Rental Checkout Page
    And Enter Your CVV As '458' In Car Rental Checkout Page
    When Click On Consent Of Taking Email Element In Car Rental Checkout Page
    When Click On Book Now Element In Car Rental Checkout Page
    Given Verify That Name In Confirmation Message Matches With Given Name 'Felix Curt'
    Given Verify That Name Of Car Is As Same As In Insurance Page
    Given Verify That Pick Up Date Matches With Car Rentals Home Page Given Pickup Date


  Scenario:   Test Cases For Inappropriate Date Inputs
    When Set The Pick Up Date As '03/15/2024' In Car Rental Home Page
    And Set The Drop Off Date As '03/15/2023' In Car Rental Home Page
    When click On Search Button On The Inar Booking HomePage
    Then Verify That An Alert Message Appeared In In Car Rental Home Page
    When Accept The Alert Message In In Car Rental Home Page
    When Set The Pick Up Date As '03/10/2024' In Car Rental Home Page
    And Set The Drop Off Date As '03/15/2024' In Car Rental Home Page
    When click On Search Button On The Inar Booking HomePage
    Then Verify That Program Passed To Car Rental Config Page












































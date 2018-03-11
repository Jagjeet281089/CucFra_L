Feature: Home Page

 @Wip
 Scenario: Verify if User opens the home page first time then it should see the login popup.
    Given User opens Home Page
    Then User sees the Login popup

 @Wip
 Scenario: Verify if User closes the Login popup then it should see the product search bar.
    Given User opens Home Page
    When User closes the Login popup    
    Then User sees the Search Bar
    
 @Done
 Scenario: Customer places an order by purchasing an item from search
    Given User is on Home Page
    When he search for "dress"
    And choose to buy the first item
    And moves to checkout from mini cart
    And enter personal details on checkout page
    And select same delivery address
    And select payment method as "check" payment
    And place the order
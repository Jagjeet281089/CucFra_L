Feature: Home Page

 @Done
 Scenario: Verify if User opens the home page first time then it should see the login popup.
    Given User opens Home Page
    Then User sees the Login popup

 @Done
 Scenario: Verify if User closes the Login popup then it should see the product search bar.
    Given User opens Home Page
    When User closes the Login popup    
    Then User sees the Search Bar
    
 @Wip
 Scenario Outline: Customer place an order by purchasing an item from search
   Given User opens Home Page
   And User Login via popup by providing mobile as "7888422972" and password as "qaz123wsx"
   And User searches for "Iphone X"
   And User chooses to buy the product with name "Apple iPhone X (Space Gray, 64 GB)"
   And User opens Cart Page and moves to place order
#  And User enters personal details on checkout page
   And enter "<customer>" personal details on checkout page
#
#
# And select same delivery address
#   And select payment method as "check" payment
#   And place the order
  Examples:
    |customer|
     |Jagjeet|
     |Ashu   |
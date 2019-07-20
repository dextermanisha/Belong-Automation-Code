Feature: Belong Automation Practise
 
   Scenario: Verifying Registering and Shopping Cart
    Given User should be able to register
    When correct email address is entered or should be shown an error message
    When user is on Megamenu and user hovers over Dresses
    Then user should be able to see Summer Dresses
    When user selects a dress an adds to cart
    Then user should be able to see the cart summary page
    Then the same product name , color and quantity are displayed in Cart Summary page


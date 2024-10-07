Feature: Purchase Product

  Scenario: Successfully purchase a product
    Given I am on the home page
    When I select a product
    And I add the product to the cart
    And I go to the cart
    And I place an order
    And I fill in my personal information
    And I complete the purchase
    Then I should see a confirmation message

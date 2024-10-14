Feature: Smoke Test

  Scenario: Ensure home page loads and displays products
    Given I am on the home page
    Then I should see a list of products

  Scenario: Ensure product details page is accessible
    Given I am on the home page
    When I click on a product
    Then I should be redirected to the product details page

  Scenario: Add a product to the cart
    Given I am on the product details page
    When I click on "Add to cart"
    Then the product should be added to my cart

  Scenario: Place an order
    Given I have added products to my cart
    And I am on the cart page
    When I click on "Place order"
    And I fill in the payment form
    Then I should see a confirmation message

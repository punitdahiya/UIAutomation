Feature: Dashboard

  @dashboard @SmokeTest
  Scenario: Verify user is able add product to cart and able to checkout those products
    Given User is on inventory dashboard page 'standard_user' 'secret_sauce'
    When Click on add to cart button of first product
    Then Ensure remove button is present there
    When Click on cart button
    Then Ensure your cart screen opens
    And Ensure that product is present in cart
    When Click on checkout button
    And Enter first name, last name and Zip code 'test_first' 'test_last' '121'
    And Click on Continue button
    Then Ensure user is on Checkout: Overview page
    And Ensure given product is present on Checkout: Overview page
    And Ensure following information are present there - Payment Information and Shipping Information
    When Click on finish button
    Then Ensure user get order success message
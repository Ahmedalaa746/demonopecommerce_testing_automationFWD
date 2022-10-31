@smoke
Feature: F08_Wishlist | users could add an item to their wishlist and then check it out later

  Scenario: user adds an item to the wishlist
    When user clicks on wishlist button on product
    Then user will see a green success message

  Scenario: user adds an item to the wishlist and checks wishlist
    When user clicks on wishlist button on product
    And user clicks on wishlist
    Then user will see product in wishlist
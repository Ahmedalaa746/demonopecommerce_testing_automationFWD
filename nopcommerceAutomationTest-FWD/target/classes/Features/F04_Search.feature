@smoke
Feature: F04_Search | users could use search functionality to use find products
  Scenario Outline: user could search using product name
    Given user types <name> in search box and presses the search button
    And the url contains search url
    Then search shows relevant results that contain <name>
    Examples:
      | name |
      | book |
      | laptop|
      | nike |

  Scenario Outline: user could search for product using sku
    Given user typed <sku> in search box and pressed search
    When user clicks on the product in search result
    Then the sku shown in this page contains the <sku> that was used in search
    Examples:
      |sku|
      |SCI_FAITH|
      |APPLE_CAM|
      |SF_PRO_11|
      |AP_MBP_13|
@smoke
Feature: Currencies | user could select a currency and find prices in that currency
  Scenario: user could select and view prices in a currency successfully
    When Select Euro currency from the dropdown list on the top left of home page
    Then verify Euro Symbol (€) is shown on the 4 products displayed in Home page
@smoke

  Feature: Registration users could register by new accounts

    Scenario: guest users could register by valid data successfully

      Given user go to register page
      When user select gender type
      And user enter first name 'automation' and last name 'tester'
      And user enter data of birth
      And User enter email "test@exapmle.com" field
      And User filled password field "P@sswOrd""P@sswOrd"
      And User clicks in register button
      Then Success message is displayed

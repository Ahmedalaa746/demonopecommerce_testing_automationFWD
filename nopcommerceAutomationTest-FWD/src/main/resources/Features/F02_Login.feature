@smoke
  Feature: F02_Login  Users could use login functionality to their accounts

    Scenario:  user could login with valid email and password
      Given  user go to login page
      When  user go to login with valid "test@example.com" and "P@sswOrd"
      And user press on login button
      Then user login with to the system successfully

      Scenario: user could login with invalid email and password

        Given  user go to login page
        When  user go to login with invalid "wrong@example.com" and "P@sswOrd"
        And user press on login button
        Then user could not  login  to the system successfully

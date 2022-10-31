@smoke
Feature: F06_homeSliders | users could see and click on the two sliders in the homepage

  Scenario: first slider is clickable on home page
    When user clicks on first slider
    Then check if url is nokia url

  Scenario: second slider is clickable on home page
    When user clicks on second slider
    Then check if url is iphone url
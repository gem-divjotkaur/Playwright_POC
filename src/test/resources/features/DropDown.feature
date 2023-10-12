@Dropdown
Feature: Playwright Dropdowns

  Scenario: Handle dropdowns in Playwright
    Given User select "Orange" from "fruits"
    And User selects "The Avengers" and "Batman" from the "heroes" dropdown
    And User count all the values from "language" dropdown and print last value
    And User print all the values from "country" dropdown
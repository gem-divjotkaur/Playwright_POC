@BrowserContext
Feature: Browser Context

  Scenario Outline: Handle Browser Context in Playwright
    Given User launch the browser
    When User searches for "<shoe>" in Amazon
    And User searches for "<shoe>" in Myntra
    Then User closes the browser

    Examples:
      | shoe  |
      | shoes |
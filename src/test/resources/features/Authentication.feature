@Authentication
Feature: Http Authentication

  Scenario Outline: Http Authentication in Playwright
    Given User launches site by providing "<username>" and "<password>"
    When User gets the data from the Authentication page
    Then User closes page

    Examples:
      | username | password |
      | admin    | admin    |
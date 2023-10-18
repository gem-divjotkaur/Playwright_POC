@ScriptWithoutFindElement
Feature: Write script without finding element

  Scenario Outline: User write script without actually finding elements
    Given User navigates to Book-cart website
    When User logins with username as "<username>" and password as "<password>"
    And User searches for a "<book>" in the search-box
    And User click on image
    Then User closes Book-cart website
    Examples:
      | username | password  | book |
      | ortoni   | Pass1234$ | hp   |
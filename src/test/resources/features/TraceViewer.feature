@Trace
Feature: Trace Viewer

  Scenario Outline: Trace Viewer in Playwright
    Given User open Facebook app
    When User enter the firstname "<firstname>"
    And User enter the surname "<surname>"
    And User enter email as "<email>"
    And User enter password as "<password>"
    And User select the birth date of user
    And User select the gender of user
    Then User closes the Facebook

    Examples:
      | firstname | surname | email         | password |
      | abc       | xyz     | abc@gmail.com | abc@123  |
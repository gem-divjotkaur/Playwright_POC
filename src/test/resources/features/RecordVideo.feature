@Record
Feature: Record Video

  Scenario Outline: User record video using Playwright tool
    Given User open Facebook
    When User enters Firstname as "<firstname>"
    And User enters Surname as "<surname>"
    And User enters "<email>"
    And User enters the "<password>"
    And User selects the birth date
    And User selects the gender
    Then User signup and close the browser

    Examples:
      | firstname | surname | email         | password |
      | abc       | xyz     | abc@gmail.com | abc@123  |

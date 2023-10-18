@Upload
Feature: Upload multiple files

  Scenario: Upload file using Playwright Java
    Given User opens the upload file Url
    When User performs action for uploading files
    Then User closes the upload url
@APIpetstore
Feature: User should be able to request for user information

  Scenario: User Post Request
    Given The user creates a user information that want to register
    Then The User register a new user
    And The User verify the actual and expected result for user

  Scenario: User Get Request
    Given The User define get request for for User section with expected data
    Then The User records the data with get request for user
    And The User compare to expected and actual data for user

  Scenario: User Delete Request
    Given The User define delete request for user section with expected data
    Then The User delete the expected data for user
    And The User verify the response for user

  Scenario: User Delete Request negative
    Given The User define an expected data for negative delete request for user
    Then The User delete data for negative request for user
    And The User verify the negative response for user
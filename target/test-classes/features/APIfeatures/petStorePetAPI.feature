@APIpetstore
Feature: User should be able to request for pet information

  Scenario: Pet Post Request
    Given The user creates a pet information that want to register
    Then The User register a new pet
    And The User verify the actual and expected result for pet

  Scenario: Pet Get Request
    Given The User define get request for a pet with expected data
    Then The User records the data with get request for pet
    And The User compare to expected and actual data for pet

  Scenario: Pet Delete Request
    Given The User define delete request for a pet with expected data
    Then The User delete the expected data for pet
    And The User verify the response for pet

  Scenario: Pet Delete Request negative
    Given The User define an expected data for negative delete request for pet
    Then The User delete data for negative request for pet
    And The User verify the negative response for pet
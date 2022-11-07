@APIpetstore
Feature: User should be able to order request

  Scenario: Order Post Request
    Given The user creates a store information that want to register
    Then The User register a new store
    And The User verify the actual and expected result for store

  Scenario: Order Get Request
    Given The User define get request for store section with expected data
    Then The User records the data with get request for store
    And The User compare to expected and actual data for store

  Scenario: Order Delete Request
    Given The User define delete request for store section with expected data
    Then The User delete the expected data for store
    And The User verify the response for store

  Scenario: Order Delete Request negative
    Given The User define an expected data for negative delete request for store
    Then The User delete data for negative request for store
    And The User verify the negative response for store
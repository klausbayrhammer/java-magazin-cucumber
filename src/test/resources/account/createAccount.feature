Feature: Create an cccount

  Scenario: Create an empty account
    Given I have no bank account
    When I create a new account
    Then the account balance should be 0
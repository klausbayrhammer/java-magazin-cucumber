Feature: Withdraw money from an existing account

  Background:
    Given there exists a bank account

  Scenario: Withdraw an amount
    Given my accounts balance is 100 euros
    When I withdraw 50 euros
    Then the account balance should be 50 euros

  Scenario: Exceed account limit
    Given my bank account is empty
    And my account limit is -100 euro
    When I withdraw 110 euros
    Then the error "Account limit exceeded" should be shown
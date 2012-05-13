Feature: Deposit money on an existing account

  Background:
    Given there exists a bank account

  Scenario: Deposit an amount
    Given my bank account is empty
    When I deposit 100 euros
    Then the account balance should be 100 euros

  Scenario: Deposit zero euros
    Given my bank account is empty
    When I deposit 0 euros
    Then the error "Deposit at least 1 euro" should be shown
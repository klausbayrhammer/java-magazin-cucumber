Feature: Account

  Scenario: Create an empty account
  Given I have no bank account
  When I create a new account
  Then the account balance should be 0

  Scenario: Deposit an amount
  Given my bank account is empty
  When I deposit 100 euros
  Then the account balance should be 100 euros

 Scenario: Withdraw an amount
 Given my accounts balance is 100 euros
 When I withdraw 50 euros
 Then the account balance should be 50 euros

 Scenario: Exceed account limit
 Given my bank account is empty
 And my account limit is -100 euro
 When I withdraw 110 euros
 Then the error "Account limit exceeded" should be shown
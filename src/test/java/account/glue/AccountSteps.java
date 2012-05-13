package account.glue;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import account.Account;
import account.AccountFactory;
import cucumber.annotation.Before;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.runtime.java.StepDefAnnotation;

/**
 * @author Klaus Bayrhammer
 */
@StepDefAnnotation
public class AccountSteps
{
    private Account account;

    @Before
    public void init()
    {
        account = null;
    }

    @Given("^I have no bank account$")
    public void iHaveNoBankAccount()
    {
        account = null;
    }

    @When("^I create a new account$")
    @Given("^there exists a bank account$")
    public void iCreateANewAccount()
    {
        account = AccountFactory.createAccount();
    }

    @Then("^the account balance should be (\\d+)$")
    public void theAccountBalanceShouldBe(int euros)
    {
        BigDecimal balance = account.getBalance();
        BigDecimal expected = BigDecimal.valueOf(euros);
        assertEquals(expected, balance);
    }

    @Given("^my bank account is empty$")
    public void myBankAccountIsEmpty()
    {
        account.setBalance(BigDecimal.ZERO);
    }

    @When("^I deposit (\\d+) euros$")
    public void iDepositEuros(int euros)
    {
        BigDecimal value = BigDecimal.valueOf(euros);
        account.deposit(value);
    }

    @Then("^the account balance should be (\\d+) euros$")
    public void theAccountBalanceShouldBeEuros(int euros)
    {
        BigDecimal expected = BigDecimal.valueOf(euros);
        BigDecimal balance = account.getBalance();
        assertEquals(balance, expected);
    }

    @Given("^my account limit is -(\\d+) euro$")
    public void myAccountLimitIsEuros(int limit)
    {
        account.setLimit(limit);
    }

    @Then("^the error \"([^\"]*)\" should be shown$")
    public void theErrorShouldBeShown(String errorMessage)
    {
        String error = account.getError();
        assertEquals(error, errorMessage);
    }

    @When("^I withdraw (\\d+) euros$")
    public void iWithdrawEuros(int euros)
    {
        BigDecimal value = BigDecimal.valueOf(euros);
        account.withdraw(value);
    }

    @Given("^my accounts balance is (\\d+) euros$")
    public void myAccountsBalanceIsEuros(int euros)
    {
        account.setBalance(BigDecimal.valueOf(euros));
    }
}

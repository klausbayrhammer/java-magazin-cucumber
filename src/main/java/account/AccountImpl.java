package account;

import java.math.BigDecimal;

/**
 * @author Klaus Bayrhammer
 */
public class AccountImpl implements Account
{

    private BigDecimal balance = BigDecimal.ZERO;
    private int limit;
    private String error;

    public void deposit(BigDecimal amount)
    {
        if (amount.compareTo(BigDecimal.ZERO) <= 0)
        {
            error = "Deposit at least 1 euro";
        } else
        {
            balance = balance.add(amount);
        }
    }

    public void setLimit(int limit)
    {
        this.limit = limit;
    }

    public void withdraw(BigDecimal amount)
    {
        BigDecimal balanceAfterWithdraw = balance.subtract(amount);
        if (balanceAfterWithdraw.compareTo(BigDecimal.valueOf(limit)) < 0)
        {
            error = "Account limit exceeded";
        }else
        {
            balance = balanceAfterWithdraw;
        }
    }

    public BigDecimal getBalance()
    {
        return balance;
    }

    public void setBalance(BigDecimal balance)
    {
        this.balance = balance;
    }

    public String getError()
    {
        return error;
    }
}

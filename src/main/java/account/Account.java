package account;

import java.math.BigDecimal;

/**
 * @author Klaus Bayrhammer
 */
public interface Account
{
    BigDecimal getBalance();

    void deposit(BigDecimal euros);

    void setLimit(int limit);

    void withdraw(BigDecimal value);

    void setBalance(BigDecimal bigDecimal);

    String getError();
}

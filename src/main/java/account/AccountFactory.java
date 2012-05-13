package account;

/**
 * @author Klaus Bayrhammer
 */
public class AccountFactory
{
    public static Account createAccount()
    {
        return new AccountImpl();
    }
}

package account;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**
 * @author Klaus Bayrhammer
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = "account.glue", features = "classpath:account/")
public class AccountIntegrationTest
{
}

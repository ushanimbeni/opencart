package TestCases;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccount;
import TestBase.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

public class TC002_Login extends BaseClass {

    @Test(groups={"regression","master"})
        public void Verify_Login()
        {
            logger.info("-----------Starting TC002_Login --------------");

            try {
                HomePage hp = new HomePage(driver);
                hp.ClickMyAccount();
                hp.ClickLogin();

                LoginPage login = new LoginPage(driver);
                login.setLoginEmail(properties.getProperty("email"));
                login.setuserPassword(properties.getProperty("password"));
                login.clickOnLogin();

                MyAccount myAcc = new MyAccount(driver);
                boolean targetPage = myAcc.isMyAccountDisplayed();
                Assert.assertTrue(targetPage);

            }
            catch (Exception e)
            {
                logger.error("Test failed");
                Assert.fail();
                logger.info(e.getMessage());
            }

            logger.info("-----------Finished TC002_Login --------------");

        }

}

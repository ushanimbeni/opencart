package TestCases;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccount;
import TestBase.BaseClass;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Utilities.DataProviders;

/*
Valid data
    Login success -> passed
    Login fails - > fails

Invalid data
    Login success -> fails
    Login fails - > passed
*/
public class TC003_LoginDDT extends BaseClass {

    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class ,groups = "DataDriver")
    public  void verifyLoginData(String email,String pwd,String res)
    {
        logger.info("---------Starting TC003_LoginDDT ------------");
        HomePage hp = new HomePage(driver);

        hp.ClickMyAccount();
        logger.info("---------Clicking on My Login  ------------");

        hp.ClickLogin();

        logger.info("---------Logging ------------");

        LoginPage login = new LoginPage(driver);
        login.setLoginEmail(email);
        login.setuserPassword(pwd);
        login.clickOnLogin();

        MyAccount myAcc = new MyAccount(driver);
        boolean targetPage = myAcc.isMyAccountDisplayed();

        if(res.equalsIgnoreCase("valid"))
        {
            if(targetPage==true)
            {
                Assert.assertTrue(true);
                myAcc.clickOnLogout();
            }else {
                logger.info("---------valid login failed  ------------");
                Assert.assertTrue(false, "Test failed");

            }
        }

        if(res.equalsIgnoreCase("invalid"))
        {
            if(targetPage==true)
            {
                myAcc.clickOnLogout();
                logger.info("---------Invalid login successful  ------------");
                Assert.assertTrue(false);
            }else
            {
                Assert.assertTrue(true);
            }
        }

        logger.info("---------Finished TC003_LoginDDT ------------");

    }
}

package TestCases;

import PageObjects.AccountRegistration;
import PageObjects.HomePage;
import TestBase.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC001_RegisterAccount extends BaseClass {

    @Test(groups= {"regression","master"})
    public void verifyAccountRegistration()
    {
        try {
                logger.info("-----------Starting TC01_CreateAccount execution ");
                HomePage hp = new HomePage(driver);
                logger.info("-----------Clicking on MyAccount------- ");
                hp.ClickMyAccount();
                logger.info("-----------Clicking on Register------- ");
                hp.ClickRegister();

                AccountRegistration regPage = new AccountRegistration(driver);
                regPage.setFirstName(randomString());
                regPage.setLastName(randomString());
                regPage.setEmail(randomEmail());
                regPage.setTelePhone(randomNumbers());
                regPage.setPassword(randompPwd());
                regPage.clickCheckbox();
                regPage.clickOnSubmit();
                String confirmMessage = regPage.getSuccessMessage();

                logger.info("-----------Validating confirmation message------- ");
                Assert.assertEquals(confirmMessage, "Your Account Has Been Created!");
                logger.info(confirmMessage);
                logger.info("-----------Testcase passed------- ");
        }catch (Exception e)
        {
            logger.error("Testcase failed");
            logger.debug("Debug logs");
            Assert.fail();
        }
        finally {
            logger.info("-------------Finished TC01_CreateAccount execution-------");
        }

    }

}

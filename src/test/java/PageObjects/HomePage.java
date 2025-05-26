package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public  HomePage(WebDriver driver)
    {
        super(driver);
    }
    //locators
    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement lnkMyAccount;

    @FindBy(xpath = "(//a[normalize-space()='Register'])[1]")
    WebElement lnkRegister;

    @FindBy(xpath = "(//a[normalize-space()='Login'])[1]")
    WebElement lnkLogin;

    public void ClickMyAccount()
    {
        lnkMyAccount.click();
    }
    public void ClickRegister()
    {
        lnkRegister.click();
    }

    public void ClickLogin()
    {
        lnkLogin.click();
    }

}

package PageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount extends BasePage {

    public MyAccount(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//h2[normalize-space()='My Account']")
    WebElement lblMyAccount;

    @FindBy(xpath = "//div[@class='list-group']//a[text()='Logout']")
    WebElement lnkLogout;

    public  boolean isMyAccountDisplayed()
    {
        try{
            return lblMyAccount.isDisplayed();
        }catch (Exception e)
        {
            return false;
        }
    }

    public void clickOnLogout()
    {
        lnkLogout.click();
    }
}

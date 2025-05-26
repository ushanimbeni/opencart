package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='input-email']")
    WebElement txtEmail;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement txtPassword;

    @FindBy(xpath = "//input[@value='Login']")
    WebElement btnLogin;

    public void setLoginEmail(String email)
    {
        txtEmail.sendKeys(email);
    }

    public void setuserPassword(String pwd)
    {
        txtPassword.sendKeys(pwd);
    }

    public  void clickOnLogin()
    {
        btnLogin.click();
    }

}

package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistration extends BasePage {

public AccountRegistration(WebDriver driver){
    super(driver);
}

//locators
    @FindBy(xpath = "//input[@id='input-firstname']")
    WebElement txtFristName;

    @FindBy(xpath = "//input[@id='input-lastname']")
    WebElement txtLastName;

    @FindBy(xpath = "//input[@id='input-email']")
    WebElement txtEmail;

    @FindBy(xpath = "//input[@id='input-telephone']")
    WebElement txtTelephone;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement txtPwd;

    @FindBy(xpath = "//input[@id='input-confirm']")
    WebElement txtConfirmPwd;

    @FindBy(xpath = "//input[@name='agree']")
    WebElement chkAgree;

    @FindBy(xpath = "//input[@value='Continue']")
    WebElement btnSubmit;

    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement txtMessage;

    public void setFirstName(String fName)
    {
        txtFristName.sendKeys(fName);
    }

    public void setLastName(String lName)
    {
        txtLastName.sendKeys(lName);
    }

    public void setEmail(String email)
    {
        txtEmail.sendKeys(email);
    }

    public void setTelePhone(String tNumber)
    {
        txtTelephone.sendKeys(tNumber);
    }
    public void setPassword(String pwd)
    {
        txtPwd.sendKeys(pwd);
        txtConfirmPwd.sendKeys(pwd);
    }

    public void clickOnSubmit()
    {
        btnSubmit.click();
    }

    public void clickCheckbox()
    {
        chkAgree.click();
    }

    public  String getSuccessMessage()
    {
        try{
            return (txtMessage.getText());
        }catch (Exception e)
        {
            return e.getMessage();
        }
    }

}

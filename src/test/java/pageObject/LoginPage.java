

package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{

    public WebDriver ldriver;

    public LoginPage(WebDriver rdriver)
    {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//input[@id='Email']")
    WebElement txtEmail;

    @CacheLookup
    @FindBy(xpath = "//input[@id='Password']")
    WebElement txtPassword;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Log in']")
    WebElement btnLogin;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Logout']")
    WebElement lnkLogout;


    public void setUserName(String uname)
    {
        txtEmail.clear();
        txtEmail.sendKeys(uname);
    }

    public void setPassword(String pwd)
    {
        txtPassword.clear();
        txtPassword.sendKeys(pwd);
    }

    public void clickLogin()
    {
        btnLogin.click();
    }

    public void clockLogout()
    {
        lnkLogout.click();
    }
}

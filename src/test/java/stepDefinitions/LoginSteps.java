
package stepDefinitions;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.LoginPage;

public class LoginSteps
{

    private Object WebDriverManager;
    public WebDriver driver;
    public LoginPage lp;

    @Given ("User Launch Chrome Browser")
    public void user_Launch_Chrome_Browser(){
        io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        lp = new LoginPage(driver);
    }

    @When ("User open URL {string}")
    public void User_open_URL(String url)
    {
        driver.get(url);
        driver.manage().window().maximize();
    }

    @When ("User entre email as {string} and password as {string}")
    public void User_entre_email_as_and_password_as (String email, String password)
    {
        lp.setUserName(email);
        lp.setPassword(password);
    }

    @When("Click on Login")
    public void clicl_on_login() throws InterruptedException {
        lp.clickLogin();
        Thread.sleep(3000);
    }

    @Then("Page title should be {string}")
            public void page_title_should_be(String title) throws InterruptedException {
        if(driver.getPageSource().contains("Login was unsuccessful"))
        {
            driver.close();
            Assert.assertTrue(false);
        }else {
            Assert.assertEquals(title, driver.getTitle());
        }
        Thread.sleep(3000);
    }

    @When("User click on log out link")
    public void user_click_on_log_out_link() throws InterruptedException {
        lp.clockLogout();
        Thread.sleep(3000);
    }

    @Then("close browser")
    public void close_browser()
    {
        driver.quit();
    }

}
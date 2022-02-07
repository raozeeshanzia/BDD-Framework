package pages;


import Util.Wait;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webLocators.LoginPageElement;


public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By usernameField = By.xpath(LoginPageElement.username);
    private By passwordField = By.xpath(LoginPageElement.password);
    private By signInBtn = By.xpath(LoginPageElement.signInBtn);


    public void enterUsername(String username){
        Wait.waitForElementVisible(usernameField);
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password){
        Wait.waitForElementVisible(passwordField);
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickOnLoginButton(){
        Wait.waitForElementVisible(signInBtn);
        driver.findElement(signInBtn).click();

    }

    public void verifyUserIsOnLoginPage(){
        Wait.waitFor10Second();
        Assert.assertTrue(driver.getPageSource().contains("Sign In"));
    }

    public void verifyUserSuccessfullyLogin(){
        Wait.waitFor10Second();
        Assert.assertTrue(driver.getPageSource().contains("SQ Officer Location"));
    }


}

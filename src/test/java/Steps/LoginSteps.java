package Steps;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.DashboardPage;
import pages.LoginPage;
import webLocators.DashboardPageElement;

public class LoginSteps {

    private final LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private final DashboardPage dashboardPage = new DashboardPage(DriverFactory.getDriver());

    @Given("user is vms login page")
    public void user_opn_browser_and_go_vms_url() {
        loginPage.verifyUserIsOnLoginPage();
    }

    @Then("click on sign in button")
    public void click_on_sign_in_button() {
       loginPage.clickOnLoginButton();
    }

    @Then("verify user is successfully login")
    public void verify_user_is_successfully_login() {
        loginPage.verifyUserSuccessfullyLogin();
    }

    @Then("user enter username {string}")
    public void userEnterUsername(String username) {
        loginPage.enterUsername(username);
    }

    @Then("user enter password {string}")
    public void userEnterPassword(String password) {
        loginPage.enterPassword(password);
    }

    @Then("user click on logout btn")
    public void userClickOnLogoutBtn() {
        dashboardPage.clickOnLogoutBtn();
    }
}

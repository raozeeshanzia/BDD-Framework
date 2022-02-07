package Steps;

import factory.DriverFactory;
import io.cucumber.java.en.Then;
import pages.DashboardPage;
import pages.SQAUserManagementPage;

public class SQAUserManagmentSteps {
    private final SQAUserManagementPage SQAUser = new SQAUserManagementPage(DriverFactory.getDriver());
    private final DashboardPage dashboardPage = new DashboardPage(DriverFactory.getDriver());
    private int index;

    @Then("User click on SQA User Management link")
    public void userClickOnSQAUserManagementLink() {
        dashboardPage.clickOnSQAUserManagement();

    }

    @Then("user click on edit button")
    public void clickOnEditButton() throws InterruptedException {
        index = SQAUser.findUserAtIndex("intern.sara");
        System.out.println("find element at index:: "+index);
        SQAUser.clickOnEditBtn(index+1);
    }


    @Then("user select user status {string}")
    public void userSelectUserStatus(String status) {
        SQAUser.UserSelectStatus(status);

    }

    @Then("verify status is successfully update to {string}")
    public void verifyStatusIsSuccessfullyUpdateTo(String status) {
        SQAUser.verifyStatusUpadte(status,index+2);
    }

    @Then("click on update button")
    public void clickOnUpdateButton() {
        SQAUser.clickOnUpdateBtn();
    }


}

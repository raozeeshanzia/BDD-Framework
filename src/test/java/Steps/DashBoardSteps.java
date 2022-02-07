package Steps;

import factory.DriverFactory;
import io.cucumber.java.en.Then;
import pages.DashboardPage;

public class DashBoardSteps {
    private final DashboardPage dashboardPage = new DashboardPage(DriverFactory.getDriver());



    @Then("user click on journey report link")
    public void userClickOnJourneyReportLink() {
        dashboardPage.clickOnJourneySummaryReport();

    }

}

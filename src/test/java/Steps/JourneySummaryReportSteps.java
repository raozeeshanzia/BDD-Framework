package Steps;

import factory.DriverFactory;
import io.cucumber.java.en.Then;
import pages.SQAOfficerJourneyPage;

import java.io.IOException;

public class JourneySummaryReportSteps {
    private SQAOfficerJourneyPage journeySummaryReport = new
            SQAOfficerJourneyPage(DriverFactory.getDriver());

    @Then("select SQA officer name {string}")
    public void selectSQAOfficerName(String SQAOfficerName) {
        journeySummaryReport.selectSQAOfficer(SQAOfficerName);
    }

    @Then("enter start start date {string}")
    public void enterStartStartDate(String strDate) {
        journeySummaryReport.enterStartDate(strDate);


    }

    @Then("enter end date {string}")
    public void enterEndDate(String endDate) throws InterruptedException {
        journeySummaryReport.enterEndDate(endDate);
    }

    @Then("click on view in grid button")
    public void clickOnViewInGridButton() {
        journeySummaryReport.clickOnViewInGridBtn();
    }


    @Then("verify user {string} is display in a grid view")
    public void verifyUserIsDisplayInAGridView(String nameOfUser) {
        journeySummaryReport.verifyUserDisplayInGrid(nameOfUser);
    }

    @Then("verify file is successfully download on system")
    public void verifyFileIsSuccessfullyDownloadOnSystem() {
        
    }

    @Then("verify {string} file is successfully download on system")
    public void verifyFileIsSuccessfullyDownloadOnSystem(String fileName) throws IOException, InterruptedException {
        journeySummaryReport.verifyFileIsDownloaded(fileName);
    }

    @Then("click on download excel button")
    public void clickOnDownloadExcelButton() throws InterruptedException {
        journeySummaryReport.clickOnDownloadExcelBtn();
    }
}

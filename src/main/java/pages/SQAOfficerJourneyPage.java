package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import webLocators.SQAOfficerJourneyElement;

import java.io.File;
import java.io.IOException;

public class SQAOfficerJourneyPage {
    private WebDriver driver;
    public String downloadPath = "C:\\Users\\Zeeshan Ahmad\\Desktop\\Report";

    public SQAOfficerJourneyPage(WebDriver driver) {
        this.driver = driver;
    }

    private By selectSQAOfficer = By.xpath(SQAOfficerJourneyElement.SQAOfficer);
    private By startDateField = By.xpath(SQAOfficerJourneyElement.startDate);
    private By endDateField = By.xpath(SQAOfficerJourneyElement.endDate);
    private By viewInGridBtn = By.xpath(SQAOfficerJourneyElement.veiwInGridBtn);
    private By downloadExcelBtn = By.xpath(SQAOfficerJourneyElement.downloadExcelBtn);
    private By firstRowData = By.xpath(SQAOfficerJourneyElement.requiredUserOnTable);

    public void selectSQAOfficer(String nameOfOfficer){
        Select Officer = new Select(driver.findElement(selectSQAOfficer));
        Officer.selectByValue(nameOfOfficer);
    }

    public void enterStartDate(String startDate){
        driver.findElement(startDateField).sendKeys(startDate);
    }

    public void enterEndDate(String endDate) throws InterruptedException {
        driver.findElement(endDateField).sendKeys(endDate);
        Thread.sleep(5000);
    }

    public void clickOnViewInGridBtn(){
        driver.findElement(viewInGridBtn).click();
    }

    public void clickOnDownloadExcelBtn() throws InterruptedException {
        driver.findElement(downloadExcelBtn).click();
        Thread.sleep(10000);
    }

    public void verifyUserDisplayInGrid(String SQAUser){
        Assert.assertTrue(driver.findElement(firstRowData).getText().contains(SQAUser));
    }



    public void verifyFileIsDownloaded(String fileName) throws IOException, InterruptedException {
        Thread.sleep(10000);
        Assert.assertTrue(isFileDownloaded(downloadPath,fileName));
    }

    public boolean isFileDownloaded(String downloadPath, String fileName) {
        File dir = new File(downloadPath);
        File[] dirContents = dir.listFiles();

        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].getName().contains(fileName)) {
                // File has been found, it can now be deleted:
                dirContents[i].deleteOnExit();
                return true;
            }
        }
        return false;
    }
}

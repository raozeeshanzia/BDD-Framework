package pages;

import Util.Wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import webLocators.DashboardPageElement;

public class DashboardPage {
    private WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    //web Elements
    private By SQAUserManagement = By.xpath(DashboardPageElement.SQAUserManagementLink);
    private By SQOfficerLocationLink = By.xpath(DashboardPageElement.SQOfficerLocationLink);
    private By SQOfficerJourneyLink = By.xpath(DashboardPageElement.SQOfficerJourneyLink);
    private By journeySummaryReportLink = By.xpath(DashboardPageElement.journeySummaryReportLink);
    private By journeyDetailReportLink = By.xpath(DashboardPageElement.journeyDetailReportLink);
    private By logoutBtn = By.xpath(DashboardPageElement.LogoutBtn);

    //Add new User page elements
    private By addNewUserBtn = By.xpath(DashboardPageElement.addNewUserBtn);
    private By userIDField = By.xpath(DashboardPageElement.userIDField);
    private By nameField = By.xpath(DashboardPageElement.nameField);
    private By selectRoleElement = By.xpath(DashboardPageElement.selectRole);
    private By selectReportingManager = By.xpath(DashboardPageElement.selectReportingManager);

    private By saveBtn = By.xpath(DashboardPageElement.saveBtn);
    private By cancelBtn = By.xpath(DashboardPageElement.cancelBtn);
    private By verifyUser = By.xpath(DashboardPageElement.verifyUser);


    // Class Methods
    public void clickOnSQAUserManagement(){
        Wait.waitForElementVisible(SQAUserManagement);
        driver.findElement(SQAUserManagement).click();
    }

    public void clickOnSQOfficerLocation(){
        Wait.waitForElementVisible(SQOfficerLocationLink);
        driver.findElement(SQOfficerLocationLink).click();
    }

    public void clickOnSQOfficerJourney(){
        Wait.waitForElementVisible(SQOfficerJourneyLink);
        driver.findElement(SQOfficerJourneyLink).click();
    }

    public void clickOnJourneySummaryReport(){
        Wait.waitForElementVisible(journeySummaryReportLink);
        driver.findElement(journeySummaryReportLink).click();
    }

    public void clickOnJourneyDetailReport(){
        Wait.waitForElementVisible(journeyDetailReportLink);
        driver.findElement(journeyDetailReportLink).click();
    }

    public void clickOnLogoutBtn(){
        Wait.waitForElementVisible(logoutBtn);
        driver.findElement(logoutBtn).click();
    }

    public void clickOnAddNewUser(){
        driver.findElement(addNewUserBtn);
    }

    public void enterUserID(String userID){
        driver.findElement(userIDField).sendKeys(userID);
    }

    public void enterNameOfUser(String name){
        driver.findElement(nameField).sendKeys(name);
    }

    public void userSelectRole(String role){
        Select roleOfUser = new Select(driver.findElement(selectRoleElement));
        roleOfUser.selectByValue(role);
    }

    public void UserSelectReportingManager(String reportingMan){
        Select userReportingManager = new Select(driver.findElement(selectReportingManager));
        userReportingManager.selectByValue(reportingMan);

    }



    public void clickOnSaveBtn(){
        driver.findElement(saveBtn).click();
    }

    public void clickOnCancelBtn(){
        driver.findElement(cancelBtn).click();
    }

    public void clickOnVerifyUserLink(){
        driver.findElement(verifyUser).click();
    }

}

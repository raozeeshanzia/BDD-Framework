package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import webLocators.DashboardPageElement;
import webLocators.SQAUserManagmentPageElement;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class SQAUserManagementPage {


    private WebDriver driver;

    public SQAUserManagementPage(WebDriver driver) {
        this.driver = driver;
    }

    private By selectStatus = By.xpath(DashboardPageElement.selectStatus);
    private By updateBtn = By.xpath(SQAUserManagmentPageElement.updateBtn);

    public int findUserAtIndex(String username){
        System.out.println("Enter in function");
        List<WebElement> listOfUser = listOfSQAUsers();
        System.out.println("Print the size of list"+listOfUser.size());
        for (int i = 0; i <= listOfUser.size(); i++) {
            System.out.println("Username:: "+listOfUser.get(i).getText());
            if (listOfUser.get(i).getText().contains(username)){
                return listOfUser.indexOf(listOfUser.get(i));
            }
        }
        return 0;
    }

    public void UserSelectStatus(String status){
        WebElement statusElement = driver.findElement(By.xpath("//label[contains(text(),'Status')]"));
        Select userStatus = new Select(driver.findElement(with(By.tagName("select")).near(statusElement)));
        userStatus.selectByVisibleText(status);
    }

    public void clickOnEditBtn(int indexOfEdit) throws InterruptedException {
        WebElement EditBtn = driver.findElement(By.xpath(String.format("(//a[contains(text(),'Edit')])[%s]",indexOfEdit)));
        EditBtn.click();
        Thread.sleep(5000);
    }

    public ArrayList<WebElement> TotalPageOfUser(){
        return (ArrayList<WebElement>) driver.findElements(By.xpath("//tr//tbody/tr/td/a"));
    }

    public ArrayList<WebElement> listOfSQAUsers(){
        return (ArrayList<WebElement>) driver.findElements(By.xpath("//tr//td[2]/span"));
    }

    public void verifyStatusUpadte(String status,int index){
        String currentStatus = driver.findElement(By.xpath(String.format("//tr[%s]/td[6]",index))).getText();
        System.out.println("Current status::"+currentStatus);
        Assert.assertTrue(currentStatus.contains(status));
    }

    public void clickOnUpdateBtn(){
        driver.findElement(updateBtn).click();
    }
}

package pages;

import Util.Wait;
import factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import webLocators.MainPageElement;

import java.util.List;

public class MainPage {

    private WebDriver _driver;

    public MainPage(WebDriver driver){
        this._driver = driver;
    }

    private final By _sliderBar = By.xpath(MainPageElement.toggleBtn);

    private final By _signBtn = By.xpath(MainPageElement.signbtn);

    private final By _listOfTopGames = By.xpath(MainPageElement.listofTopGames);

    public void clickOnSliderBar() {
        Wait.waitForElementVisible(_sliderBar);
        _driver.findElement(_sliderBar).click();
    }

    public boolean isSignBtnVisible(){
        Wait.waitForElementVisible(_signBtn);
        if(_driver.findElement(_signBtn).isDisplayed()){
            return true;
        }
        return false;
    }

    public String getTopGame(){
        List<WebElement> listOfTopGames = _driver.findElements(_listOfTopGames);
        return listOfTopGames.get(0).getText();
    }
}

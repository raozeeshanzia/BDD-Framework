package pages;

import Util.Wait;
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
    private final By _listOfTopGamesYear = By.xpath(MainPageElement.listofTopGamesYear);
    private final By _topGamesLanguageDependency = By.xpath(MainPageElement.topGamesLanguageDependency);
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

    public String[] getTopGame(){
        List<WebElement> listOfTopGames = _driver.findElements(_listOfTopGames);
        List<WebElement> listOfTopGamesYear = _driver.findElements(_listOfTopGamesYear);
        return new String[]{listOfTopGames.get(0).getText() , listOfTopGamesYear.get(0).getText()};
    }

    public void selectTopGame(String topGameName){

        String locator  = String.format(MainPageElement.topGame, topGameName);
        By _listOfTopGamesYear = By.xpath(locator);
        Wait.waitForElementVisible(_listOfTopGamesYear);
        _driver.findElement(_listOfTopGamesYear).click();//        return new String[]{listOfTopGames.get(0).getText() , listOfTopGamesYear.get(0).getText()};
    }

    public void verifyLanguageDependencyPoll(String expectedResult) {
        Wait.waitForElementVisible(_topGamesLanguageDependency);
        String actualResult = _driver.findElement(_topGamesLanguageDependency).getText();
        assert actualResult.equals(expectedResult);
    }
}

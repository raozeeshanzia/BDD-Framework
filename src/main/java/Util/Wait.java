package Util;

import factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Wait {


    public static void waitForElementVisible(By locator){
       WebDriverWait  wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
       wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));

    }

    public static void waitFor5Second(){
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    public static void waitFor10Second()  {

        DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }



}

package Steps;

import Util.ConfigReader;
import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class Hooks {
    private DriverFactory driverFactory;
    private WebDriver driver;
    private Properties properties;
    private ConfigReader configReader;

    @Before(order = 0)
    public void getProperty(){
        configReader = new ConfigReader();
        properties = configReader.setProperties();

        //Zeeshan is here
    }
    @Before(order = 1)
    public void launchBrowser(){
        driverFactory = new DriverFactory();
        driver = driverFactory.setDriver(properties.getProperty("browser"));
        driver.get("https://rp.zeuscloudconnect.com:8070/DigitalSQA/login.aspx");
    }

    @After(order = 0)
    public void closeBrowser(){
        driver.quit();
    }

    @After(order = 1)
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()){
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenshotName);
        }
    }

}

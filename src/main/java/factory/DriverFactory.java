package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;

public class DriverFactory {
    private WebDriver driver;
    public String downloadFilepath = "C:\\Users\\Zeeshan Ahmad\\Desktop\\Report";
    public String Test = "test Code test";


    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public WebDriver setDriver(String browserName){

        switch (browserName.toLowerCase()) {
            case "chrome" -> setChromeDriver();
            case "firefox" -> setFirefoxDriver();
            case "edge" -> setEdgeDriver();
            default -> System.out.println("Please pass correct web browser..Thank YOU!");
        }
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();

    }

    public void setChromeDriver(){
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadFilepath);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        WebDriverManager.chromedriver().setup();
        tlDriver.set(new ChromeDriver(options));
    }

    public void setFirefoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        tlDriver.set(new FirefoxDriver());
    }

    public void setEdgeDriver(){
        WebDriverManager.edgedriver().setup();
        tlDriver.set(new EdgeDriver());
    }

    public static synchronized WebDriver getDriver(){
        return tlDriver.get();
    }
}

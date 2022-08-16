package Steps;

import Util.ApiFunctionsLibrary;
import Util.JsonReader;
import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.xml.sax.SAXException;
import pages.MainPage;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;


public class MainPageSteps {

    private final MainPage _mainPage = new MainPage(DriverFactory.getDriver());
    @Given("User is on main page")
    public void userIsOnMainPage() {
        Assert.assertTrue(_mainPage.isSignBtnVisible());
    }

    @Then("click on slide Bar button")
    public void clickOnSlideBarButton() {
        _mainPage.clickOnSliderBar();
    }


    @And("hit the api store result")
    public void hitTheApiStoreResult() throws IOException, InterruptedException, ParserConfigurationException, SAXException {
        System.out.println(ApiFunctionsLibrary.convertStringToJson("https://boardgamegeek.com/xmlapi/search?search=Ark%20Nova"));
        var result = ApiFunctionsLibrary.convertStringToJson("https://boardgamegeek.com/xmlapi/search?search=Ark%20Nova");
        System.out.println("value of attribute"+JsonReader.getValueOfKey(result));
        System.out.println("XML Doc"+ApiFunctionsLibrary.convertStringToXml());
        ApiFunctionsLibrary.readXML(ApiFunctionsLibrary.convertStringToXml());
    }
}

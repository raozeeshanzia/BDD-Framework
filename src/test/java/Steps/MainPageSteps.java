package Steps;

import Util.ApiFunctionsLibrary;
import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.xml.sax.SAXException;
import pages.MainPage;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Map;
public class MainPageSteps {
    String searchName ;
    String searchYear ;
    String valueOfMaxEntity;
    String getParentObjectAPi = "https://boardgamegeek.com/xmlapi/search?search=";
    String resultApi = "https://boardgamegeek.com/xmlapi/boardgame/";

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
    public void hitTheApiStoreResult() throws IOException, InterruptedException{
        try {
            String objectId = ApiFunctionsLibrary.getParentObjectId(ApiFunctionsLibrary.convertStringToXml(this.getParentObjectAPi.concat(this.searchName)), this.searchName, this.searchYear);
            Map<String, String> getLanguageDependencePoll = ApiFunctionsLibrary.getMaximumCount(ApiFunctionsLibrary.pollElement(ApiFunctionsLibrary.convertStringToXml(this.resultApi.concat(objectId))));
            Map.Entry<String, String> highestValue = ApiFunctionsLibrary.getMaxEntryInMapBasedOnValue(getLanguageDependencePoll);
            valueOfMaxEntity = highestValue.getKey();
            System.out.println(" get most voted option in Language Dependence poll:: " + valueOfMaxEntity);
        }
        catch (Exception  e){
            valueOfMaxEntity = "(no votes)";
        }

    }

    @Then("get the most top game with increasing rank in hotest tab")
    public void getTheMostTopGameWithIncreasingRankInHotestTab() throws ParserConfigurationException, IOException, InterruptedException, SAXException {
         String[] values = _mainPage.getTopGame();
         this.searchName = values[0];
         this.searchYear = values[1].split("\n")[1];

    }

    @Then("click on most top game with increasing rank in hotest tab")
    public void clickOnMostTopGameWithIncreasingRankInHotestTab() {

        _mainPage.selectTopGame(this.searchName);
    }

    @Then("verify the api language dependency poll from web")
    public void verifyTheApiLanguageDependencyPollFromWeb() {
        _mainPage.verifyLanguageDependencyPoll(this.valueOfMaxEntity);
    }
}

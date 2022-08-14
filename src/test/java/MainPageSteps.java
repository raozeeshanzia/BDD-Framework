import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.MainPage;

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
    public void hitTheApiStoreResult() {


    }
}

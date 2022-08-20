package webLocators;

public class MainPageElement {
    public static final String toggleBtn = "//button/span[text()='Toggle Sidebar']//ancestor::button";
    public static final String signbtn = "//a[text()='Sign In']";

    public static final String listofTopGames = "//fa-icon[contains(@class,'tw-text-green')]//ancestor::li//div[@class='tw-flex-1 tw-overflow-hidden']/div[contains(@class,'tw-leading')]";
    public static final String listofTopGamesYear = "//fa-icon[contains(@class,'tw-text-green')]//ancestor::li//div[@class='tw-flex-1 tw-overflow-hidden']/div[contains(@class,'text-muted')]";
    public static String topGame = "(//div[contains(text(),'%s')])[1]";
    public static final String topGamesLanguageDependency = "//div[contains(text(),'Language Dependence')]//..//span[contains(@ng-bind-html,'polls')]";


}

package stepdefinitions;

import com.microsoft.playwright.Locator;
import implementations.Locators;
import io.cucumber.java.en.*;

public class PlaywrightLocators {
    @Given("User launches the site for locators")
    public void launch(){
        Locators.launchBrowser();
    }
    @When("User performs action")
    public void action(){
        Locators.performActions();
    }
    @Then("User closes the site for locators")
    public void closeSite(){
        Locators.tearDown();
    }
}

package stepdefinitions;

import implementations.Screenshots;
import io.cucumber.java.en.*;

public class PlaywrightScreenshot {
    @Given("User opens the site for Screenshots")
    public void openBrowser(){
        Screenshots.launchBrowser();
    }
    @When("User performs actions for screenshot functionality")
    public void actions(){
        Screenshots.performActions();
    }
    @Then("User closes the site which is open for Screenshots")
    public void closeBrowser(){
        Screenshots.tearDown();
    }
}

package stepdefinitions;

import implementations.MaskScreenshot;
import io.cucumber.java.en.*;

public class PlaywrightMasScreenshots {
    @Given("User opens the site for Mask Screenshots")
    public void openBrowser(){
        MaskScreenshot.launchBrowser();
    }
    @When("User performs actions for Mask screenshot functionality")
    public void actions(){
        MaskScreenshot.performActions();
    }
    @Then("User closes the site which is open for Mask Screenshots")
    public void closeBrowser(){
        MaskScreenshot.tearDown();
    }
}

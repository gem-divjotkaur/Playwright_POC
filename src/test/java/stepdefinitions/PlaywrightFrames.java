package stepdefinitions;

import implementations.HandleFrame;
import io.cucumber.java.en.*;

public class PlaywrightFrames {
    @Given("^User navigates to the Frame Url$")
    public  void launchUrl(){
        HandleFrame.launchBrowser();
    }
    @When("User performs actions with the frame")
    public void performAction(){
        HandleFrame.task();
    }
    @Then("User closes the Frame Url")
    public void closeBrowser(){
        HandleFrame.tearDown();
    }
}

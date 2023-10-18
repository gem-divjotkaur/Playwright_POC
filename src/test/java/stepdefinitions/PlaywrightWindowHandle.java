package stepdefinitions;

import implementations.WindowHandle;
import io.cucumber.java.en.*;
import locators.WindowHandleLocators;

public class PlaywrightWindowHandle {
    @Given("User opens the site for Window Handling")
    public void openUrl(){
        WindowHandle.launchBrowser();
    }
    @When("User performs actions for Window Handling functionality")
    public void actions(){
        WindowHandle.performActions();
    }
    @Then("User closes the site which is open for Window Handling")
    public void closeUrl(){
        WindowHandle.tearDown();
    }
}

package stepdefinitions;

import com.microsoft.playwright.Browser;
import implementations.BrowserContexts;
import io.cucumber.java.en.*;

public class PlaywrightBrowserContext {

    @Given("User launch the browser")
    public void launchBrowser(){
        BrowserContexts.launch();
    }
    @When("User searches for {string} in Amazon")
    public void shoeFromAmazon(String shoes){
        BrowserContexts.visitAmazonPage(shoes);
    }
    @And("User searches for {string} in Myntra")
    public void shoeFromMyntra(String shoes){
        BrowserContexts.visitMyntraPage(shoes);
    }
    @Then("User closes the browser")
    public void vanish(){
        BrowserContexts.tearDown();
    }
}

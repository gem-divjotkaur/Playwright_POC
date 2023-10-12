package stepdefinitions;

import implementations.Authentication;
import io.cucumber.java.en.*;
import locators.AuthenticationLocators;

public class PlaywrightAuthentication {

    @Given("User launches site by providing {string} and {string}")
    public static void launchBrowser(String username, String password){
        Authentication.launch(username, password);
    }
    @When("^User gets the data from the Authentication page$")
    public static void getData(){
        Authentication.getText();
    }
    @Then("^User closes page$")
    public static void vanish(){
        Authentication.tearDown();
    }

}

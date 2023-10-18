package stepdefinitions;

import implementations.ScriptWithoutFinding;
import io.cucumber.java.en.*;

public class PlaywrightWithoutFindElement {

    @Given("User navigates to Book-cart website")
    public static void launch(){
        ScriptWithoutFinding.launchSite();
    }
    @When("User logins with username as {string} and password as {string}")
    public static void login(String username, String password){
        ScriptWithoutFinding.userLogin(username, password);
    }
    @And("User searches for a {string} in the search-box")
    public static void searchBook(String book){
        ScriptWithoutFinding.userSearchBook(book);
    }
    @And("User click on image")
    public static void clickImage(){
        ScriptWithoutFinding.userClickImage();
    }
    @Then("User closes Book-cart website")
    public static void vanish(){
        ScriptWithoutFinding.tearDown();
    }
}

package stepdefinitions;

import implementations.PlaywrightMethods;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class PlaywrightMethod {
    @Before("@Method")
    public void before(){
        PlaywrightMethods.launch();
    }
    @Given("User performs type method in Playwright")
    public void typeMethod(){
        PlaywrightMethods.performTypeMethod();
    }

    @And("^User performs fill method in Playwright$")
    public void fillMethod(){
        PlaywrightMethods.performFillMethod();
    }
    @And("^User performs press method in Playwright$")
    public void pressMethod(){
        PlaywrightMethods.performPressMethod();
    }
    @And("^User clears the text$")
    public void clearText(){
        PlaywrightMethods.userClearText();
    }
    @Then("^User check if text is disabled$")
    public void check(){
        PlaywrightMethods.userCheck();
    }
    @And("^User gets the text$")
    public void getText(){
        PlaywrightMethods.userGetText();
    }

    @After("@Method")
    public void after(){
        PlaywrightMethods.vanish();
    }
}

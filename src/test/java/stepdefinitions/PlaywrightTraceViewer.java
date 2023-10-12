package stepdefinitions;

import implementations.TraceViewer;
import io.cucumber.java.en.*;

public class PlaywrightTraceViewer {
    @Given("User open Facebook app")
    public void launchFacebook(){
        TraceViewer.launchFacebookSite();
    }
    @When("User enter the firstname {string}")
    public void userFirstName(String firstname){

        TraceViewer.enterFirstname(firstname);
    }
    @And("User enter the surname {string}")
    public void userSurName(String surname){
        TraceViewer.enterSurname(surname);
    }
    @And("User enter email as {string}")
    public void userEmail(String email){
        TraceViewer.enterEmail(email);
    }
    @And("User enter password as {string}")
    public void userPassword(String password){
        TraceViewer.enterPassword(password);
    }
    @And("User select the birth date of user")
    public void userBirthDate(){
        TraceViewer.enterBirthDate();
    }
    @And("User select the gender of user")
    public void userGender(){
        TraceViewer.enterGender();
    }
    @Then("User closes the Facebook")
    public void vanishBrowser(){
        TraceViewer.tearDownFacebook();
    }
}

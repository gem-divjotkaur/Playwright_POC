package stepdefinitions;

import implementations.RecordVideo;
import io.cucumber.java.en.*;

public class PlaywrightRecordVideo {
    @Given("User open Facebook")
    public void launchBrowser(){
        RecordVideo.launch();
    }
    @When("User enters Firstname as {string}")
    public void firstName(String firstname){
        RecordVideo.enterFirstname(firstname);
    }
    @And("User enters Surname as {string}")
    public void surName(String surname){
        RecordVideo.enterSurname(surname);
    }
    @And("User enters {string}")
    public void email(String email){
        RecordVideo.enterEmail(email);
    }
    @And("User enters the {string}")
    public void password(String password){
        RecordVideo.enterPassword(password);
    }
    @And("User selects the birth date")
    public void birthDate(){
        RecordVideo.enterBirthDate();
    }
    @And("User selects the gender")
    public void gender(){
        RecordVideo.enterGender();
    }
    @Then("User signup and close the browser")
    public void vanish(){
        RecordVideo.tearDown();
    }
}

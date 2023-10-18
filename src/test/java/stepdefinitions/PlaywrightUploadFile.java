package stepdefinitions;

import implementations.UploadFiles;
import io.cucumber.java.en.*;

public class PlaywrightUploadFile {
    @Given("User opens the upload file Url")
    public void launch(){
        UploadFiles.launchBrowser();
    }
    @When("User performs action for uploading files")
    public void actions(){
        UploadFiles.performActions();
    }
    @Then("User closes the upload url")
    public void closeBrowser(){
        UploadFiles.tearDown();
    }
}

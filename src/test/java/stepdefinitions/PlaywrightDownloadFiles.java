package stepdefinitions;

import implementations.DownloadFiles;
import io.cucumber.java.en.*;

public class PlaywrightDownloadFiles {
    @Given("User launches the site for Downloading Files")
    public void launch(){
        DownloadFiles.launchBrowser();
    }
    @When("User performs action for downloading and saving files")
    public void task(){
        DownloadFiles.downloadAction();
    }
    @Then("User closes the downloading site")
    public void closeSite(){
        DownloadFiles.tearDown();
    }
}

package stepdefinitions;

import implementations.Alerts;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class PlaywrightAlerts {
    @Before("@Alert")
    public void launch(){
        Alerts.launchBrowser();
    }
    @Given("^User handles Simple Alert$")
    public void simpleAlert(){
        Alerts.handleSimpleAlert();
    }
    @And("^User handles Confirmation Alert$")
    public void confirmAlert(){
        Alerts.handleConfirmAlert();
    }
    @And("^User handles Prompt Alert$")
    public void promptAlert(){
        Alerts.handlePromptAlert();
    }
    @And("^User handles Sweet Alert$")
    public void sweetAlert(){
        Alerts.handleSweetAlert();
    }
    @After("@Alert")
    public void vanish(){
        Alerts.tearDown();
    }
}

package stepdefinitions;

import implementations.LaunchBrowser;
import io.cucumber.java.en.*;

public class LaunchBrowsers {

    @Given("^User launch browser using Chromium$")
    public void launchChromium(){
        LaunchBrowser.userLaunchChromium();
    }
    @Given("^User launch browser using Firefox$")
    public void launchFirefox(){
        LaunchBrowser.userLaunchFirefox();
    }
    @Given("^User launch browser using Webkit$")
    public void launchWebkit(){
        LaunchBrowser.userLaunchWebkit();
    }
    @Given("^User launch browser using Chrome$")
    public void launchChrome(){
        LaunchBrowser.userLaunchChrome();
    }
    @Given("^User launch browser using ms-edge$")
    public void launchMsEdge(){
        LaunchBrowser.userLaunchMsEdge();
    }

}

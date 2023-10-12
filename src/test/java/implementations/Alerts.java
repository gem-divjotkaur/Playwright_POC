package implementations;

import com.microsoft.playwright.*;
import locators.AlertLocators;
import utils.ConfigReader;

/**
 * This class contains the knowledge of alerts in playwright
 * Alerts in playwright are of 4 types
 * simple alert =  simple, accept it
 * prompt alert = enter some data and then accept
 * confirmation alert = have an option, either accept or dismiss
 * sweet alert / modern alert = provides stylish and customizable pop-up dialog boxes
 *
 * we can handle the alert by many ways
 *  accept() = to accept the alert
 *  accept(string) = used in prompt alert
 *  dismiss() = to decline the alert
 *  defaultValue() = is a method that allows you to set the default input value for a prompt dialog.
 *  message() = is used to retrieve the message displayed in an alert or prompt dialog.
 *
 */
public class Alerts {

    public static Playwright playwright;
    public static Browser browser;
    public static BrowserContext context;
    public static Page page;


    public static void launchBrowser(){
        // launch browser in headless mode in chrome
        ConfigReader.getProperties();
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome")
        );
        context = browser.newContext();
        page = context.newPage();
        page.navigate(ConfigReader.AlertUrl);
    }
    public static void handleSimpleAlert(){
        // handle simple alert by just accepting it
        try{
            page.onceDialog(dialog -> {
                System.out.println(dialog.message());
                dialog.accept();
//                dialog.accept("ACCEPTED");
//                System.out.println(dialog.defaultValue());
            });
            Locator simpleAlert = AlertLocators.simpleAlert;
            simpleAlert.click();
            page.waitForTimeout(2000);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void handleConfirmAlert(){
        // handle confirmation alert
        try{
            page.onceDialog(dialog->{
                System.out.println(dialog.message());
                dialog.accept();
            });
            Locator confirmAlert = AlertLocators.confirmAlert;
            confirmAlert.click();
            page.waitForTimeout(2000);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void handlePromptAlert(){
        // handle prompt alert
        try{
            page.onceDialog(dialog->{
                System.out.println(dialog.message());
                dialog.accept("ACCEPTED");
                System.out.println(dialog.defaultValue());
            });
            Locator promptAlert = AlertLocators.promptAlert;
            promptAlert.click();
            Locator name = AlertLocators.myName;
            System.out.println(name.innerText());
            page.waitForTimeout(2000);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void handleSweetAlert(){
        // handle sweet alert
        try{
            Locator sweetAlert = AlertLocators.sweetAlert;
            sweetAlert.click();
            System.out.println(AlertLocators.text.innerText());
            AlertLocators.crossButton.click();
            page.waitForTimeout(2000);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void tearDown(){
        // close browser
        try{
            page.waitForTimeout(2000);
            page.close();
            context.close();
            playwright.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

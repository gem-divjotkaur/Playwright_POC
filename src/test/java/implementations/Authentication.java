package implementations;

import com.microsoft.playwright.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import locators.AuthenticationLocators;

import utils.ConfigReader;

/**
 * The purpose of this class is to show Http Authentication
 * it can be done using setHttpCredentials() method by passing it through BrowserContext instance
 */
public class Authentication {
    public static Playwright playwright;
    public static Browser browser;
    public static BrowserContext context;
    public static Page page;

    public static void launch(String username,String password){
        try{
            // launch chrome browser in head mode
            ConfigReader.getProperties();
            playwright = Playwright.create();
            browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false)
            );
            // make a browser context and pass the credentials through this
            context = browser.newContext(
                    new Browser.NewContextOptions().setHttpCredentials(username, password)
            );
            page = context.newPage();
            page.navigate(ConfigReader.AuthenticationUrl);
            page.waitForTimeout(2000);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void getText(){
        try{
            // get the data
            Locator text = AuthenticationLocators.text;
            System.out.println("Data present in site after providing auth : "+text.innerText());
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void tearDown(){
        try{
            // close the browser instance
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

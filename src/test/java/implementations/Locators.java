package implementations;

import com.microsoft.playwright.*;
import locators.Locatorss;
import stepdefinitions.PlaywrightLocators;
import utils.ConfigReader;

/**
 * locators in playwright
 * 1) Text-based locators =  visible text
 * 2) Has-text  = used in button mostly
 * 3) text()
 * 4) visible()
 * 5) nth
 * 6) this or that
 */
public class Locators {
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
        page.navigate(ConfigReader.locatorsUrl);
    }
    public static void performActions(){
        // playwright locators
        try{
            Locator button = Locatorss.button;
            button.click();
            Locator home = Locatorss.home;
            home.click();
            Locator product = Locatorss.product;
            product.click();
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

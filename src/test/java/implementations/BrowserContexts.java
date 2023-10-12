package implementations;

import com.microsoft.playwright.*;
import locators.AmazonLocators;
import locators.MyntraLocators;
import utils.ConfigReader;

/**
 * Browser context
 * By default , Playwright opens the browser in incognito mode which is a private mode. It doesn't
 * save the cache, cookies, user data. So we use Browser context that allows us to open multiple
 * independent browsers at the same time and it has it's own storage, settings, and it stores cookies,
 * caches and user-data.
 * Using Browser Context, we can open multiple browsers simultaneously.
 */

public class BrowserContexts {
    public static Playwright playwright;
    public static Browser browser;
    public static BrowserContext context1;
    public static BrowserContext context2;
    public static Page page1;
    public static Page page2;

    public static void launch(){
        try{
            // launch browser for both pages
            playwright = Playwright.create();
            browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false)
            );
             context1 = browser.newContext();
            page1 = context1.newPage();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void visitAmazonPage(String shoes){
        // get shoe name from first page
        try{
            ConfigReader.getProperties();
            page1.navigate(ConfigReader.AmazonUrl);
            page1.waitForTimeout(2000);
            Locator searchBox = AmazonLocators.searchBox;
            searchBox.type(shoes);
            page1.waitForTimeout(2000);
            Locator clickSearch = AmazonLocators.clickSearch;
            clickSearch.click();
            page1.waitForTimeout(2000);

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void visitMyntraPage(String shoes){
        //get shoe name from second page
        ConfigReader.getProperties();
        try{
            context2 = browser.newContext();
            page2 = context2.newPage();
            page2.navigate(ConfigReader.MyntraUrl);
            page2.waitForTimeout(2000);
            Locator searchBox2 = MyntraLocators.searchBox2;
            searchBox2.type(shoes);
            page2.waitForTimeout(2000);
            searchBox2.press("Enter");
            page2.waitForTimeout(2000);

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void tearDown(){
        try{
            // close both the pages, there browser context and playwright instance also
            page2.close();
            page1.bringToFront();
            page1.close();
            context1.close();
            context2.close();
            playwright.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

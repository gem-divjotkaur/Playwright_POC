package implementations;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;
import locators.MaskScreenshotLocators;
import locators.WindowHandleLocators;
import utils.ConfigReader;

import java.nio.file.Paths;
import java.util.Arrays;

public class WindowHandle {
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
        page.navigate(ConfigReader.windowHandleUrl);
    }
    public static void performActions(){
        try {
            Page popup = page.waitForPopup(()->{
                WindowHandleLocators.home.click();
            });
            popup.waitForLoadState();

            System.out.println(popup.title());
            System.out.println(popup.url());
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

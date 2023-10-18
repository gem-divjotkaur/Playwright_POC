package implementations;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.ScreenshotCaret;
import com.microsoft.playwright.options.SelectOption;
import locators.MaskScreenshotLocators;
import locators.ScreenshotsLocators;
import utils.ConfigReader;

import java.nio.file.Paths;
import java.util.Arrays;

/**
 * Mask locators are basically used when we want to take screenshots but at the same time
 *  we want to hide some private data like username, password or anything else.
 *  It will create a pink box out there to hide them.
 *  It's always applied to the whole page not to a particular locator
 */
public class MaskScreenshot {
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
        page.navigate(ConfigReader.maskScreenshot);
    }
    public static void performActions(){
        try {
            Locator firstname= MaskScreenshotLocators.firstname;
            firstname.type("divjot");
            //lastname
            MaskScreenshotLocators.lastname.type("kaur");
            //email
            MaskScreenshotLocators.email.type("abc@gmail.com");
            //password
            Locator password=MaskScreenshotLocators.password;
            password.type("password");
            //select date  // select by date
            MaskScreenshotLocators.day.selectOption("29");
            // select month
            MaskScreenshotLocators.month.selectOption(new SelectOption().setLabel("Oct"));
            // select year
            MaskScreenshotLocators.year.selectOption(new SelectOption().setLabel("2002"));
            //gender-female
            MaskScreenshotLocators.gender.click();

            page.screenshot(new Page.ScreenshotOptions().setMask(Arrays.asList(firstname, password))
                    .setPath(Paths.get("./snaps/mask.png")));
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

package implementations;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.ScreenshotCaret;
import locators.ScreenshotsLocators;
import locators.UploadFileLocators;
import utils.ConfigReader;

import java.nio.file.Paths;
/**
 * In below method, user takes screenshots
 * It can take screenshots by multiple ways
 * 1) By creating byte[] instance, but it is only used when we want to store screenshot in HTML report not to
 * create separate snapshot
 * 2) By using ScreenshotOptions() method
 * user takes screenshot of visible page, full page, screenshot of a locator, screenshot of Caret/Blink
 *
 */


/** setCaret(ScreenshotCaret.INITIAL) displays the text caret (cursor) in its default state
 * in a screenshot,
 * while setCaret(ScreenshotCaret.HIDE) hides the text caret, making it invisible in the screenshot.
 */
public class Screenshots {
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
        page.navigate(ConfigReader.AmazonUrl);
    }
    public static void performActions(){
        try {
       //     byte[] screenshot = page.screenshot();
//            OR

            // to take screenshot of only current visible page
            //use png format not jpeg cz it offers high picture quality with small size image
            // by default it's png, you can also change it to jpeg format later on
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("./snaps/image1.png")));

            // to take the screenshot of the complete page
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("./snaps/fullscreen.png"))
                    .setFullPage(true));

            // to take screenshot of a locator
            Locator searchBox = ScreenshotsLocators.searchBox;
            searchBox.screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("./snaps/locator.png")));

            // to take screenshot of some caret action / blink action
            searchBox.type("books");
            ScreenshotsLocators.submit.click();

            searchBox.screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("./snaps/Caret-Initial.png"))
                    .setCaret(ScreenshotCaret.INITIAL));

            searchBox.screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("./snaps/Caret-Hide.png"))
                    .setCaret(ScreenshotCaret.HIDE));
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

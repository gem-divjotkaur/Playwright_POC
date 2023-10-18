package implementations;

import com.microsoft.playwright.*;
import locators.UploadFileLocators;
import utils.ConfigReader;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * In below method, user uploads multiple files
 * There are two methods to upload a file : setInputFiles(), Event handlers
 * In below method, user uses setInputFile() method only
 * 1) to upload a single file
 * 2) to upload multiple files
 */
public class UploadFiles {

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
        page.navigate(ConfigReader.uploadFile);
    }
    public static void performActions(){
        try{
            //manage cookies
            UploadFileLocators.cookies.click();
            page.waitForTimeout(2000);
            //OR
            //page.locator("div:has-text('Accept all')").click();

            // to upload file
            UploadFileLocators.upload.setInputFiles(Paths.get("sample.xlsx"));

//            // to upload multiple files in playwright
//            page.locator("input[type='file']").setInputFiles(new Path[] {Paths.get("sample.xlsx"),
//                    Paths.get("sample2.xlsx")});
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

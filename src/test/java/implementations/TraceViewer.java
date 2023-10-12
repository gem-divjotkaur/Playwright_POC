package implementations;

import com.microsoft.playwright.*;
import locators.RecordVideoLocators;
import locators.TraceViewerLocators;
import utils.ConfigReader;

import java.nio.file.Paths;

/**
 * Trace viewer = It provides you the detailed information of all the actions that are done in browser.
 *  It captures the screenshot and snapshot
 *  screenshot is the single image of the current action performed and snapshot are the series of
 *  screenshots of each step performed.
 */
public class TraceViewer {
    public static Playwright playwright;
    public static Browser browser;
    public static BrowserContext context;
    public static Page page;
    public static void launchFacebookSite(){
        // launch browser
        try{
            ConfigReader.getProperties();
            playwright = Playwright.create();
            browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome")
            );
            context = browser.newContext();
            // start tracing
            context.tracing().start(
                    new Tracing.StartOptions()
                            .setSnapshots(true)
                            .setScreenshots(true)
                            .setSources(true)
            );
            page = context.newPage();
            page.navigate(ConfigReader.Facebook);
//            page.waitForTimeout(2000);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void enterFirstname(String firstname){
        // enter firstname
        try{
            Locator name = TraceViewerLocators.name;
            name.type(firstname);
//            page.waitForTimeout(2000);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void enterSurname(String surname){
        // enter lastname
        try{
            Locator lastname = TraceViewerLocators.lastname;
            lastname.type(surname);
//            page.waitForTimeout(2000);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void enterEmail(String email){
        // enter email
        try{
            Locator enterEmail = TraceViewerLocators.email;
            enterEmail.type(email);
//            page.waitForTimeout(2000);
            Locator renterEmail = TraceViewerLocators.renterEmail;
            renterEmail.type(email);
//            page.waitForTimeout(2000);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void enterPassword(String password){
        // enter password
        try{
            Locator pass = TraceViewerLocators.password;
            pass.type(password);
//            page.waitForTimeout(2000);
        }
        catch(Exception e ){
            e.printStackTrace();
        }
    }
    public static void enterBirthDate(){
        // enter birthdate
        try{
            Locator day = TraceViewerLocators.day;
            day.selectOption("29");
//            page.waitForTimeout(2000);
            Locator month = TraceViewerLocators.month;
            month.selectOption("10");
//            page.waitForTimeout(2000);
            Locator year = TraceViewerLocators.year;
            year.selectOption("2002");
//            page.waitForTimeout(2000);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void enterGender(){
        // enter gender
        try{
            Locator gender = TraceViewerLocators.gender;
            gender.click();
//            page.waitForTimeout(2000);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void tearDownFacebook(){
        // close browser
        try{
            // stop tracing
            context.tracing().stop(
                    new Tracing.StopOptions().setPath(Paths.get("trace2.zip"))
            );
            page.close();
            context.close();
            playwright.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

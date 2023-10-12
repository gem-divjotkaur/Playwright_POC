package implementations;

import com.microsoft.playwright.*;
import locators.RecordVideoLocators;
import utils.ConfigReader;

import java.nio.file.Paths;

/**
 * The purpose of this class is to record video using playwright tool
 * It can be done with the help of setRecordVideoDir() method
 */
public class RecordVideo {
    public static Playwright playwright;
    public static Browser browser;
    public static BrowserContext context;
    public static Page page;

    public static void launch(){
        // launch browser
        try{
            ConfigReader.getProperties();
            playwright = Playwright.create();
            browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome")
            );
            context = browser.newContext(
                    // record video and save it to provided path
                    new Browser.NewContextOptions()
                            .setRecordVideoDir(Paths.get("video/"))
                            .setRecordVideoSize(1280, 720)
            );
            page = context.newPage();
            page.navigate(ConfigReader.Facebook);
            page.waitForTimeout(2000);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void enterFirstname(String firstname){
       try{
           Locator name = RecordVideoLocators.name;
           name.type(firstname);
           page.waitForTimeout(2000);
       }
       catch(Exception e){
           e.printStackTrace();
       }
    }
    public static void enterSurname(String surname){
        try{
            Locator lastname = RecordVideoLocators.lastname;
            lastname.type(surname);
            page.waitForTimeout(2000);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void enterEmail(String email){
        try{
            Locator enterEmail = RecordVideoLocators.email;
            enterEmail.type(email);
            page.waitForTimeout(2000);
            Locator renterEmail = RecordVideoLocators.renterEmail;
            renterEmail.type(email);
            page.waitForTimeout(2000);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void enterPassword(String password){
        try{
            Locator pass = RecordVideoLocators.password;
            pass.type(password);
            page.waitForTimeout(2000);
        }
        catch(Exception e ){
            e.printStackTrace();
        }
    }
    public static void enterBirthDate(){
        try{
            Locator day = RecordVideoLocators.day;
            day.selectOption("29");
            page.waitForTimeout(2000);
            Locator month = RecordVideoLocators.month;
            month.selectOption("10");
            page.waitForTimeout(2000);
            Locator year = RecordVideoLocators.year;
            year.selectOption("2002");
            page.waitForTimeout(2000);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void enterGender(){
        try{
            Locator gender = RecordVideoLocators.gender;
            gender.click();
            page.waitForTimeout(2000);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void tearDown(){
        // close browser
        try{
            page.close();
            context.close();
            playwright.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

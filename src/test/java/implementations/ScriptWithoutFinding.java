package implementations;

import com.microsoft.playwright.*;
import locators.WithoutFindElementLocators;
import utils.ConfigReader;

/**
 * We can write the scripts without actually finding elements like getByText(),
 * getByLabel(), getByPlaceholder(), getByRole(), getByAltText(),getByTitle(),getByTestId()
 * Below class shows how we can use them in Playwright java :
 */
public class ScriptWithoutFinding {
    public static Playwright playwright;
    public static Browser browser;
    public static BrowserContext context;
    public static Page page;
    public static void launchSite(){
        // launch browser
        try{
            ConfigReader.getProperties();
            playwright = Playwright.create();
            browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false)
                            .setChannel("chrome")
            );
            context = browser.newContext();
            page = context.newPage();
            page.navigate(ConfigReader.bookCart);
            page.waitForTimeout(2000);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void userLogin(String username,String password){
        // search book
        try{
            Locator user = WithoutFindElementLocators.user;
            user.type(username);
            Locator pass = WithoutFindElementLocators.pass;
            pass.type(password);
            Locator clickLogin = WithoutFindElementLocators.clickLogin;
            clickLogin.click();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void userSearchBook(String book){
        //choose option
        try{
            page.waitForTimeout(1000);
            Locator searchBox = WithoutFindElementLocators.searchBox;
            searchBox.type(book);
            Locator options = WithoutFindElementLocators.option;
            options.click();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void userClickImage(){
        // click on image
        try{
            Locator image = WithoutFindElementLocators.image;
            image.click();
            System.out.println(page.url());
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
            browser.close();
            playwright.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

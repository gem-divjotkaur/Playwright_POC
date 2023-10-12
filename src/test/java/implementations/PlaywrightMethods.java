package implementations;

import com.microsoft.playwright.*;
import locators.Methods;
import utils.ConfigReader;

/**
 * This class contains type() method , fill() method, press() method in playwright
 * type() method = it works as copy-paste, it prints the data without removing existing data
 * and adds the data in front of the existing data
 * fill() method = it adds the data after removing the existing data present
 * press() method = it adds the data at the end of the already existing data using type() method
 * clear() = to clear the text
 * textContent() =  to get all the text present inside element
 * innerText() = to get only visible text present
 * isDisabled() = to check if element is disabled or not
 */

public class PlaywrightMethods {

    public static Playwright playwright;
    public static Browser browser;
    public static Page page1;

    public static void launch(){
        ConfigReader.getProperties();
        try{
            playwright = Playwright.create();
            browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome")
            );
            page1 = browser.newPage();
            page1.navigate(ConfigReader.PlaywrightMethodUrl);
            page1.waitForTimeout(2000);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void performTypeMethod(){
        try{
            Locator name = Methods.name;
            name.fill("abc");
            page1.waitForTimeout(2000);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void performFillMethod(){
        try{
            Locator append = Methods.append;
            append.type("hello there");
            page1.waitForTimeout(2000);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void performPressMethod(){
        try{
            Locator getMe = Methods.getMe;
            getMe.press("End");
            getMe.type(" hi there");
            page1.waitForTimeout(2000);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void userClearText(){
        try{
            Locator clearMe = Methods.clearMe;
            clearMe.clear();
            page1.waitForTimeout(2000);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void userCheck(){
        try{
            Locator noEdit = Methods.noEdit;
            boolean isDisabled = noEdit.isDisabled();
            if(isDisabled){
                System.out.println("input field is disabled");
            }
            else{
                System.out.println("input field is not disabled");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void userGetText(){
        try{
            Locator dontWrite = Methods.dontWrite;
            System.out.println("data is : "+dontWrite.getAttribute("value"));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void vanish(){
        try{
            page1.close();
            browser.close();
            playwright.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

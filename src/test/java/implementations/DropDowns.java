package implementations;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;
import locators.DropdownLocators;
import utils.ConfigReader;

import java.util.List;

/**
 * Below class handles the dropdowns in playwright
 * we can select value from dropdowns using 3 ways : by index, by label (visible text), by value
 * we can also select multiple values from dropdown
 * this class handles single dropdowns, multiple dropdowns, count total options, print all values
 * from dropdown
 */
public class DropDowns {
    public static Playwright playwright;
    public static Browser browser;
    public static Page page;

    public static void launchBrowser(){
        try{
            // launch browser
            ConfigReader.getProperties();
            playwright = Playwright.create();
            browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome")
            );
            page = browser.newPage();
            page.navigate(ConfigReader.DropdownUrl);
            page.waitForTimeout(2000);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void userSelectsFruits(){
        try {
            Locator fruits = DropdownLocators.fruits;
            // select by value
            fruits.selectOption("2");

//            // select by label
//            fruits.selectOption(new SelectOption().setLabel("Orange"));

            page.waitForTimeout(2000);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void userSelectHeroes(){
        try {

            Locator heroes = DropdownLocators.heroes;
            // to select multiple values
            heroes.selectOption(new String[] {"ta", "bt"});
            page.waitForTimeout(2000);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void userCountOptions(){
        try {
            Locator language = DropdownLocators.language;
            Locator options = language.locator("option");
            int count = options.count();
            //print total count of options
            System.out.println("total no of languages are : "+count);

            // to select the last option (select by index)
            language.selectOption(new SelectOption().setIndex(count-1));
            page.waitForTimeout(2000);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void userSelectsCountry(){
        try {
            Locator country = DropdownLocators.country;
            Locator options = country.locator("option");
            List<String> value = options.allInnerTexts();
            // to print total options
            for(String text : value){
                System.out.println("countries are : "+text);
            }
            page.waitForTimeout(2000);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void tearDown(){
        try{
            page.waitForTimeout(2000);
            page.close();
            browser.close();
            playwright.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

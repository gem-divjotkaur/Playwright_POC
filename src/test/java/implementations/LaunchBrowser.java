package implementations;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.cucumber.java.en.Given;
import utils.ConfigReader;

import static utils.ConfigReader.AmazonUrl;

public class LaunchBrowser {

    /** This class contains everything related to launch the browser using Playwright
     * You can launch multiple browsers like chromium, firefox, webkit (safari)
     * You can launch local browsers like chrome , ms-edge but the condition is you can launch it using
     * chromium browser only not firefox, webkit
     *
     * By default Playwright run in headless mode only, you can also run it in head mode by
     * setHeadless(false) method
     *
     * At end, you have to close the playwright instance , otherwise the browser will not close
     */
    public static Playwright playwright;
    public static Browser browser;
    public static Page page1;

    // Launch browser using chromium
    public static void userLaunchChromium(){
        try{
            ConfigReader.getProperties();
            playwright = Playwright.create();
            browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false)
            );
            page1 = browser.newPage();
            page1.navigate(ConfigReader.AmazonUrl);
            System.out.println("url of the page is : "+page1.url());
            System.out.println("Title of the page is : "+page1.title());
            page1.waitForTimeout(2000);

            playwright.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    // launch browser using firefox
    public static void userLaunchFirefox(){
        try{
            ConfigReader.getProperties();
            playwright = Playwright.create();
            browser = playwright.firefox().launch(
                    new BrowserType.LaunchOptions().setHeadless(false)
            );
            page1 = browser.newPage();
            page1.navigate(ConfigReader.AmazonUrl);
            System.out.println("url of the page is : "+page1.url());
            System.out.println("Title of the page is : "+page1.title());
            page1.waitForTimeout(2000);

            playwright.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    // user launch browser using webkit
    public static void userLaunchWebkit(){
        try{
            ConfigReader.getProperties();
            playwright = Playwright.create();
            browser = playwright.webkit().launch(
                    new BrowserType.LaunchOptions().setHeadless(false)
            );
            page1 = browser.newPage();
            page1.navigate(ConfigReader.AmazonUrl);
            System.out.println("url of the page is : "+page1.url());
            System.out.println("Title of the page is : "+page1.title());
            page1.waitForTimeout(2000);

            playwright.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    // launch browser using local browser like chrome
    public static void userLaunchChrome(){
        try{
            ConfigReader.getProperties();
            playwright = Playwright.create();
            browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome")
            );
            page1 = browser.newPage();
            page1.navigate(ConfigReader.AmazonUrl);
            System.out.println("url of the page is : "+page1.url());
            System.out.println("Title of the page is : "+page1.title());
            page1.waitForTimeout(2000);

            playwright.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    // launch browser using local browser like ms-edge
    public static void userLaunchMsEdge(){
        try{
            ConfigReader.getProperties();
            playwright = Playwright.create();
            browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false).setChannel("msedge")
            );
            page1 = browser.newPage();
            page1.navigate(ConfigReader.AmazonUrl);
            System.out.println("url of the page is : "+page1.url());
            System.out.println("Title of the page is : "+page1.title());
            page1.waitForTimeout(2000);

            playwright.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

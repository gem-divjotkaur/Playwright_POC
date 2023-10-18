package implementations;

import com.microsoft.playwright.*;
import locators.DownloadFilesLocators;
import utils.ConfigReader;

import java.nio.file.Paths;
/**
 * below downloadAndSave() method will do two things, 1) download the file 2) save downloaded file
 * path() gives you the path of the downloaded file
 * url() gives() you the url from which the file is coming
 * failure() shows failure . if no , then it will give "null"
 * suggestedFileName() will give you the value stored in the download attribute in inspect option
 * saveAs() is used for saving you file in the project
 */
public class DownloadFiles {
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
        page.navigate(ConfigReader.downloadFiles);
    }
    public static void downloadAction(){
        try{
            // waitForDownload is impt in case we want to download a video , so it will wait for download
            Download download = page.waitForDownload(()->{
                DownloadFilesLocators.excel.click();
            });
            System.out.println(download.path());
            System.out.println(download.url());
            System.out.println(download.failure());
            System.out.println(download.suggestedFilename());
            download.saveAs(Paths.get(download.suggestedFilename()));
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

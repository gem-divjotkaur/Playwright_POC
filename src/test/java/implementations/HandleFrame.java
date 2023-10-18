package implementations;

import com.microsoft.playwright.*;
import utils.ConfigReader;

import java.util.List;
import java.util.regex.Pattern;

/**
 * in below handleFrames() method , user handles frame in playwright
 * user uses Frame class and print the no of child frames, and total frames
 * and user moves inside the child frame and normal frame and perform multiple interactions
 */
public class HandleFrame {
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
        page.navigate(ConfigReader.frameUrl);
    }
//    public static void task(){
//        try{
//            // to count total no of iframes
//            List<Frame> frames = page.frames();
//            System.out.println("total no of frames are : "+frames.size());
//
//            // to go inside a frame
//            Frame frame = page.frame("firstFr");
//
//            frame.getByPlaceholder("Enter name").type("abc");
//            page.waitForTimeout(2000);
//
//            frame.getByPlaceholder("Enter email").type("xyz");
//            page.waitForTimeout(2000);
//
//            // to count total no of child frames
//            List<Frame> childFrames = frame.childFrames();
//            System.out.println(childFrames.size());
////
////            // to get the url of child-frames
////            childFrames.forEach(f->{
////                System.out.println(f.url());
////            });
////            //to get into child-frame
////            Frame childFrame = page13.frameByUrl("https://letcode.in/innerFrame");
//
////            ********* OR we can do below part as well ***********
//
//            Frame childFrame = page.frameByUrl(Pattern.compile("innerFrame"));
//            childFrame.getByPlaceholder("Enter email").last().type("abc@gmail.com");
//        }
//        catch(Exception e){
//            e.printStackTrace();
//        }
//    }
    public static void task(){
        try{
            FrameLocator frameLocator = page.frameLocator("#firstFr");
            frameLocator.getByPlaceholder("Enter name").type("abc");
            page.waitForTimeout(2000);

            frameLocator.getByPlaceholder("Enter email").type("xyz");
            page.waitForTimeout(2000);

            FrameLocator frameLocator2 = frameLocator.frameLocator("iframe.has-background-white");
            frameLocator2.getByPlaceholder("Enter email").type("abc@gmail.com");
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

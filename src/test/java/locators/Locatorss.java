package locators;

import com.microsoft.playwright.Locator;

import static implementations.Locators.page;

public class Locatorss {
    // by text-based xpath
      public static Locator button = page.locator("text=Click");

    // by has-text
     public static Locator home =  page.locator("button:has-text('Goto Home')");


    // by text()
         public static Locator product=   page.locator("nav :text('Product')");

//            //by visible()
//            page.locator("button class:visible").click();
//            OR
//            page.locator("a[class='abc'] >> visible=true").click();


    // by nth()
//            page.locator("button").locator("nth=2").click();
}

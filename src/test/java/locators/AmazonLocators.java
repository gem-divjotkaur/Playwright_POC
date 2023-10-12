package locators;

import com.microsoft.playwright.Locator;

import static implementations.BrowserContexts.page1;
import static implementations.BrowserContexts.page2;

public class AmazonLocators {
    public static Locator searchBox = page1.locator("#twotabsearchtextbox");
    public static Locator clickSearch = page1.locator("#nav-search-submit-button");


}

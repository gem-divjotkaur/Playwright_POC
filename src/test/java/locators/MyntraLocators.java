package locators;

import com.microsoft.playwright.Locator;

import static implementations.BrowserContexts.page2;

public class MyntraLocators {
    public static Locator searchBox2 = page2.locator("input[class='desktop-searchBar']");
}

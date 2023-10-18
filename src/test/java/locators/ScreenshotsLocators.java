package locators;

import com.microsoft.playwright.Locator;

import static implementations.Screenshots.page;

public class ScreenshotsLocators {
    public static Locator searchBox = page.locator("#twotabsearchtextbox");
    public static Locator submit =page.locator("#nav-search-submit-button");
}

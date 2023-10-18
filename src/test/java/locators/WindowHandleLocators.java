package locators;

import com.microsoft.playwright.Locator;

import static implementations.WindowHandle.page;

public class WindowHandleLocators {
    public static Locator home = page.locator("#home");
}

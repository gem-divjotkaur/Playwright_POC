package locators;

import com.microsoft.playwright.Locator;

import static implementations.PlaywrightMethods.page1;

public class Methods {
    public static Locator name = page1.locator("#fullName");
    public static Locator append = page1.locator("#join");
    public static Locator getMe = page1.locator("#getMe");
    public static Locator clearMe = page1.locator("#clearMe");
    public static Locator noEdit = page1.locator("#noEdit");
    public static Locator dontWrite = page1.locator("#dontwrite");
}

package locators;

import com.microsoft.playwright.Locator;

import static implementations.Alerts.page;

public class AlertLocators {

    public static Locator simpleAlert = page.locator("#accept");
    public static Locator confirmAlert = page.locator("#confirm");
    public static Locator promptAlert = page.locator("#prompt");
    public static Locator myName = page.locator("#myName");
    public static Locator sweetAlert = page.locator("#modern");
    public static Locator text = page.locator("p[class='title']");
    public static Locator crossButton = page.locator("button[class='modal-close is-large']");
}

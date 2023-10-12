package locators;

import com.microsoft.playwright.Locator;

import static implementations.Authentication.page;

public class AuthenticationLocators {
    public static Locator text = page.locator("//p[contains(text(),\"You must have\")]");
}

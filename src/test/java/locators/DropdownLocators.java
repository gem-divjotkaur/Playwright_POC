package locators;

import com.microsoft.playwright.Locator;

import static implementations.DropDowns.page;

public class DropdownLocators {

    public static Locator fruits = page.locator("#fruits");
    public static Locator heroes = page.locator("#superheros");
    public static Locator language = page.locator("#lang");
    public static Locator country = page.locator("#country");

}

package locators;

import com.microsoft.playwright.Locator;

import static implementations.RecordVideo.page;

public class RecordVideoLocators {

    public static Locator name = page.locator("input[name='firstname']");
    public static Locator lastname = page.locator("input[name='lastname']");
    public static Locator email = page.locator("input[name='reg_email__']");
    public static Locator renterEmail = page.locator("input[name='reg_email_confirmation__']");
    public static Locator password = page.locator("input[name='reg_passwd__']");
    public static Locator day = page.locator("select[id='day']");
    public static Locator month = page.locator("select[id='month']");
    public static Locator year = page.locator("select[id='year']");
    public static Locator gender = page.locator("//input[@name='sex' and @value='1']");
}

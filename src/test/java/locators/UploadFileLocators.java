package locators;

import com.microsoft.playwright.Locator;

import static implementations.UploadFiles.page;

public class UploadFileLocators {
    public static Locator cookies = page.locator("//div[text()='Accept all']");
    public static Locator upload = page.locator("input[type='file']");
}

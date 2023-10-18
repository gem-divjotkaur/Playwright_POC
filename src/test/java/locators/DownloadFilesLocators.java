package locators;

import com.microsoft.playwright.Locator;

import static implementations.DownloadFiles.page;

public class DownloadFilesLocators {
    public static Locator excel = page.getByText("Download Excel");
}

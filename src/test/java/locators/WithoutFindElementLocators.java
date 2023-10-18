package locators;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;

import static implementations.ScriptWithoutFinding.page;

public class WithoutFindElementLocators {
    // getByPlaceholder()
    public static Locator user = page.locator("input[data-placeholder='Username']");
    public static Locator pass = page.locator("input[data-placeholder='Password']");
    // getByText()
    public static Locator clickLogin = page.getByText("Login").last();
    public static Locator searchBox = page.getByPlaceholder("Search books or authors");
    public static Locator option = page.getByRole(AriaRole.OPTION).first();
    public static Locator image = page.getByAltText("Book cover image");
}

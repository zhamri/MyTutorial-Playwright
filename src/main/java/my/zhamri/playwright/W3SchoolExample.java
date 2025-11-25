package my.zhamri.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class W3SchoolExample {
    public static void main(String[] args) {
        // Create Playwright instance
        try (Playwright playwright = Playwright.create()) {

            // Launch browser (Chromium)
            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false) // show browser
            );

            // Create a page
            Page page = browser.newPage();

            page.navigate("https://www.w3schools.com/html/html_forms.asp");

            page.fill("input[name='fname']", "Zhamri");
            page.fill("input[name='lname']", "Che Ani");
            page.click("input[type='submit']");

            // Pause here to see the search result
            page.pause();

            // Close browser
            browser.close();
        }
    }
}

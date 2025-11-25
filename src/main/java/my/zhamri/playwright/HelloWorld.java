package my.zhamri.playwright;


import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HelloWorld {
    public static void main(String[] args) {
        // Create Playwright instance
        try (Playwright playwright = Playwright.create()) {

            // Launch browser (Chromium)
            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false) // show browser
            );

            // Create a page
            Page page = browser.newPage();

            // Go to a website
            page.navigate("https://example.com");

            // Print page title
            System.out.println("Page title: " + page.title());

            // Close browser
            browser.close();
        }
    }
}


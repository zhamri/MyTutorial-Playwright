package my.zhamri.playwright;

import com.microsoft.playwright.*;

public class GoogleClickExample {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();

            page.navigate("https://www.google.com");

            // Accept cookies (if needed)
            if (page.locator("button:has-text('Accept')").count() > 0) {
                page.locator("button:has-text('Accept')").click();
            }

            // Click the search box
            page.click("textarea[name='q']");

            // Type text
            page.type("textarea[name='q']", "zhamri github");

            // Submit search
            page.keyboard().press("Enter");

            // Pause here to see the search result
            page.pause();

            // wait 10 seconds
//            Thread.sleep(10000);

            browser.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}


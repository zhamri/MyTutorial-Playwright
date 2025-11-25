package my.zhamri.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ExampleTest {

    static Playwright playwright;
    static Browser browser;

    @BeforeAll
    static void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch();
//        browser = playwright.chromium().launch(
//                new BrowserType.LaunchOptions().setHeadless(false)
//        );
    }

    @AfterAll
    static void tearDown() {
        browser.close();
        playwright.close();
    }

    @Test
    void helloWorldTest() {
        Page page = browser.newPage();
        page.navigate("https://example.com");

        Assertions.assertEquals("Example Domain", page.title());
    }
}


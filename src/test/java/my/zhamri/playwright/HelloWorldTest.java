package my.zhamri.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HelloWorldTest {

    @Test
    public void testHelloWorld() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch();
        Page page = browser.newPage();
        page.navigate("http://example.com");
        String title = page.title();
        System.out.println(title);
//        Assertions.assertEquals("Hello World!", title);
        Assertions.assertEquals("Example Domain", title);
        browser.close();
        playwright.close();
    }
}

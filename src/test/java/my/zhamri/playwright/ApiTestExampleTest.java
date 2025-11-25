package my.zhamri.playwright;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

public class ApiTestExampleTest {

    static Playwright playwright;
    static APIRequestContext request;

    @BeforeAll
    static void setup() {
        playwright = Playwright.create();
        request = playwright.request().newContext();
    }

    @AfterAll
    static void tearDown() {
        request.dispose();
        playwright.close();
    }

    @Test
    void testGetPost() {
        APIResponse response = request.get("https://jsonplaceholder.typicode.com/posts/1");

        System.out.println("Status Code: " + response.status());
        System.out.println("Response Body: " + response.text());

        // Assertions for testing
        Assertions.assertEquals(200, response.status(), "Status should be 200");
        Assertions.assertTrue(response.text().contains("\"id\": 1"), "Response should contain id = 1");
    }
}

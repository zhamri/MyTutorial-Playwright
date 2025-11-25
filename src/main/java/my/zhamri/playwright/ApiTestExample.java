package my.zhamri.playwright;

import com.microsoft.playwright.*;

public class ApiTestExample {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {

            APIRequest api = playwright.request();
            APIRequestContext request = api.newContext();

            APIResponse response = request.get("https://jsonplaceholder.typicode.com/posts/1");

            System.out.println("Status Code: " + response.status());
            System.out.println("Response Body: " + response.text());
        }
    }
}


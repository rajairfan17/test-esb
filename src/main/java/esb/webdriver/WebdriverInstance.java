package esb.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebdriverInstance {
    public static WebDriver webdriver;

    public static void initialize(String url) {
        webdriver = new ChromeDriver();
        webdriver.manage().window().maximize();
        webdriver.get(url);
    }

    public static void quit() {
        webdriver.quit();
    }
}

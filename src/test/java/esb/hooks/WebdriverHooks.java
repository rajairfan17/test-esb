package esb.hooks;

import esb.webdriver.WebdriverInstance;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.SessionNotCreatedException;

import static esb.utils.constants.WEB_URL;

public class WebdriverHooks {
    @Before(value = "@WebOrange")
    public void initializeWebdriver() {
        try {
            WebdriverInstance.initialize(WEB_URL);
        } catch (SessionNotCreatedException e) {
            WebdriverInstance.initialize(WEB_URL);
        }
    }

    @After(value = "@WebOrange")
    public void quitWebdriver() {
        WebdriverInstance.quit();
    }
}

package esb;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(stepNotifications = true,
        plugin = {"pretty", "html:build/result.html","json:build/cucumber.json"},
        features = {"src/test/resources/features"})
public class CucumberRunner {
}

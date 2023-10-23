package esb.steps_definition;

import esb.page.esb.DashboardPage;
import esb.page.esb.LoginPage;
import io.cucumber.java8.En;

public class LogoutSteps implements En {
    DashboardPage dashboardPage = new DashboardPage();
    LoginPage loginPage = new LoginPage();
    public LogoutSteps() {
        When("User click button profile icon", () -> dashboardPage.clickProfileIcon());
        And("^User click button \"([^\"]*)\" from user dropdown$", (String action) -> dashboardPage.selectUserDropDown(action));
        Then("User successfully logout", () -> loginPage.isOnLoginPage());
    }
}

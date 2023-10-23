package esb.steps_definition;


import esb.page.esb.DashboardPage;
import esb.page.esb.LoginPage;
import io.cucumber.java8.En;

public class LoginSteps implements En {
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    public LoginSteps() {
        Given("User is on the login page", () -> loginPage.isOnLoginPage());
        And("^User input username as \"([^\"]*)\"$", (String username) -> loginPage.inputUsername(username));
        And("^User input password as \"([^\"]*)\"$", (String password) -> loginPage.inputPassword(password));
        And("User click button login", () -> loginPage.clickBtnLogin());
        Then("User successfully login", () -> dashboardPage.IsOnDashboardPage());
        When("^User click \"([^\"]*)\" menu$", (String menu) -> dashboardPage.clickMenu(menu));
    }
}

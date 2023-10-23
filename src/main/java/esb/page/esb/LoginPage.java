package esb.page.esb;

import esb.page.base.BasePageObject;

public class LoginPage extends BasePageObject {
    String LOGIN_PAGE = "css_.orangehrm-login-form";
    String INPUT_USERNAME_LOGIN_PAGE = "xpath_//input[@name='username']";
    String INPUT_PASSWORD_LOGIN_PAGE = "xpath_//input[@name='password']";
    String BUTTON_LOGIN_LOGIN_PAGE = "css_.orangehrm-login-button";

    public void isOnLoginPage() {

        assertIsPresent(LOGIN_PAGE);
    }

    public void inputUsername(String username) {
        typeOn(INPUT_USERNAME_LOGIN_PAGE, username);
    }

    public void inputPassword(String password) {
        typeOn(INPUT_PASSWORD_LOGIN_PAGE, password);
    }

    public void clickBtnLogin() {
        clickOn(BUTTON_LOGIN_LOGIN_PAGE);
    }
}

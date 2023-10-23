package esb.page.esb;

import esb.page.base.BasePageObject;

public class DashboardPage extends BasePageObject {
    String DASHBOARD_PAGE = "css_.orangehrm-dashboard-grid";
    String PROFILE_ICON_DASHBOARD_PAGE = "css_.oxd-userdropdown-img";
    String DROPDOWN_USER_DASHBOARD_PAGE = "xpath_//a[@class='oxd-userdropdown-link' and text()='%s']";
    String MENU_DASHBOARD_PAGE = "xpath_//span[contains(@class,'oxd-main-menu-item--name') and text()='%s']";

    public void IsOnDashboardPage() {
        assertIsPresent(DASHBOARD_PAGE);
    }

    public void clickProfileIcon() {
        clickOn(PROFILE_ICON_DASHBOARD_PAGE);
    }

    public void selectUserDropDown(String action) {
        switch (action.toUpperCase()) {
            case "LOGOUT":
                clickOn(DROPDOWN_USER_DASHBOARD_PAGE, "Logout");
                break;
            default:
                printError("Invalid option: " + action.toUpperCase());
        }
    }

    public void clickMenu(String menu) {
        switch (menu.toUpperCase()) {
            case "LEAVE":
                clickOn(MENU_DASHBOARD_PAGE, "Leave");
                break;
            case "MY INFO":
                clickOn(MENU_DASHBOARD_PAGE, "My Info");
                break;
            default:
                printError("Invalid option: " + menu.toUpperCase());
        }
    }
}

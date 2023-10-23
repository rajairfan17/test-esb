package esb.page.esb;

import esb.page.base.BasePageObject;

public class MyInfoPage extends BasePageObject {
    String SUBMENU_MYINFO_PAGE = "xpath_//a[contains(@class,'orangehrm-tabs-item') and text()='%s']";
    public void clickSubmenu(String submenu) {
        switch (submenu.toUpperCase()) {
            case "CONTACT DETAILS":
                clickOn(SUBMENU_MYINFO_PAGE, "Contact Details");
                break;
            default:
                printError("Invalid option: " + submenu.toUpperCase());
        }
    }
}

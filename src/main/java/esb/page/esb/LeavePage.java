package esb.page.esb;

import esb.page.base.BasePageObject;

public class LeavePage extends BasePageObject {
    String NAV_MENU_LEAVE_PAGE = "xpath_//a[@class='oxd-topbar-body-nav-tab-item' and text()='%s']";
    String BUTTON_DROPDOWN_LEAVE_TYPEE_LEAVE_PAGE = "css_.oxd-select-text--after";
    String LIST_DROPDOWN_LEAVE_TYPEE_LEAVE_PAGE = "xpath_//div[contains(@class,'oxd-select-dropdown')]//*[text()='%s']";
    String INPUT_FROM_DATE_LEAVE_PAGE = "xpath_(//div[@class='oxd-date-input']//input)[1]";
    String INPUT_COMMENT_LEAVE_PAGE = "css_.oxd-textarea";
    String BUTTON_APPLY_LEAVE_PAGE = "css_.oxd-button";
    String POPUP_SUCCESS_LEAVE_PAGE = "xpath_//div[contains(@class,'oxd-toast-container')]//*[text()='Success']";
    String BUTTON_CANCEL_LEAVE_PAGE = "css_.oxd-table-cell-actions .oxd-button";

    public void clickNavbarMenu(String navMenu) {
        switch (navMenu.toUpperCase()) {
            case "APPLY":
                clickOn(NAV_MENU_LEAVE_PAGE, "Apply");
                break;
            case "MY LEAVE":
                clickOn(NAV_MENU_LEAVE_PAGE, "My Leave");
                break;
            default:
                printError("Invalid option: " + navMenu.toUpperCase());
        }
    }

    public void selectLeaveType(String leaveType) {
        clickOn(BUTTON_DROPDOWN_LEAVE_TYPEE_LEAVE_PAGE);
        clickOn(LIST_DROPDOWN_LEAVE_TYPEE_LEAVE_PAGE, leaveType);
    }

    public void inputLeaveDate(String fromDate) {
        typeOn(INPUT_FROM_DATE_LEAVE_PAGE, fromDate);
    }

    public void inputComment(String comment) {
        typeOn(INPUT_COMMENT_LEAVE_PAGE, comment);
    }

    public void clickBtnApply() {
        clickOn(BUTTON_APPLY_LEAVE_PAGE);
    }

    public void isPopupSuccess() {
        assertIsPresent(POPUP_SUCCESS_LEAVE_PAGE);
    }

    public void clickCancelLeave() {
        clickOn(BUTTON_CANCEL_LEAVE_PAGE);
    }
}

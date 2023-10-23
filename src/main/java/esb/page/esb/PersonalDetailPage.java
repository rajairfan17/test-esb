package esb.page.esb;

import esb.page.base.BasePageObject;

public class PersonalDetailPage extends BasePageObject {
    String INPUT_FIRSTNAME_PERSONAL_DETAIL_PAGE = "css_.orangehrm-firstname";
    String INPUT_MIDDLENAME_PERSONAL_DETAIL_PAGE = "css_.orangehrm-middlename";
    String INPUT_LASTNAME_PERSONAL_DETAIL_PAGE = "css_.orangehrm-lastname";
    String INPUT_NICKNAME_PERSONAL_DETAIL_PAGE = "xpath_//label[text()='Nickname']/parent::div/following-sibling::div/input";
    String BUTTON_SAVE_PERSONAL_DETAIL_PAGE = "xpath_(//button[contains(@class,'oxd-button')])[1]";
    String POPUP_SUCCESS_DETAIL_PAGE = "xpath_//div[contains(@class,'oxd-toast-container')]//*[text()='Success']";
    public void inputFirstname(String firstname) {
        typeOn(INPUT_FIRSTNAME_PERSONAL_DETAIL_PAGE, firstname);
    }

    public void inputMiddlename(String middlename) {
        typeOn(INPUT_MIDDLENAME_PERSONAL_DETAIL_PAGE, middlename);
    }

    public void inputLastname(String lastname) {
        typeOn(INPUT_LASTNAME_PERSONAL_DETAIL_PAGE, lastname);
    }

    public void inputNickname(String nickname) {
        typeOn(INPUT_NICKNAME_PERSONAL_DETAIL_PAGE, nickname);
    }

    public void clickBtnSave() {
        clickOn(BUTTON_SAVE_PERSONAL_DETAIL_PAGE);
    }

    public void isPopupSuccess() {
        assertIsPresent(POPUP_SUCCESS_DETAIL_PAGE);
    }
}

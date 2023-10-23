package esb.page.esb;

import esb.page.base.BasePageObject;

public class ContactDetailPage extends BasePageObject {
    String INPUT_STREET1_CONTACT_DETAIL_PAGE = "xpath_//label[text()='Street 1']/parent::div/following-sibling::div/input";
    String INPUT_CITY_CONTACT_DETAIL_PAGE = "xpath_//label[text()='City']/parent::div/following-sibling::div/input";
    String INPUT_MOBILE_PHONE_CONTACT_DETAIL_PAGE = "xpath_//label[text()='Mobile']/parent::div/following-sibling::div/input";
    String BUTTON_SAVE_PERSONAL_CONTACT_DETAIL_PAGE = "xpath_(//button[contains(@class,'oxd-button')])[1]";
    String POPUP_SUCCESS_CONTACT_DETAIL_PAGE = "xpath_//div[contains(@class,'oxd-toast-container')]//*[text()='Success']";

    public void inputStreet1(String street1) {
        typeOn(INPUT_STREET1_CONTACT_DETAIL_PAGE, street1);
    }

    public void inputCity(String city) {
        typeOn(INPUT_CITY_CONTACT_DETAIL_PAGE, city);
    }

    public void inputMobilePhone(String mobilePhone) {
        typeOn(INPUT_MOBILE_PHONE_CONTACT_DETAIL_PAGE, mobilePhone);
    }

    public void clickSaveContact() {
        clickOn(BUTTON_SAVE_PERSONAL_CONTACT_DETAIL_PAGE);
    }

    public void isPopupSuccess() {
        assertIsPresent(POPUP_SUCCESS_CONTACT_DETAIL_PAGE);
    }
}

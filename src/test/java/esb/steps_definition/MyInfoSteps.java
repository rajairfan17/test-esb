package esb.steps_definition;

import esb.page.esb.ContactDetailPage;
import esb.page.esb.MyInfoPage;
import esb.page.esb.PersonalDetailPage;
import io.cucumber.java8.En;

public class MyInfoSteps implements En {
    MyInfoPage myInfoPage = new MyInfoPage();
    PersonalDetailPage personalDetailPage = new PersonalDetailPage();
    ContactDetailPage contactDetailPage = new ContactDetailPage();

    public MyInfoSteps() {
        And("^User input firstname as \"([^\"]*)\"$", (String firstname) -> personalDetailPage.inputFirstname(firstname));
        And("^User input middlename as \"([^\"]*)\"$", (String middlename) -> personalDetailPage.inputMiddlename(middlename));
        And("^User input lastname as \"([^\"]*)\"$", (String lastname) -> personalDetailPage.inputLastname(lastname));
        And("^User input nickname as \"([^\"]*)\"$", (String nickname) -> personalDetailPage.inputNickname(nickname));
        And("User click save button in personal details page", () -> personalDetailPage.clickBtnSave());
        Then("User successfully update personal details", () -> personalDetailPage.isPopupSuccess());
        And("^User click \"([^\"]*)\" submenu from my info page$", (String submenu) -> myInfoPage.clickSubmenu(submenu));
        And("^User input street 1 as \"([^\"]*)\"$", (String street1) -> contactDetailPage.inputStreet1(street1));
        And("^User input city as \"([^\"]*)\"$", (String city) -> contactDetailPage.inputCity(city));
        And("^User input mobile phone as \"([^\"]*)\"$", (String mobilePhone) -> contactDetailPage.inputMobilePhone(mobilePhone));
        And("User click save button in contact details page", () -> contactDetailPage.clickSaveContact());
        Then("User successfully update contact details", () -> contactDetailPage.isPopupSuccess());
    }
}

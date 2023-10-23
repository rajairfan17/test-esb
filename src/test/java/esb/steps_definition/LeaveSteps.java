package esb.steps_definition;

import esb.page.esb.LeavePage;
import io.cucumber.java8.En;

public class LeaveSteps implements En {
    LeavePage leavePage = new LeavePage();
    public LeaveSteps() {
        And("^User click \"([^\"]*)\" menu in leave page$", (String navMenu) -> leavePage.clickNavbarMenu(navMenu));
        And("^User select leave type as \"([^\"]*)\"$", (String leaveType) -> leavePage.selectLeaveType(leaveType));
        And("^User select leave date \"([^\"]*)\"$", (String fromDate) -> leavePage.inputLeaveDate(fromDate));
        And("^User input comment as \"([^\"]*)\"$", (String comment) -> leavePage.inputComment(comment));
        And("User click apply button", () -> leavePage.clickBtnApply());
        Then("User successfully apply leave", () -> leavePage.isPopupSuccess());
        And("User click cancel leave one of leave list", () -> leavePage.clickCancelLeave());
        Then("User successfully cancel leave", () -> leavePage.isPopupSuccess());
    }
}

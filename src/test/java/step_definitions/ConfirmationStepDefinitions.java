package step_definitions;

import io.cucumber.java.en.And;
import page_objects.ConfirmationPage;

public class ConfirmationStepDefinitions {

    private ConfirmationPage confirmPage = new ConfirmationPage();

    @And("Click confirm order button")
    public void clickConfirmOrderButton(){
        confirmPage.clickConfirmOrderButton();
    }

    @And("Verify the total amount is {string}")
    public void verifyTotalAmount(String expectedTotal){
        confirmPage.verifyTotalAmount(expectedTotal);
    }

    @And("Verify thank you label")
    public void verifyThankYouLabel() {
        confirmPage.verifyThankYouLabel();
    }
}

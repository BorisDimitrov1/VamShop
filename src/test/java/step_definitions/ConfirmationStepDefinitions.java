package step_definitions;

import io.cucumber.java.en.And;
import org.junit.Assert;
import page_objects.ConfirmationPage;

public class ConfirmationStepDefinitions {

    private ConfirmationPage confirmPage = new ConfirmationPage();

    @And("Click confirm order button")
    public void clickConfirmOrderButton(){
        confirmPage.clickConfirmOrderButton();
    }

    @And("Verify the total amount is {string}")
    public void verifyTotalAmount(String expectedTotal){
        Assert.assertEquals(expectedTotal, confirmPage.getTotalAmount());
    }

    @And("Verify thank you label have text {string}")
    public void verifyThankYouLabel(String expectedText) {
        Assert.assertEquals(expectedText, confirmPage.getThankYouLabelText());
    }
}

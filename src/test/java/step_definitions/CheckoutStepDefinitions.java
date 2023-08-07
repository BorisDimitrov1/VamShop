package step_definitions;

import io.cucumber.java.en.And;
import org.junit.Assert;
import page_objects.CheckoutPage;

import java.util.Arrays;
import java.util.List;

public class CheckoutStepDefinitions {

    private CheckoutPage checkoutPage = new CheckoutPage();

    @And("Verify there are {int} payment methods presented")
    public void verifyThereArePaymentMethodsPresented(int expectedNumberOfPaymentMethods) {
        Assert.assertEquals(checkoutPage.getNumberOfPaymentMethods(), expectedNumberOfPaymentMethods);
    }

    @And("Verify the Payment Methods presented are {string}")
    public void verifyThePaymentMethodsPresentedAre(String expectedPaymentMethods) {
        List<String> actualPaymentMethodNames = checkoutPage.getPaymentMethodsNames();

        List<String> expectedPaymentMethodsAsString = Arrays.asList(expectedPaymentMethods.split(","));

        Assert.assertTrue(actualPaymentMethodNames.size() == expectedPaymentMethodsAsString.size() && actualPaymentMethodNames.containsAll(expectedPaymentMethodsAsString));
    }

    @And("Populate name field in checkout page with {string}")
    public void populateNameField(String name){
        checkoutPage.populateNameField(name);
    }

    @And("Populate email field in checkout page with {string}")
    public void populateEmailFieldInCheckoutPageWith(String email) {
        checkoutPage.populateEmailField(email);
    }

    @And("Populate phone field in checkout page with {string}")
    public void populatePhoneFieldInCheckoutPageWith(String phone) {
        checkoutPage.populatePhoneField(phone);
    }

    @And("Select In-store pickup from the payment methods in checkout page")
    public void selectInStorePickupFromThePaymentMethodsInCheckoutPage() {
        checkoutPage.selectInStorePickUp();
    }

    @And("Click on Continue button in checkout page")
    public void clickOnContinueButtonInCheckoutPage() {
        checkoutPage.clickContinue();
    }
}

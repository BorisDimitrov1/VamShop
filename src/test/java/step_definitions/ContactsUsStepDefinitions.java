package step_definitions;

import io.cucumber.java.en.And;
import page_objects.ContactUsPage;

public class ContactsUsStepDefinitions {

    private ContactUsPage contactUs = new ContactUsPage();

    @And("Populate name field in contact us page with {string}")
    public void populateNameFieldInContactUsPageWith(String name) {
        contactUs.populateNameField(name);
    }

    @And("Populate email field in contact us page with {string}")
    public void populateEmailFieldInContactUsPageWith(String email) {
        contactUs.populateEmailField(email);
    }

    @And("Populate message field in contacts us page with {string}")
    public void populateMessageFieldInContactsUsPageWith(String message) {
        contactUs.populateMessageField(message);
    }

    @And("Click send button in contact us page")
    public void clickSendButtonInContactUsPage() {
        contactUs.clickSendButton();
    }
}

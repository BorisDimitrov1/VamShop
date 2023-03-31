package step_definitions.admin;

import io.cucumber.java.en.And;
import page_objects.admin.AdminPanel;

public class AdminPanelStepDefinitions {

    private AdminPanel adminPanel = new AdminPanel();

    @And("Verify order with customer name {string} is presented")
    public void verifyOrderWithCustomerNameIsPresented(String expectedCustomerName) {
        adminPanel.verifyCustomerNameInOrders(expectedCustomerName);
    }

    @And("Click contact us tab in admin panel")
    public void clickContactUsTabInAdminPanel() {
        adminPanel.clickContactUsTab();
    }

    @And("Verify message with customer name {string} is presented")
    public void verifyMessageWithCustomerNameIsPresented(String expectedCustomerName) {
        adminPanel.verifyCustomerNameInContactUs(expectedCustomerName);
    }
}

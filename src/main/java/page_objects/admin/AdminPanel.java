package page_objects.admin;

import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AdminPanel {

    private By firstCustomerNameInOrdersTab = By.xpath("(//tr[@class='contentRowEven highlight']//td//a)[1]");

    private By firstContactNameInContactUsTab = By.xpath("(//table[@class='orderTable']//tr//td//a)[1]");

    private By contactUsTab = By.xpath("//a[@href='#contact-us']");

    public void verifyCustomerNameInOrders(String expectedName){
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(firstCustomerNameInOrdersTab));
        Browser.wait.until(ExpectedConditions.textToBePresentInElementLocated(firstCustomerNameInOrdersTab, expectedName));
    }

    public void clickContactUsTab(){
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(contactUsTab)).click();
    }

    public void verifyCustomerNameInContactUs(String expectedName){
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(firstContactNameInContactUsTab));
        Browser.wait.until(ExpectedConditions.textToBePresentInElementLocated(firstContactNameInContactUsTab, expectedName));
    }
}

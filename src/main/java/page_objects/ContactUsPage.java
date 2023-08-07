package page_objects;

import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactUsPage {

    private By nameField = By.id("name");

    private By emailField = By.id("email");

    private By messageField = By.id("message");

    private By sendButton = By.xpath("//form[@id='contentform']//button[@type='submit']");

    public void populateNameField(String name) {
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(nameField)).clear();
        Browser.getDriver().findElement(nameField).sendKeys(name);
    }

    public void populateEmailField(String email) {
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).clear();
        Browser.getDriver().findElement(emailField).sendKeys(email);
    }

    public void populateMessageField(String message) {
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(messageField)).clear();
        Browser.getDriver().findElement(messageField).sendKeys(message);
    }

    public void clickSendButton(){
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(sendButton)).click();
    }
}

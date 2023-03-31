package page_objects;

import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Arrays;
import java.util.List;

public class CheckoutPage {

    private By allPaymentMethods = By.xpath("//label[@class='payment-method']");

    private By allPaymentMethodsNames = By.xpath("//label[@class='payment-method']//span[@class='name']");

    private By name = By.id("bill_name");

    private By email = By.id("email");

    private By phone = By.id("phone");
    private By inStorePickup = By.id("payment_1");
    private By continueButton = By.xpath("//button[@value='Continue']");

    public void verifyNumberOfPaymentMethods(int expectedNumberOfPaymentMethods){
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(allPaymentMethods));
        Browser.wait.until(ExpectedConditions.numberOfElementsToBe(allPaymentMethods, expectedNumberOfPaymentMethods));
    }

    public void verifyPaymentMethodsNames(String expectedPaymentMethodsNames){

        List<WebElement> actualPaymentMethods = Browser.wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(allPaymentMethodsNames));

        List<String> expectedPaymentMethodsAsList = Arrays.asList(expectedPaymentMethodsNames.split(","));

        for(int currentIndex = 0; currentIndex < expectedPaymentMethodsAsList.size(); currentIndex++){
            Browser.wait.until(ExpectedConditions.textToBePresentInElement(actualPaymentMethods.get(currentIndex), expectedPaymentMethodsAsList.get(currentIndex).trim()));
        }
    }

    public void populateNameField(String name){
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(this.name)).clear();
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(this.name)).sendKeys(name);
    }

    public void populateEmailField(String email) {
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(this.email)).clear();
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(this.email)).sendKeys(email);
    }

    public void populatePhoneField(String phone) {
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(this.phone)).clear();
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(this.phone)).sendKeys(phone);
    }

    public void selectInStorePickUp() {
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(inStorePickup)).click();
    }

    public void clickContinue() {
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(continueButton)).click();
    }
}

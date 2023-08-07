package page_objects;

import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
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

    public int getNumberOfPaymentMethods(){
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(allPaymentMethods));

        return Browser.getDriver().findElements(allPaymentMethods).size();
    }

    public List<String> getPaymentMethodsNames(){
        List<WebElement> actualPaymentMethods = Browser.wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(allPaymentMethodsNames));

        List<String> paymentMethodsAsStrings = new ArrayList<String>();

        int index = 0;
        for(WebElement el : actualPaymentMethods){
            paymentMethodsAsStrings.add(actualPaymentMethods.get(index++).getText());
        }

        return paymentMethodsAsStrings;
    }

    public void populateNameField(String name){
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(this.name)).clear();
        Browser.getDriver().findElement(this.name).sendKeys(name);
    }

    public void populateEmailField(String email) {
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(this.email)).clear();
        Browser.getDriver().findElement(this.email).sendKeys(email);
    }

    public void populatePhoneField(String phone) {
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(this.phone)).clear();
        Browser.getDriver().findElement(this.phone).sendKeys(phone);
    }

    public void selectInStorePickUp() {
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(inStorePickup)).click();
    }

    public void clickContinue() {
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(continueButton)).click();
    }
}

package page_objects;

import browser.Browser;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ConfirmationPage {

    private By confirmOrderButton = By.xpath("//form[@method='post']//button[@type='submit']");

    private By totalValue = By.xpath("//td[@class='total-value']");
    private By thankYouLabel = By.xpath("//h2[text()='Thank You']");


    public void clickConfirmOrderButton(){
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(confirmOrderButton)).click();
    }

    public String getTotalAmount(){
        return Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(totalValue)).getText();
    }

    public String getThankYouLabelText(){
        return Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(thankYouLabel)).getText();
    }
}

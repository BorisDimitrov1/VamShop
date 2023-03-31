package page_objects;

import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ResultsPage {

    private By searchResultTitle = By.xpath("//h4[@class='title']//a");

    private By allResultsLocator = By.xpath("//ul[@class='thumbnails']//h4");

    private By buyButton = By.xpath("//button[contains(@class,'btn-add-to-cart')]");

    public void verifySearchResultTitle(String expectedTitle){
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(searchResultTitle));
        Browser.wait.until(ExpectedConditions.textToBePresentInElementLocated(searchResultTitle, expectedTitle));
    }

    public void verifyResultsCount(int expectedNumberOfResults) {
        Browser.wait.until(ExpectedConditions.numberOfElementsToBe(allResultsLocator, expectedNumberOfResults));
    }

    public void clickBuyButtonForTheFirstResult() {
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(buyButton)).click();
    }
}

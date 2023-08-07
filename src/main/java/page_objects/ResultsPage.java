package page_objects;

import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ResultsPage {

    private By searchResultTitle = By.xpath("//h4[@class='title']//a");

    private By allResultsLocator = By.xpath("//ul[@class='thumbnails']//h4");

    private By buyButton = By.xpath("//button[contains(@class,'btn-add-to-cart')]");


    public String getSearchResultTitle(){
        return Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(searchResultTitle)).getText();
    }

    public int getResultsCount(){
        return Browser.wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(allResultsLocator)).size();
    }

    public void clickBuyButtonForTheFirstResult() {
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(buyButton)).click();
    }
}

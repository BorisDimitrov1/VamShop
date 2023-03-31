package page_objects.common;

import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Arrays;
import java.util.List;

public class Header {

    private By phoneLocator = By.xpath("//a[contains(@href,'tel')]");
    private By twitterLink = By.xpath("//a[normalize-space(text()) = 'Twitter']");

    private By facebookLink = By.xpath("//a[normalize-space(text()) = 'Facebook']");

    private By contactUsLink = By.xpath("//div[@class='topbar clearfix']//a[normalize-space(text()) = 'Contact Us']");

    private By categoriesDropDown = By.xpath("//a[@class='dropdown-toggle categories']");

    private By allCategoriesPresented = By.xpath("//ul[@class='dropdown-menu categories']//li//a");

    private By searchField = By.id("search-keywords");

    private By searchButton = By.xpath("//form[@id='search']//button[@type='submit']");

    private By itemsAddedToCart = By.xpath("//span[contains(@class,'progress-bar-danger')]");
    private By checkoutButton = By.xpath("//a[contains(@class,'checkout')]");


    public void verifyPhone(String expectedPhone){
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(phoneLocator));
        Browser.wait.until(ExpectedConditions.attributeContains(phoneLocator, "innerText", expectedPhone));
    }


    public void verifyTwitterLink(String expectedLink) {
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(twitterLink));
        Browser.wait.until(ExpectedConditions.attributeToBe(twitterLink, "href", expectedLink));
    }

    public void verifyFacebookLink(String expectedLink) {
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(facebookLink));
        Browser.wait.until(ExpectedConditions.attributeToBe(facebookLink, "href", expectedLink));
    }

    public void verifyContactUsLink(String expectedLink) {
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(contactUsLink));

        String contactUsFullPath = System.getProperty("environmentUrl") + expectedLink;

        Browser.wait.until(ExpectedConditions.attributeToBe(contactUsLink, "href", contactUsFullPath));
    }

    public void clickCategoriesDropdown() {
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(categoriesDropDown)).click();
    }

    public void verifyNumberOfCategories(int numberOfExpectedCategories) {
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(allCategoriesPresented));
        Browser.wait.until(ExpectedConditions.numberOfElementsToBe(allCategoriesPresented, numberOfExpectedCategories));
    }

    public void verifyCategoriesPresented(String expectedCategories) {
        List<WebElement> presentedCategories = Browser.wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(allCategoriesPresented));

        List<String> expectedCategoriesAsList = Arrays.asList(expectedCategories.split(","));

        for(int currentIndex = 0; currentIndex < expectedCategoriesAsList.size(); currentIndex++){
            Browser.wait.until(ExpectedConditions.textToBePresentInElement(presentedCategories.get(currentIndex),expectedCategoriesAsList.get(currentIndex).trim()));
        }
    }

    public void populateSearchField(String keyword){
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(searchField)).clear();
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(searchField)).sendKeys(keyword);
    }

    public void clickSearchButton() {
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(searchButton)).click();
    }

    public void verifyNumberOfItemsInCart(String numberOfItemsAdded) {
        Browser.wait.until(ExpectedConditions.textToBePresentInElementLocated(itemsAddedToCart, numberOfItemsAdded));
    }

    public void clickCheckOutButton() {
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutButton)).click();
    }

    public void clickContactUsButton() {
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(contactUsLink)).click();
    }
}

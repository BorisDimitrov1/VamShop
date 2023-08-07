package page_objects.common;

import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
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

    public String getPhone(){
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(phoneLocator));
        return Browser.getDriver().findElement(phoneLocator).getText();
    }

    public String getTwitterLink(){
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(twitterLink));

        return Browser.getDriver().findElement(twitterLink).getAttribute("href");
    }

    public String getFacebookLink(){
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(facebookLink));

        return Browser.getDriver().findElement(facebookLink).getAttribute("href");
    }

    public String getContactUsLink(){
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(contactUsLink));

        return Browser.getDriver().findElement(contactUsLink).getAttribute("href");
    }

    public void clickCategoriesDropdown() {
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(categoriesDropDown)).click();
    }

    public int getNumberOfCategories(){
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(allCategoriesPresented));

        return Browser.getDriver().findElements(allCategoriesPresented).size();
    }

    public List<String> getCategoriesPresented(){
        List<WebElement> presentedCategories = Browser.wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(allCategoriesPresented));

        List<String> categoriesAsStrings = new ArrayList<String>();

        int index = 0;
        for(WebElement el : presentedCategories){
            categoriesAsStrings.add(presentedCategories.get(index++).getText());
        }

        return categoriesAsStrings;
    }

    public void populateSearchField(String keyword){
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(searchField)).clear();
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(searchField)).sendKeys(keyword);
    }

    public void clickSearchButton() {
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(searchButton)).click();
    }

    public String getNumberOfItemsInCart(){
        return Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(itemsAddedToCart)).getText();
    }

    public void clickCheckOutButton() {
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutButton)).click();
    }

    public void clickContactUsButton() {
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(contactUsLink)).click();
    }
}

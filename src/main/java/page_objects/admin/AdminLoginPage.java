package page_objects.admin;

import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AdminLoginPage {

    private By username = By.id("UserUsername");
    private By password = By.id("UserPassword");

    private By loginButton = By.xpath("//button[@type='submit']");

    public void populateUsername(String username){
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(this.username)).clear();
        Browser.getDriver().findElement(this.username).sendKeys(username);
    }

    public void populatePassword(String password){
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(this.password)).clear();
        Browser.getDriver().findElement(this.password).sendKeys(password);
    }

    public void clickLoginButton(){
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton)).click();
    }
}

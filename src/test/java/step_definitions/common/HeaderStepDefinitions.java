package step_definitions.common;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import page_objects.common.Header;

import java.util.Arrays;
import java.util.List;


public class HeaderStepDefinitions {

    private Header header = new Header();

    @Then("Verify the phone in the header is {string}")
    public void verifyThatThePhoneInTheHeaderIs(String expectedPhone) {
        Assert.assertEquals(expectedPhone, header.getPhone());
    }

    @And("Verify the Twitter link in the header leads to {string}")
    public void verifyTheTwitterLinkInTheHeaderIs(String expectedLink) {
        Assert.assertEquals(expectedLink, header.getTwitterLink());
    }

    @And("Verify the Facebook link in the header leads to {string}")
    public void verifyTheFacebookLinkInTheHeaderIs(String expectedLink) {
        Assert.assertEquals(expectedLink, header.getFacebookLink());
    }

    @And("Verify the Contact us link in the header leads to {string}")
    public void verifyTheContactUsLinkInTheHeaderIs(String expectedLink) {
        Assert.assertTrue(header.getContactUsLink().endsWith(expectedLink));
    }

    @And("Click on the categories dropdown")
    public void clickOnTheCategoriesDropdown() {
        header.clickCategoriesDropdown();
    }

    @Then("Verify there are {int} categories presented in the Categories Dropdown")
    public void verifyThereAreCategoriesPresentedInTheCategoriesDropdown(int numberOfExpectedCategories) {
        Assert.assertEquals(numberOfExpectedCategories, header.getNumberOfCategories());
    }

    @And("Verify the Categories presented are {string}")
    public void verifyTheCategoriesPresentedAre(String expectedCategories) {
        List<String> actualCategories = header.getCategoriesPresented();

        List<String> expectedCategoriesAsList = Arrays.asList(expectedCategories.split(","));

        Assert.assertTrue(actualCategories.size() == expectedCategoriesAsList.size() && actualCategories.containsAll(expectedCategoriesAsList));
    }

    @And("Populate search field with {string}")
    public void populateSearchField(String keyword){
        header.populateSearchField(keyword);
    }

    @And("Click the search button")
    public void clickTheSearchButton() {
        header.clickSearchButton();
    }

    @Then("Verify {string} item is added to the cart in the header")
    public void verifyItemIsAddedToTheCartInTheHeader(String numberOfItemsAdded) {
        Assert.assertEquals(numberOfItemsAdded, header.getNumberOfItemsInCart());
    }

    @And("CLick Checkout button")
    public void clickCheckoutButton() {
        header.clickCheckOutButton();
    }

    @And("Click Contact us")
    public void clickContactsUs() {
        header.clickContactUsButton();
    }
}

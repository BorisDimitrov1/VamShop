package step_definitions.common;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import page_objects.common.Header;


public class HeaderStepDefinitions {

    private Header header = new Header();



    @Then("Verify the phone in the header is {string}")
    public void verifyThatThePhoneInTheHeaderIs(String expectedPhone) {
        header.verifyPhone(expectedPhone);
    }

    @And("Verify the Twitter link in the header leads to {string}")
    public void verifyTheTwitterLinkInTheHeaderIs(String expectedLink) {
        header.verifyTwitterLink(expectedLink);
    }

    @And("Verify the Facebook link in the header leads to {string}")
    public void verifyTheFacebookLinkInTheHeaderIs(String expectedLink) {
        header.verifyFacebookLink(expectedLink);
    }

    @And("Verify the Contact us link in the header leads to {string}")
    public void verifyTheContactUsLinkInTheHeaderIs(String expectedLink) {
        header.verifyContactUsLink(expectedLink);
    }

    @And("Click on the categories dropdown")
    public void clickOnTheCategoriesDropdown() {
        header.clickCategoriesDropdown();
    }

    @Then("Verify there are {int} categories presented in the Categories Dropdown")
    public void verifyThereAreCategoriesPresentedInTheCategoriesDropdown(int numberOfExpectedCategories) {
        header.verifyNumberOfCategories(numberOfExpectedCategories);

    }

    @And("Verify the Categories presented are {string}")
    public void verifyTheCategoriesPresentedAre(String expectedCategories) {
        header.verifyCategoriesPresented(expectedCategories);
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
        header.verifyNumberOfItemsInCart(numberOfItemsAdded);
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

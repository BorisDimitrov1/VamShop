package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import page_objects.ResultsPage;

public class ResultsStepDefinitions {

    private ResultsPage resultPage = new ResultsPage();

    @Then("Verify {int} result is presented in the results page")
    public void verifyResultIsPresentedInTheSearchResultsPage(int expectedNumberOfResults) {
        Assert.assertEquals(expectedNumberOfResults, resultPage.getResultsCount());
    }

    @And("Verify the title of the presented result is {string}")
    public void verifyTheTitleOfThePresentedResultIs(String expectedTitle) {
        Assert.assertEquals(expectedTitle, resultPage.getSearchResultTitle());

    }

    @And("Click on Buy button for the first presented result")
    public void clickOnBuyButtonForTheFirstPresentedResult() {
        resultPage.clickBuyButtonForTheFirstResult();
    }
}

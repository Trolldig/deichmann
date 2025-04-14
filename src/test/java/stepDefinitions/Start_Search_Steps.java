package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.Base_PO;
import pageObject.Start_Search_PO;

public class Start_Search_Steps extends Base_PO {

    private Start_Search_PO start_search_po;

    public Start_Search_Steps(Start_Search_PO start_search_po) {
        this.start_search_po = start_search_po;
    }

    @Given("I access the homepage")
    public void i_access_the_homepage() {
        start_search_po.navigateTo_Homepage();
    }

    @When("I click the search bar")
    public void i_click_the_search_bar() {
        start_search_po.clickOn_Search_Bar();
    }

    @And("I enter a search term")
    public void i_enter_a_search_term() {
        start_search_po.enterUnique_Text();
    }
    @And("I select a category")
    public void i_select_a_category() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @And("I click on the first suggestion")
    public void i_click_on_the_first_suggestion() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("I should be presented with the search result page")
    public void i_should_be_presented_with_the_search_result_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}

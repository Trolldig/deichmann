package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.Base_PO;
import pageObject.Header_PO;
import pageObject.Search_PO;

public class Start_Search_Steps extends Base_PO {

    private Header_PO headerPO;
    private Search_PO searchPO;

    public Start_Search_Steps(Header_PO header_po) {
        this.headerPO = header_po;
        this.searchPO = new Search_PO();
    }

    @Given("I access the homepage")
    public void i_access_the_homepage() {
        searchPO.navigateTo_Homepage();
    }

    @When("I click the search bar")
    public void i_click_the_search_bar() {
        headerPO.clickOn_Search_Bar();
    }

    @And("I enter a search term")
    public void i_enter_a_search_term() {
        headerPO.enterUnique_Text();
    }
    @And("I enter a specific search term {string}")
    public void i_enter_a_specific_search_term(String searchTerm) {
        headerPO.enterSpecific_Text(searchTerm);
    }
    @And("I select a category")
    public void i_select_a_category() {
        headerPO.clickUnique_Category();
    }
    @And("I select a specific category {word}")
    public void i_select_a_specific_category(String category) {
        headerPO.clickSpecific_Category(category);
    }
    @And("I click on the first suggestion")
    public void i_click_on_the_first_suggestion() {
        headerPO.clickFirst_Suggestion();
    }
    @Then("I should be presented with the search result page")
    public void i_should_be_presented_with_the_search_result_page() {
        searchPO.validate_Search_Page_Is_Displayed();
    }

}

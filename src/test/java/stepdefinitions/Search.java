package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Search {

	@Given("user opens the Application")
	public void user_opens_the_application() {
	 
	}

	@When("user enters valid product {string} in search box field")
	public void user_enters_valid_product_in_search_box_field(String validProductText) {
	    
	}

	@And("user clicks on Search button")
	public void user_clicks_on_search_button() {
	   
	}

	@Then("user gets valid product displayed in search results")
	public void user_gets_valid_product_displayed_in_search_results() {
	    
	}

	@When("user enters invalid product {string} in search box field")
	public void user_enters_invalid_product_in_search_box_field(String invalidProductText) {
	    
	}

	@Then("user gets message of no product match")
	public void user_gets_message_of_no_product_match() {
	
	}

	@When("user does not enter any product in search box field")
	public void user_does_not_enter_any_product_in_search_box_field() {
	 
	}

}

package stepdefinitions;

import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {
	
	public WebDriver driver;

	@Given("user navigates to login page")
	public void user_navigates_to_login_page() {
		driver = DriverFactory.getDriver();
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Login")).click();
	}
	
	@When("user enters valid email address {string} into email field")
	public void user_enters_valid_email_address_into_email_field (String validemailText) {
		driver.findElement(By.id("input-email")).sendKeys(validemailText);
	}
	
	@And("user enters valid password {string} into password field")
	public void user_enters_valid_password_into_password_field(String validpasswordText) {
		driver.findElement(By.id("input-password")).sendKeys(validpasswordText);
	}
	
	@And("user clicks on Login button")
	public void user_clicks_on_login_button() {
	    driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
	}

	@Then("user gets successfully logged in")
	public void user_gets_successfully_logged_in() {
	   Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
	}

	@When("user enters invalid email address into email field")
	public void user_enters_invalid_email_address_into_email_field() {
		driver.findElement(By.id("input-email")).sendKeys(getEmailWithTimeStamp()); 
	}

	@When("user enters invalid password {string} into password field")
	public void user_enters_invalid_password_into_password_field(String invalidpasswordText) {
		driver.findElement(By.id("input-password")).sendKeys(invalidpasswordText);
	}

	@Then("user gets a warning message")
	public void user_gets_a_warning_message() {
	   Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText().contains("Warning: No match for E-Mail Address and/or Password."));
	}

	@When("user keeps email address field blank")
	public void user_keeps_email_address_field_blank() {
		driver.findElement(By.id("input-email")).sendKeys("");
	}

	@When("user keeps password field blank")
	public void user_keeps_password_field_blank() {
		driver.findElement(By.id("input-password")).sendKeys("");
	}
	
	private String getEmailWithTimeStamp() {
		Date date = new Date();
		String timeStamp = date.toString().replace(" ", "_").replace(":", "_");
		return "seleniumpanda" + timeStamp + "@gmail.com";
	}

}

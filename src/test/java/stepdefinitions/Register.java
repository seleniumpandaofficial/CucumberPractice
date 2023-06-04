package stepdefinitions;

import java.util.Date;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Register {
	public WebDriver driver;
	
	@Given("user navigates to Register Account page")
	public void user_navigates_to_register_account_page() {
	  driver = DriverFactory.getDriver();
	  driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-password")).sendKeys("Selenium@123");
		driver.findElement(By.id("input-confirm")).sendKeys("Selenium@123");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
	}
	
	@When("user enters the details into below fields")
	public void user_enters_the_details_into_below_fields(DataTable dataTable) {
	  Map<String, String> dataMap =  dataTable.asMap(String.class, String.class);
	  driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstname"));
	  driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastname"));
	  driver.findElement(By.id("input-email")).sendKeys(getEmailWithTimeStamp());
	  driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
	  driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
	  driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("confirmpassword"));
	}

	@When("user enters the details into below fields with duplicate email")
	public void user_enters_the_details_into_below_fields_with_duplicate_email(DataTable dataTable) {
	  Map<String, String> dataMap =  dataTable.asMap(String.class, String.class);
	  driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstname"));
	  driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastname"));
	  driver.findElement(By.id("input-email")).sendKeys(dataMap.get("emailid"));
	  driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
	  driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
	  driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("confirmpassword"));
	}
	

	
	private String getEmailWithTimeStamp() {
		Date date = new Date();
		String timeStamp = date.toString().replace(" ", "_").replace(":", "_");
		return "seleniumpanda" + timeStamp + "@gmail.com";
	}

	@And("user selects privacy policy checkbox")
	public void user_selects_privacy_policy_checkbox() {
	   driver.findElement(By.name("agree")).click();
	}

	@And("user clicks on continue button")
	public void user_clicks_on_continue_button() {
	   driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
	   
	}

	@Then("user account gets created successfully")
	public void user_account_gets_created_successfully() {
		Assert.assertEquals("Your Account Has Been Created!", driver.findElement(By.xpath("//div[@id = 'content']/h1")).getText());   
	}

	@And("user selects Yes for Newsletter")
	public void user_selects_yes_for_newsletter() {
	   driver.findElement(By.xpath("//input[@name='newsletter' and @value='1']")).click();
	   
	}

	@Then("user gets warning message")
	public void user_gets_warning_message() {
	  Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText().contains("Warning: E-Mail Address is already registered!")); 
	}

	@When("user does not enter any field")
	public void user_does_not_enter_any_field() {
	    
	}

	@Then("user gets warning message for every mandatory field")
	public void user_gets_warning_message_for_every_mandatory_field() {
	Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText().contains("Warning: You must agree to the Privacy Policy!"));    
	Assert.assertTrue(driver.findElement(By.xpath("//div[text() = 'First Name must be between 1 and 32 characters!']")).isDisplayed());
	Assert.assertTrue(driver.findElement(By.xpath("//div[text() = 'Last Name must be between 1 and 32 characters!']")).isDisplayed());
	Assert.assertTrue(driver.findElement(By.xpath("//div[text() = 'E-Mail Address does not appear to be valid!']")).isDisplayed());
	Assert.assertTrue(driver.findElement(By.xpath("//div[text() = 'Telephone must be between 3 and 32 characters!']")).isDisplayed());
	Assert.assertTrue(driver.findElement(By.xpath("//div[text() = 'Password must be between 4 and 20 characters!']")).isDisplayed());
	
	
	
	
	}


}

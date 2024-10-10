package stepdefinations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.openqa.selenium.*;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pages.*;
import utils.CommonUtils;

public class Register2 {

	WebDriver driver;
	private RegisterPage registerPage;
	private AccountSuccessPage accountSuccessPage;
	private CommonUtils commonUtils;
	
	@Given("User navigates to Register Account page")
	public void user_navigates_to_register_account_page() {

		driver = DriverFactory.getDriver();
		HomePage homePage = new HomePage(driver);
		
		//driver.findElement(By.xpath("//span[text()='My Account']")).click();
		homePage.clickOnMyAccount();
		//driver.findElement(By.linkText("Register")).click();
		registerPage = homePage.selectRegisterOption();
	}
	
	@When("User enters the details into below fields")
	public void user_enters_the_details_into_below_fields(DataTable dataTable) {
		
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		
		registerPage.enterFirstName(dataMap.get("firstName"));
		registerPage.enterLastName(dataMap.get("lastName"));
		commonUtils = new CommonUtils();
		registerPage.enterEmailAddress(commonUtils.getEmailWithTimeStamp());
		registerPage.enterTelephoneNumber(dataMap.get("telephone"));
		registerPage.enterPassword(dataMap.get("password"));
		registerPage.enterConfirmPassword(dataMap.get("password"));
	}
	
	@When("User enters the details into below fields with a duplicate email")
	public void user_enters_the_details_into_below_fields_with_a_duplicate_email(DataTable dataTable) {
		
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);

		registerPage.enterFirstName(dataMap.get("firstName"));
		registerPage.enterLastName(dataMap.get("lastName"));
		registerPage.enterEmailAddress(dataMap.get("email"));
		registerPage.enterTelephoneNumber(dataMap.get("telephone"));
		registerPage.enterPassword(dataMap.get("password"));
		registerPage.enterConfirmPassword(dataMap.get("password"));
	}
	
	@And("User selects Privacy Policy")
	public void user_selects_privacy_policy() {
		
		registerPage.selectPrivacyPolicy();
	}
	
	@And("User clicks on Continue button")
	public void user_clicks_on_continue_button() {
		
		accountSuccessPage = registerPage.clickOnContinueButton();
	}
	
	@Then("User account should get created successfully")
	public void user_account_should_get_created_successfully() {
		
		assertEquals("Your Account Has Been Created!", accountSuccessPage.getPageHeading());
	}
	
	@And("User selects Yes for Newsletter")
	public void user_selects_yes_for_newsletter() {
		
		registerPage.selectYesNewsletterOption();
	}
	
	@Then("User should get a proper warning message about duplicate email")
	public void user_should_get_a_proper_warning_message_about_duplicate_email() {
		
		assertTrue(registerPage.getWarningMessageText().contains("Warning: E-Mail Address is already registered!"));
	}
	
	@When("User dont enter any details into fields")
	public void user_dont_enter_any_details_into_fields() {
		
		registerPage.enterFirstName("");
		registerPage.enterLastName("");
		registerPage.enterEmailAddress("");
		registerPage.enterTelephoneNumber("");
		registerPage.enterPassword("");
		registerPage.enterConfirmPassword("");
	}
	
	@Then("User should get a proper warning messages for every mandatory field")
	public void user_should_get_a_proper_warning_messages_for_every_mandatory_field() {

		assertTrue(registerPage.getWarningMessageText().contains("Warning: You must agree to the Privacy Policy!"));
		assertEquals("First Name must be between 1 and 32 characters!", registerPage.getFirstNameWarningText());
		assertEquals("Last Name must be between 1 and 32 characters!", registerPage.getLastNameWarningText());
		assertEquals("E-Mail Address does not appear to be valid!", registerPage.getEmailAddressWarningText());
		assertEquals("Telephone must be between 3 and 32 characters!", registerPage.getTelephoneWarningText());
		assertEquals("Password must be between 4 and 20 characters!", registerPage.getPasswordWarningText());
	}
		
}

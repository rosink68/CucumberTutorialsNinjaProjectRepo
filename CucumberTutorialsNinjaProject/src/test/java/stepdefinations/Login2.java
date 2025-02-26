package stepdefinations;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.*;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.*;
import utils.CommonUtils;

public class Login2 {
	
	WebDriver driver;
	private LoginPage loginPage;
	private AccountPage accountPage;
	private CommonUtils commonUtils;
	
	@Given("User navigates to Login page")
	public void user_navigates_to_login_page() {

		driver = DriverFactory.getDriver();
		HomePage homePage = new HomePage(driver);
		
		//driver.findElement(By.xpath("//span[text()='My Account']")).click();
		homePage.clickOnMyAccount();
		//driver.findElement(By.linkText("Login")).click();		
		loginPage = homePage.selectLoginOption();
	}

	@When("^User enters valid email address (.+) into email field$")
	public void user_enters_valid_email_address_into_email_field(String emailText) {
		
		//driver.findElement(By.id("input-email")).sendKeys(emailText);
		loginPage.enterEmailAddress(emailText);
	}

	@And("^User enters valid password (.+) into password field$")
	public void user_enters_valid_password_into_password_field(String passwordText) {

		loginPage.enterPassword(passwordText);
	}

	@And("User clicks on Login button")
	public void user_clicks_on_login_button() {

		accountPage = loginPage.clickOnLoginButton();
	}

	@Then("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() {

		assertTrue(accountPage.displayStatusOfEditYourAccountInformationOption());
	}

	@When("User enters invalid email address into email field")
	public void user_enters_invalid_email_address_into_email_field() {
		
		commonUtils = new CommonUtils();
		loginPage.enterEmailAddress(commonUtils.getEmailWithTimeStamp());
	}

	@And("User enters invalid password {string} into password field")
	public void user_enters_invalid_password_into_password_field(String invalidPasswordText) {

		loginPage.enterPassword(invalidPasswordText);
	}

	@Then("User should get a proper warning message about credentials mismatch")
	public void user_should_get_a_proper_warning_message_about_credentials_mismatch() {

		assertTrue(loginPage.getWarningMessageText().contains("Warning: No match for E-Mail Address and/or Password."));
	}

	@When("User dont enter email address into email field")
	public void user_dont_enter_email_address_into_email_field() {
		
		loginPage.enterEmailAddress("");
	}

	@And("User dont enter password into password field")
	public void user_dont_enter_password_into_password_field() {

		loginPage.enterPassword("");
	}
}

package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class RegisterPage {

	WebDriver driver;
	private ElementUtils elementUtils;
	
	public RegisterPage(WebDriver driver) {
		
		this.driver =driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}

	@FindBy(id = "input-firstname")
	private WebElement firstNameField;

	@FindBy(id = "input-lastname")
	private WebElement lastNameField;

	@FindBy(id = "input-email")
	private WebElement emailField;
	
	@FindBy(id = "input-telephone")
	private WebElement telephoneField;

	@FindBy(id = "input-password")
	private WebElement passwordField;

	@FindBy(id = "input-confirm")
	private WebElement passwordConfirmField;
	
	@FindBy(name = "agree")
	private WebElement privacyPolicyOption;
	
	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath = "//input[@name='newsletter'] [@value='1']")
	private WebElement yesNewsletterOption;
	
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement warningMessage;
	
	@FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarning;

	@FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWarning;

	@FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
	private WebElement emailWarning;

	@FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneWarning;

	@FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarning;

	
	public void enterFirstName(String firstNameText) {
		
		//firstNameField.sendKeys(firstNameText);
		elementUtils.typeTextIntoElement(firstNameField, firstNameText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void enterLastName(String lastNameText) {
		
		//lastNameField.sendKeys(lastNameText);
		elementUtils.typeTextIntoElement(lastNameField, lastNameText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void enterEmailAddress(String emailText) {
		
		//emailField.sendKeys(emailText);
		elementUtils.typeTextIntoElement(emailField, emailText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void enterTelephoneNumber(String telephoneText) {
		
		//telephoneField.sendKeys(telephoneText);
		elementUtils.typeTextIntoElement(telephoneField, telephoneText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void enterPassword(String passwordText) {
		
		//passwordField.sendKeys(passwordText);
		elementUtils.typeTextIntoElement(passwordField, passwordText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void enterConfirmPassword(String passwordText) {
		
		//passwordConfirmField.sendKeys(passwordText);
		elementUtils.typeTextIntoElement(passwordConfirmField, passwordText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public void selectPrivacyPolicy() {
		
		//privacyPolicyOption.click();
		elementUtils.clickOnElement(privacyPolicyOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	
	public AccountSuccessPage clickOnContinueButton() {
		
		//continueButton.click();
		elementUtils.clickOnElement(continueButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new AccountSuccessPage(driver);
	}

	public void selectYesNewsletterOption() {
		
		//yesNewsletterOption.click();
		elementUtils.clickOnElement(yesNewsletterOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public String getWarningMessageText() {
		
		//return warningMessage.getText();
		return elementUtils.getTextFromElement(warningMessage, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public String getFirstNameWarningText() {
		
		//return firstNameWarning.getText();
		return elementUtils.getTextFromElement(firstNameWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);		
	}
	
	public String getLastNameWarningText() {
		
		//return lastNameWarning.getText();
		return elementUtils.getTextFromElement(lastNameWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public String getEmailAddressWarningText() {
		
		//return emailWarning.getText();
		return elementUtils.getTextFromElement(emailWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public String getTelephoneWarningText() {
		
		//return telephoneWarning.getText();
		return elementUtils.getTextFromElement(telephoneWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public String getPasswordWarningText() {
		
		//return passwordWarning.getText();
		return elementUtils.getTextFromElement(passwordWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
}

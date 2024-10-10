package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import utils.CommonUtils;
import utils.ElementUtils;

public class LoginPage {

	WebDriver driver;
	private ElementUtils elementUtils;

	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(id = "input-email")
	private WebElement emailField;
	
	@FindBy(id = "input-password")
	private WebElement passwordField;
	
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement warningMessage;
	
	public void enterEmailAddress(String emailText) {
	
		//emailField.sendKeys(emailText);
		elementUtils.typeTextIntoElement(emailField, emailText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void enterPassword(String passwordText) {
		
		//passwordField.sendKeys(passwordText);
		elementUtils.typeTextIntoElement(passwordField, passwordText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public AccountPage clickOnLoginButton() {
		
		//loginButton.click();
		elementUtils.clickOnElement(loginButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new AccountPage(driver);
	}
	
	public String getWarningMessageText() {
		
		//return warningMessage.getText();
		return elementUtils.getTextFromElement(warningMessage, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
}

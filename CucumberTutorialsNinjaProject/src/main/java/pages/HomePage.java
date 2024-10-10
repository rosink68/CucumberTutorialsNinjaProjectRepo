package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;


public class HomePage {

	WebDriver driver;
	private ElementUtils elementUtils;
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccoutDropMenu;
	
	@FindBy(linkText = "Login")
	private WebElement loginOption;
	
	@FindBy(linkText = "Register")
	private WebElement registerOption;

	@FindBy(name = "search")
	private WebElement searchBoxField;
	
	@FindBy(xpath = "//button[contains(@class,'btn-default')]")
	private WebElement searchButton;

	
	public void clickOnMyAccount() {
		
		//myAccoutDropMenu.click();
		// mit ElementUtils (30 s impliziertes Warten)
		elementUtils.clickOnElement(myAccoutDropMenu, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public LoginPage selectLoginOption() {
		
		//loginOption.click();
		elementUtils.clickOnElement(loginOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new LoginPage(driver);
	}
	
	public RegisterPage selectRegisterOption() {
		
		//registerOption.click();
		elementUtils.clickOnElement(registerOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new RegisterPage(driver);
	}
	
	public void enterProductIntoSearchBoxField(String productText) {
		
		//searchBoxField.sendKeys(productText);
		elementUtils.typeTextIntoElement(searchBoxField, productText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public SearchResultsPage clickOnSearchButton() {
		
		//searchButton.click();
		elementUtils.clickOnElement(searchButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new SearchResultsPage(driver);
	}
}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

import utils.CommonUtils;
import utils.ElementUtils;

public class AccountPage {

	WebDriver driver;
	private ElementUtils elementUtils;
	
	public AccountPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}

	@FindBy(linkText = "Edit your account information")
	private WebElement editYourAccountInformationOption;
	
	public boolean displayStatusOfEditYourAccountInformationOption () {
		
		//return editYourAccountInformationOption.isDisplayed();
		return elementUtils.displayStatusOfElement(editYourAccountInformationOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
}

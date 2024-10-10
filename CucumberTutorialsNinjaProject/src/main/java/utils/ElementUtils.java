package utils;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

public class ElementUtils {

	WebDriver driver;
	
	public ElementUtils(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public void clickOnElement(WebElement element, long durationInSeconds) {
		
		WebElement webElement = waitForElement(element, durationInSeconds);
		webElement.click();
	}
	
	public void typeTextIntoElement(WebElement element, String textToBeTyped, long durationInSeconds) {

		WebElement webElement = waitForElement(element, durationInSeconds);
		// erst ins WebElement klicken (aktivieren) ==> dann leeren ==> dann neuen Text reinschreiben
		webElement.click();
		webElement.clear();
		webElement.sendKeys(textToBeTyped);
	}
	
	public void selectOptionInDropdown(WebElement element, String dropDownOption, long durationInSeconds) {

		WebElement webElement = waitForElement(element, durationInSeconds);
		Select select = new Select(webElement);
		select.selectByVisibleText(dropDownOption);
	}
	
	public String getTextFromElement(WebElement element, long durationInSeconds) {
	
		WebElement webElement = waitForElement(element, durationInSeconds);
		return webElement.getText();
	}
	
	public WebElement waitForElement(WebElement element, long durationInSeconds) {

		WebElement webElement = null;
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		return webElement;
	}
	
	public void acceptAlert(long durationInSeconds) {

		Alert alert = waitForAlert(durationInSeconds);
		alert.accept();
	}
	
	public void dismissAlert(long durationInSeconds) {

		Alert alert = waitForAlert(durationInSeconds);
		alert.dismiss();
	}
	
	public Alert waitForAlert(long durationInSeconds) {
		
		Alert alert = null;
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			alert = wait.until(ExpectedConditions.alertIsPresent());
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		return alert;
	}
	
	public void mouseHoverAndClick(WebElement element, long durationInSeconds) {

		WebElement webElement = waitForVisibilityOfElement(element, durationInSeconds);
		Actions actions = new Actions(driver);
		actions.moveToElement(webElement).click().build().perform();
	}
	
	public void javaScriptClick(WebElement element, long durationInSeconds) {

		WebElement webElement = waitForVisibilityOfElement(element, durationInSeconds);
		JavascriptExecutor jse =((JavascriptExecutor)driver);
		// das 1. Element ([0]) klicken
		jse.executeScript("arguments[0].click();", webElement);
	}
	
	public void javaScriptType(WebElement element, String textToBeTyped, long durationInSeconds) {

		WebElement webElement = waitForVisibilityOfElement(element, durationInSeconds);
		JavascriptExecutor jse =((JavascriptExecutor)driver);
		// der Wert vom 1. Element ([0]) 
		jse.executeScript("arguments[0].value='" + textToBeTyped + "');", webElement);
	}
	
	public boolean displayStatusOfElement(WebElement element, long durationInSeconds) {

		try {
			WebElement webElement = waitForVisibilityOfElement(element, durationInSeconds);
			return webElement.isDisplayed();
			
		} catch (Throwable e) {
			return false;
		}		
	}

	public WebElement waitForVisibilityOfElement(WebElement element, long durationInSeconds) {

		WebElement webElement = null;
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.visibilityOf(element));
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		return webElement;
	}

}

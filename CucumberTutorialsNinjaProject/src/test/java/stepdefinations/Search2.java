package stepdefinations;

import org.openqa.selenium.*;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.SearchResultsPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Search2 {

	WebDriver driver;
	private HomePage homePage;
	private SearchResultsPage searchResultsPage;

	@Given("User opens the Application")
	public void user_opens_the_application() {

		driver = DriverFactory.getDriver();
	}

	@When("User enters valid product {string} into Search box field")
	public void user_enters_valid_product_into_search_box_field(String validProductText) {

		homePage = new HomePage(driver);
		//driver.findElement(By.name("search")).sendKeys(validProductText);
		homePage.enterProductIntoSearchBoxField(validProductText);
	}

	@And("User clicks on Search button")
	public void user_clicks_on_search_button() {

		searchResultsPage = homePage.clickOnSearchButton();
	}

	@Then("User should get valid product displayed in search results")
	public void user_should_get_valid_product_displayed_in_search_results() {

		assertTrue(searchResultsPage.displayStatusOfValidProduct());
	}

	@When("User enters invalid product {string} into Search box field")
	public void user_enters_invalid_product_into_search_box_field(String invalidProductText) {

		homePage = new HomePage(driver);
		homePage.enterProductIntoSearchBoxField(invalidProductText);
	}

	@Then("User should get a message about no product matching")
	public void user_should_get_a_message_about_no_product_matching() {

		assertEquals("There is no product that matches the search criteria.", searchResultsPage.getMessageText());
	}

	@When("User dont enter any product name into Search box field")
	public void user_dont_enter_any_product_name_into_search_box_field() {

		homePage = new HomePage(driver);
	}

}

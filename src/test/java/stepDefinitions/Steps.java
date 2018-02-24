package stepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.*;
import managers.FileReaderManager;
import managers.PageObjectManager;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.ProductListingPage;

public class Steps {

	public WebDriver driver;
	HomePage home;
	ProductListingPage productListingPage;
	CartPage cartPage;
	CheckoutPage checkoutPage;
	PageObjectManager pageObjectManager;
	
	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
		pageObjectManager = new PageObjectManager(driver);
	}

	@When("^he search for \"(.*)\"$")
	public void he_search_for(String product)  {
		home = pageObjectManager.getHomePage();
		home.perform_Search(product);
	}

	@When("^choose to buy the first item$")
	public void choose_to_buy_the_first_item() {
		productListingPage = pageObjectManager.getProductListingPage();
		productListingPage.select_Product(0);
		productListingPage.clickOn_AddToCart();		
	}

	@When("^moves to checkout from mini cart$")
	public void moves_to_checkout_from_mini_cart(){
		cartPage = pageObjectManager.getCartPage();
		cartPage.clickOn_Cart();
		cartPage.clickOn_ContinueToCheckout();	
	}
	
	@When("^enter personal details on checkout page$")
	public void enter_personal_details_on_checkout_page() throws InterruptedException {
		checkoutPage = pageObjectManager.getCheckoutPage();
		checkoutPage.fill_PersonalDetails();	
	}
	
	@When("^select same delivery address$")
	public void select_same_delivery_address() throws InterruptedException{
		checkoutPage.check_ShipToDifferentAddress(false);
	}
	
	@When("^select payment method as \"([^\"]*)\" payment$")
	public void select_payment_method_as_payment(String arg1){
		checkoutPage.select_PaymentMethod("CheckPayment");
	}

	@When("^place the order$")
	public void place_the_order() throws InterruptedException {
		checkoutPage.check_TermsAndCondition(true);
		checkoutPage.clickOn_PlaceOrder();
		driver.quit();
	}	
}
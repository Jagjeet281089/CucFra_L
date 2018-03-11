package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.When;


import pageObjects.CartPage;


public class CartPageSteps {

	CartPage cartPage;
	TestContext testContext;
	
	public CartPageSteps(TestContext context) {
		testContext = context;
		cartPage = testContext.getPageObjectManager().getCartPage();
	}
	
	@When("^moves to checkout from mini cart$")
	public void moves_to_checkout_from_mini_cart(){
		cartPage.clickOn_Cart();
		cartPage.clickOn_ContinueToCheckout();	
	}
	
}

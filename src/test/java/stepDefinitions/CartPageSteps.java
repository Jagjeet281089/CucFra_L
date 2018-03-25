package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;


import pageObjects.CartPage;


public class CartPageSteps {

	CartPage cartPage;
	TestContext testContext;
	
	public CartPageSteps(TestContext context) {
		testContext = context;
		cartPage = testContext.getPageObjectManager().getCartPage();
	}

	@Given("^User (?:is on|opens|opens the) Cart Page and moves to place order$")
	public void moves_to_checkout_from_mini_cart(){
		cartPage.navigateTo_CartPage();
		cartPage.clickOn_PlaceOrder();
	}



}

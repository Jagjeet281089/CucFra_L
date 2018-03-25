package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.When;
import pageObjects.ProductListingPage;

public class ProductPageSteps {

	
	ProductListingPage productListingPage;
	TestContext testContext;


	public ProductPageSteps(TestContext context) {
		testContext = context;
		productListingPage = testContext.getPageObjectManager().getProductListingPage();
	}
	
	@When("^User (?:choose|chooses) to buy the product with name \"(.*)\"$")
	public void choose_to_buy_the_item(String prodName) {
		productListingPage.selectProductWithText(prodName);
		productListingPage.addProductTotheCart();
	}
}

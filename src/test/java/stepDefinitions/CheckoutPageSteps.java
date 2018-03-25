package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.And;
import managers.FileReaderManager;
import pageObjects.CheckoutPage;
import testDataTypes.Customer;

public class CheckoutPageSteps {
	
	CheckoutPage checkoutPage;	
	TestContext testContext;
	
	
	public CheckoutPageSteps(TestContext context) {
		testContext = context;
		checkoutPage = testContext.getPageObjectManager().getCheckoutPage();
	}


	@And("^User enters personal details on checkout page$")
	public void userEntersPersonalDetailsOnCheckoutPage() throws Throwable {
		checkoutPage.fillAllFormDetailsDemo();
	}

	@And("^enter \"([^\"]*)\" personal details on checkout page$")
	public void enterPersonalDetailsOnCheckoutPage(String customerName) throws Throwable {
		Customer customer = FileReaderManager.getInstance().getJsonReader().getCustomerByName(customerName);
		checkoutPage.enterAddressDetailsFor(customer);
	}


	/*@When("^enter personal details on checkout page$")
	public void enter_personal_details_on_checkout_page() throws InterruptedException {
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
	}*/

}
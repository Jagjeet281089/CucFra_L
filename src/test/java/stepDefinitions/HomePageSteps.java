package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.HomePage;

public class HomePageSteps {

	HomePage home;
	TestContext testContext;
	
	public HomePageSteps(TestContext context) {
		testContext = context;
		home = testContext.getPageObjectManager().getHomePage();
	}
	
	@Given("^User (?:is on|opens| opens the) Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
		home.navigateTo_HomePage();
	}
	
	@Then("^User (?:see|sees|saw) the Search Bar$")
	public void user_see_search()  {
		home.check_HeaderSearchBar();
	}	
	
	@When("^User (?:search|searches) for \"(.*)\"$")
	public void he_search_for(String product)  {
		home.perform_Search(product);
	}
	
	@Then("^User (?:see|sees|saw) the Login popup$")
	public void user_sees_the_Login_popup() throws Throwable {
	    home.check_LoginPopupLoads();
	}
	
	@Then("^User (?:close|closes) the Login popup$")
	public void user_close_the_Login_popup() throws Throwable {
	    home.closeLoginPopup();
	}

	@And("^User Login via popup by providing mobile as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void userLoginViaPopupByProvidingMobileAsAndPasswordAs(String mobile, String password) throws Throwable {
		home.loginOnPopup(mobile,password);
	}
}
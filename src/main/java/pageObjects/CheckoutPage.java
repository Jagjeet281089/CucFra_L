package pageObjects;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import testDataTypes.Customer;

public class CheckoutPage {
	
	WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(driver, this);
	}


	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Delivery Address')]/../../button[contains(text(),'Change')]")
	private WebElement button_AddressChange;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'EDIT')]")
	private WebElement button_editAddress;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Save and Deliver Here')]")
	private WebElement button_saveAndDeliverHere;

	@FindBy(how = How.NAME, using = "name")
	private WebElement txtbx_Name;
	
	@FindBy(how = How.NAME, using = "phone")
	private WebElement txtbx_PhoneNumber;
	
	@FindBy(how = How.NAME, using = "pincode")
	private WebElement txtbx_Pincode;

	@FindBy(how = How.NAME, using = "addressLine2")
	private WebElement txtbx_Locality;

	@FindBy(how = How.NAME, using = "addressLine1")
	private WebElement txtbx_Address;

	@FindBy(how = How.NAME, using = "city")
	private WebElement txtbx_City;

	@FindBy(how = How.NAME, using = "state")
	private WebElement drpdwn_State;



/*	@FindBy(how = How.CSS, using = "#ship-to-different-address-checkbox")
	private WebElement chkbx_ShipToDifferetAddress;
	
	@FindAll(@FindBy(how = How.CSS, using = "ul.wc_payment_methods li"))
	private List<WebElement> paymentMethod_List;	*/


	



	public void enter_Name(String name) {
		txtbx_Name.sendKeys(name);
	}

	public void enter_Phone(String phone) {
		txtbx_PhoneNumber.sendKeys(phone);
	}
	
	public void enter_Pincode(String pincode) {
		txtbx_Pincode.sendKeys(pincode);
	}

	public void enter_Locality(String locality) {
		txtbx_Locality.sendKeys(locality);
	}

	public void enter_Address(String address) {
		txtbx_Address.sendKeys(address);
	}
	
	public void enter_City(String city) {
        txtbx_City.clear();
	    txtbx_City.sendKeys(city);
	}

	public void select_State(String stateName) {
		Select countryDropDown = new Select(drpdwn_State);
		countryDropDown.selectByValue(stateName);
	}

	public void addressType(String type){
		if(type.equalsIgnoreCase("home")){
			driver.findElement(By.xpath("//span[contains(text(),'Home (All day delivery)')]")).click();
		}
		if(type.equalsIgnoreCase("work")){
			driver.findElement(By.xpath("//span[contains(text(),'Work (Delivery between 10 AM - 5 PM)")).click();
		}
	}


	/*@FindAll(@FindBy(how = How.CSS, using = "#select2-drop ul li"))
	private List<WebElement> country_List;
	public void select_County(String countyName) {
		drpdwn_CountyDropDownArrow.click();
		try { Thread.sleep(2000);}
		catch (InterruptedException e) {}

		for(WebElement county : country_List){
			if(county.getText().equals(countyName)) {
				county.click();	
				try { Thread.sleep(3000);}
				catch (InterruptedException e) {}
				break;
			}
		}
	}*/
	
	/*public void select_PaymentMethod(String paymentMethod) {
		if(paymentMethod.equals("CheckPayment")) {
			paymentMethod_List.get(0).click();
		}else if(paymentMethod.equals("Cash")) {
			paymentMethod_List.get(1).click();
		}else {
			new Exception("Payment Method not recognised : " + paymentMethod);
		}
		try { Thread.sleep(3000);}
		catch (InterruptedException e) {}

	}

	public void check_TermsAndCondition(boolean value) {
		if(value) chkbx_AcceptTermsAndCondition.click();
	}

	public void clickOn_PlaceOrder() {
		btn_PlaceOrder.submit();
	}*/


	public void clearAllFormDetails() {
		txtbx_Name.clear();
		txtbx_PhoneNumber.clear();
		txtbx_Pincode.clear();
		txtbx_Locality.clear();
		txtbx_Address.clear();
		txtbx_City.clear();
		select_State("Andaman & Nicobar Islands");
	}


	public void fillAllFormDetailsDemo() {
		enter_Name("Automation");
		enter_Phone("8882381116");
		enter_Pincode("226004");
		enter_Locality("Aishbagh");
		enter_Address("45/4, Aishbagh Malviya Nagar, Lucknow");
		enter_City("Lucknow");
		select_State("Uttar Pradesh");
		addressType("home");
	}

	public void fill_PersonalDetails(Customer customer) {
		enter_Name(customer.name);
		enter_Phone(customer.phoneNumber);
		enter_Pincode(customer.pinCode);
		enter_Locality(customer.locality);
		enter_Address(customer.address.address);
		enter_City(customer.address.city);
		select_State(customer.address.state);
		addressType(customer.addressType);
	}


	public void enterAddressDetailsFor(Customer customerName) {

		try {
			if (button_AddressChange.isDisplayed()) {
				button_AddressChange.click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
				}
				button_editAddress.click();
				clearAllFormDetails();
				fill_PersonalDetails(customerName);
				button_saveAndDeliverHere.click();
			}

		} catch (Exception e) {
			System.out.println("No old address exists.");
			try {
				fill_PersonalDetails(customerName);
				button_saveAndDeliverHere.click();
			} catch (Exception e1) {
				System.out.println("Adding new address.");
			}
		}
	}
}
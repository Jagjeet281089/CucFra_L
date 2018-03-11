package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import managers.FileReaderManager;

public class HomePage {
	WebDriver driver;
	
	@FindBy(how = How.XPATH, using = ".//span[contains(text(),'Enter Email/Mobile number')]") 
	private WebElement Loginpopup_EmailField;
	
	@FindBy(how = How.XPATH, using = ".//button[contains(text(),'✕')]") 
	private WebElement Loginpopup_CloseButton;
	
	@FindBy(how = How.XPATH, using = ".//a[contains(text(),'Login & Signup') and @data-reactid='29']") 
	private WebElement Header_LoginLink;
	
	@FindBy(how = How.NAME ,using = "q") 
	private WebElement Header_SearchBar;
	
	@FindBy(how = How.CSS, using = "button.single_add_to_cart_button") 
	private WebElement btn_AddToCart;
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void perform_Search(String search) {
		driver.navigate().to(FileReaderManager.getInstance().getConfigReader().getApplicationUrl()+"/?s=" + search + "&post_type=product");
	}
	
	public void navigateTo_HomePage() {
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
	}
	
	public void check_LoginPopupLoads() {
		Loginpopup_EmailField.getSize();
	}
	
	public void closeLoginPopup() {
		Loginpopup_CloseButton.click();
	}
	
	public void check_HeaderSearchBar() {
		Header_SearchBar.getSize();
	}
}
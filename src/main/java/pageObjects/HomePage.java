package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import managers.FileReaderManager;

public class HomePage {
	WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "//label/span[contains(text(),'Enter Email/Mobile number')]/../preceding-sibling::input[@type='text' and @autocomplete='off']")
	private WebElement Loginpopup_EmailField;

	@FindBy(how = How.XPATH, using = "//input[@type='password']")
	private WebElement Loginpopup_pwdField;

	@FindBy(how = How.XPATH, using = "//button[@type='submit']/span[contains(text(),'Login')]")
	private WebElement Loginpopup_loginButton;



	@FindBy(how = How.XPATH, using = ".//button[contains(text(),'✕')]")
	private WebElement Loginpopup_CloseButton;
	
	@FindBy(how = How.XPATH, using = ".//a[contains(text(),'Login & Signup') and @data-reactid='29']") 
	private WebElement Header_LoginLink;
	
	@FindBy(how = How.NAME ,using = "q") 
	private WebElement Header_SearchBar;
	

	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void navigateTo_HomePage() {
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
		System.out.println("Navigated to Home Page.");
	}

	public void perform_Search(String search) {
	    Header_SearchBar.sendKeys(search);
        Header_SearchBar.sendKeys(Keys.ENTER);
		System.out.println("Search perform complete.");
	}

	public void loginOnPopup(String mobileNumberText, String passwordText){
		Loginpopup_EmailField.sendKeys(mobileNumberText);
		Loginpopup_pwdField.sendKeys(passwordText);
		Loginpopup_loginButton.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Login completed.");

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
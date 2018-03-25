package pageObjects;

import managers.FileReaderManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	WebDriver driver;

	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Place Order')]")
	private WebElement btn_PlaceOrder;


	public void clickOn_PlaceOrder(){
		btn_PlaceOrder.click();
		try { Thread.sleep(5000);}
		catch (InterruptedException e) {}
		System.out.println("Place order clicked.");
	}

	public void navigateTo_CartPage() {
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl()+"/viewcart");
		System.out.print("Navigated to Cart Page.");
	}
	



	/*@FindBy(how = How.CSS, using = ".cart-button")
	private WebElement btn_Cart;
	public void clickOn_Cart() {
		btn_Cart.click();
	}*/
}
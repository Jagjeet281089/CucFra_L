package pageObjects;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProductListingPage {

	WebDriver driver;

	@FindBy(how = How.XPATH, using = "//ul[@class='row']/li[1]")
	private WebElement btn_AddToCart;


	public ProductListingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void selectProductWithText(String productName) {

		try {
			WebElement path1 = driver.findElement(By.xpath("//a[@rel='noopener noreferrer']/div/div/div[contains(text(),'" + productName + "')]"));
			if (path1.isDisplayed() == true) {
				path1.click();
				System.out.println("Path1 clicked");
			}
		} catch (Exception e) {

			try {
				WebElement path2 = driver.findElement(By.xpath("//a[@rel='noopener noreferrer' and @title = '" + productName + "']"));
				if (path2.isDisplayed() == true) {
					path2.click();
					System.out.println("Path2 clicked");
				}
			} catch (Exception e2) {
			}

		}

		System.out.println("Product clicking completed");
	}

	public void addProductTotheCart() {

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		switchToParentWindow();
		System.out.println("Switched to List window");
		SwitchToWindow(1);
		System.out.println("Switched to Prod window");
		btn_AddToCart.click();
		System.out.println("Cart button clicked");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Wait time complete");
		switchToParentWithChildClose();
		System.out.println("Switched back to Parent");
	}








	public Set<String> getWindowHandlens() {
		return driver.getWindowHandles();
	}

	public void SwitchToWindow(int index) {
		LinkedList<String> windowsId = new LinkedList<String>(getWindowHandlens());
		if (index < 0 || index > windowsId.size()) {
			throw new IllegalArgumentException("Invalid Index : " + index);
		}
		driver.switchTo().window(windowsId.get(index));
	}

	public void switchToParentWindow() {
		LinkedList<String> windowsId = new LinkedList<String>(getWindowHandlens());
		driver.switchTo().window(windowsId.get(0));
	}

	public void switchToParentWithChildClose() {
		LinkedList<String> windowsId = new LinkedList<String>(getWindowHandlens());
		for (int i = 1; i < windowsId.size(); i++) {
			driver.switchTo().window(windowsId.get(i));
			driver.close();
		}
		switchToParentWindow();
	}

}
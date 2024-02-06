package saucedemo.Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
	WebDriver driver;
	By SauceLabsOnesie=By.xpath("//button[@id='remove-sauce-labs-onesie']");
	By ContinueShopping=By.xpath("//button[@id='continue-shopping']");
	By Checkouts=By.xpath("//button[@id='checkout']");
	By CartIcon=By.xpath("//a[@class='shopping_cart_link']");
	public CartPage(WebDriver d) {
		driver=d;
	}
	public void RemoveFromCart()  {
		driver.findElement(SauceLabsOnesie).click();
	}
	public void ClickOnContinueShopping() {
		driver.findElement(ContinueShopping).click();
		driver.findElement(CartIcon).click();	
	} 
	public void ClickOnChekouts() {
		driver.findElement(Checkouts).click();
	}
}

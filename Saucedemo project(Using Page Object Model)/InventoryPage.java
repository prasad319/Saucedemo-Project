package saucedemo.Project;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage {
	WebDriver driver;
	By MenuBtn=By.id("react-burger-menu-btn");
	By AboutOption=By.id("about_sidebar_link");
	By ResetAppStateOption=By.id("reset_sidebar_link");
	By CloseMenuoption=By.xpath("//button[@id='react-burger-cross-btn']");
	By Dropdown=By.xpath("//select[@class='product_sort_container']");
	By SauceLabsBackpackProduct=By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");
	By SauceLabsBikeLight=By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']");
	By SauceLabsBoltTShirt=By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']");
	By SauceLabsFleeceJacket=By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']");
	By SauceLabsOnesie=By.xpath("//button[@id='add-to-cart-sauce-labs-onesie']");
	By TestallTheThingsTShirtRed=By.xpath("//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']");
	By CartIcon=By.xpath("//a[@class='shopping_cart_link']");
	public InventoryPage(WebDriver d) {
		driver=d;
	}
	public void ClickOnMenuBtn() {
		driver.findElement(MenuBtn).click();
		driver.findElement(AboutOption).click();
		driver.navigate().back();
		 try {
			 driver.findElement(MenuBtn).click();
		} catch (StaleElementReferenceException e) {
			 driver.findElement(MenuBtn);
			 driver.findElement(MenuBtn).click();
		}
		driver.findElement(ResetAppStateOption).click();	
	}
	public void ClickOnCloseMenuoption() {
		driver.findElement(CloseMenuoption).click();
	}
	public void ChangeFilter() {
		WebElement dropdown=driver.findElement(Dropdown);
		Select select = new Select(dropdown);
		select.selectByIndex(0);
		 try {
			 select.selectByIndex(1);
			
		} catch (StaleElementReferenceException e) {
			WebElement dropdown1=driver.findElement(Dropdown);
			Select select1 = new Select(dropdown1);
			select1.selectByIndex(1);	   
		}
		 try {
			 select.selectByIndex(2);
		} catch (StaleElementReferenceException e) {
			WebElement dropdown1=driver.findElement(Dropdown);
			Select select1 = new Select(dropdown1);
			select1.selectByIndex(2);
		}
		 try {
			 select.selectByIndex(3);
		} catch (StaleElementReferenceException e) {
			WebElement dropdown1=driver.findElement(Dropdown);
			Select select1 = new Select(dropdown1);
			select1.selectByIndex(3);
		}
	}
	public void AddToCart()  {
		driver.findElement(SauceLabsBackpackProduct).click();
		driver.findElement(SauceLabsBikeLight).click();
		driver.findElement(SauceLabsBoltTShirt).click();
		driver.findElement(SauceLabsFleeceJacket).click();
		driver.findElement(SauceLabsOnesie).click();
		driver.findElement(TestallTheThingsTShirtRed).click();
	}
	public void ClickOnCartIcon() {
		driver.findElement(CartIcon).click();
	}	
}

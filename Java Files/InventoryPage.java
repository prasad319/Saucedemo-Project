package saucedemo_Project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InventoryPage {
 ChromeDriver driver;
 @BeforeMethod
	void beforeMethod() {
	 WebDriverManager.chromedriver().setup();
	 driver=new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 driver.get("https://www.saucedemo.com/");	
	 driver.findElement(By.id("user-name")).sendKeys("standard_user");	
	 driver.findElement(By.id("password")).sendKeys("secret_sauce");	
	 driver.findElement(By.id("login-button")).click();
	 
	}
 @AfterMethod
	void afterMethod() throws InterruptedException {
	 driver.manage().window().minimize();
	 Thread.sleep(2000);
	 driver.quit();
	}
 @Test(priority = 1)
 	void ClickOnMenuBtn() throws InterruptedException {
	 WebElement menuBtn = driver.findElement(By.id("react-burger-menu-btn"));
	 menuBtn.click();
	 Thread.sleep(2000);
	 driver.findElement(By.id("about_sidebar_link")).click();
	 Thread.sleep(3000);
	 driver.navigate().back();
	 try {
		 menuBtn.click();
	} catch (StaleElementReferenceException e) {
		 menuBtn=driver.findElement(By.id("react-burger-menu-btn"));
		 menuBtn.click();
		 Thread.sleep(2000);
	}
	 driver.findElement(By.id("reset_sidebar_link")).click();
	 Thread.sleep(2000);
 }
 @Test(priority = 2)
 	void ChangeFilters() throws InterruptedException  {
	 WebElement dropDown = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
	 Select select = new Select(dropDown);
	 select.selectByIndex(0);
	 Thread.sleep(2000);
	 try {
		 select.selectByIndex(1);
		 Thread.sleep(2000);
		
	} catch (StaleElementReferenceException e) {
	     dropDown = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
	     select = new Select(dropDown);
	     select.selectByIndex(1);
	     Thread.sleep(2000);	   
	}
	 try {
		 select.selectByIndex(2);
		 Thread.sleep(2000);
	} catch (StaleElementReferenceException e) {
		 dropDown = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
		 select = new Select(dropDown);
		 select.selectByIndex(2);
	     Thread.sleep(2000);
	}
	 try {
		 select.selectByIndex(3);
		 Thread.sleep(2000);
	} catch (StaleElementReferenceException e) {
		 dropDown = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
		 select = new Select(dropDown);
		 select.selectByIndex(3);
	     Thread.sleep(2000);
	} 
 }
 @Test(priority = 3)
  	void AddToCart() throws InterruptedException {
	 driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']")).click();
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")).click();
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']")).click();
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-onesie']")).click();
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")).click();
	 Thread.sleep(2000);
 }
 @Test(priority = 4)
 	void ClickOnCartIcon() throws InterruptedException {
	 driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
	 Thread.sleep(2000);
 }	
}

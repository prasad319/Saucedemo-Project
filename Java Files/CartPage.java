package saucedemo_Project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CartPage {
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
	void ClickOnContinueShopping() throws InterruptedException {
	 driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//button[@id='continue-shopping']")).click();
	 Thread.sleep(2000);
	 
}
 @Test(priority=2)
 	void RemoveFromCart() throws InterruptedException {
	 driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-onesie']")).click();
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")).click();
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//button[@id='remove-sauce-labs-onesie']")).click();
	 Thread.sleep(2000);
 }
 @Test(priority = 3)
 	void ClickOnChekouts() throws InterruptedException {
	 driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//button[@id='checkout']")).click();
	 Thread.sleep(2000);
 }	
}

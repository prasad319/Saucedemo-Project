package saucedemo_Project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InventoryPageBack {
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
 @Test(priority=1)
 	void ClickOnTwitterIcon() throws InterruptedException {
	 driver.findElement(By.xpath("//a[normalize-space()='Twitter']")).click();
	 Thread.sleep(3000); 
 }
 @Test(priority=2)
 	void ClickOnFacebookIcon() throws InterruptedException {
	 driver.findElement(By.xpath("//a[normalize-space()='Facebook']")).click();
	 Thread.sleep(3000);
 }
 @Test(priority=3)
 	void ClickOnLinkdnIcon() throws InterruptedException {
	 driver.findElement(By.xpath("//a[normalize-space()='LinkedIn']")).click();
	 Thread.sleep(3000);
 }
 @Test(priority=4)
 	void ClickOnLogout() throws InterruptedException {
	 driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
	 Thread.sleep(3000);
	 driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();
 }
}

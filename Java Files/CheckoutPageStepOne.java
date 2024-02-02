package saucedemo_Project;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckoutPageStepOne {
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
	 driver.navigate().to("https://www.saucedemo.com/checkout-step-one.html");
 }
 @AfterMethod
	void afterMethod() throws InterruptedException {
	 driver.manage().window().minimize();
	 Thread.sleep(2000);
	 driver.quit();
}	
 @Test(priority=1)
 	void ClickonCancelBtn() throws InterruptedException {
	 driver.findElement(By.xpath("//button[@id='cancel']")).click();
	 Thread.sleep(3000);
 }
 @Test(priority=2)
 	void FillInformation() {
	 try {
		 FileInputStream fis = new FileInputStream("D:\\Automation testing Class\\Eclipse_workspace\\Saucedemo_Project\\src\\main\\java\\saucedemo_Project\\Data.properties");
		 Properties p = new Properties();
		 p.load(fis);
		 String firstName = p.getProperty("First.Name");
		 String lastName = p.getProperty("Last.Name");
		 String postalCode = p.getProperty("Postal.code");
		 driver.findElement(By.id("first-name")).sendKeys(firstName);
		 Thread.sleep(2000);
		 driver.findElement(By.id("last-name")).sendKeys(lastName);
		 Thread.sleep(2000);
		 driver.findElement(By.id("postal-code")).sendKeys(postalCode);
		 Thread.sleep(2000);
	} catch (Exception e) {
		System.out.println(e.getMessage());
		}
	}
 @Test(priority=3)
 	void ClickOnContinueBtn() throws InterruptedException {
	 driver.findElement(By.id("continue")).click();
	 Thread.sleep(3000);
 }	
}

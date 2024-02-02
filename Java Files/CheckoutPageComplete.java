package saucedemo_Project;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckoutPageComplete {
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
	  driver.navigate().to("https://www.saucedemo.com/checkout-complete.html");
 }
 @AfterMethod
 	void afterMethod() throws InterruptedException {
	 driver.manage().window().minimize();
	 Thread.sleep(2000);
	 driver.quit();
 }
 @Test(priority=1)
 	void TakingScreenshotOfOrderConfirmation() throws IOException {
	 File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 Files.copy(f, new File("D:\\Automation testing Class\\Selenium Screenshot\\order.jpg"));
 }
 @Test(priority=2)
 	void ClickOnBackToHomeBtn() throws InterruptedException {
	 driver.findElement(By.xpath("//button[@id='back-to-products']")).click();
	 Thread.sleep(3000);
 }
}

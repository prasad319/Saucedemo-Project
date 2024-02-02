package saucedemo_Project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckoutPageStepTwo {
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
	  driver.navigate().to("https://www.saucedemo.com/checkout-step-two.html");
  }
  @AfterMethod
  	void afterMethod() throws InterruptedException {
	 driver.manage().window().minimize();
	 Thread.sleep(2000);
	 driver.quit();
  }
  @Test
  	void ClickOnCancelBtn() throws InterruptedException {
	 driver.findElement(By.xpath("//button[@id='cancel']")).click();
	 Thread.sleep(3000); 
  }
  @Test
	void ClickOnFinishBtn() throws InterruptedException {
	 driver.findElement(By.xpath("//button[@id='finish']")).click(); 
	 Thread.sleep(3000);
  }
}

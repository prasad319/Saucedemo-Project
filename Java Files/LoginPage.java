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

public class LoginPage {
	ChromeDriver driver;
	@BeforeMethod
		void beforeMethod() {
		 WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.get("https://www.saucedemo.com/");
		
	}
	@AfterMethod
		void afterMethod() throws InterruptedException {
		 driver.manage().window().minimize();
		 Thread.sleep(2000);
		 driver.quit();
	}
	@Test
		void VerifyLoginPageTitle() {
			String title = driver.getTitle();
			System.out.println("The Page Title-"+title);
	}
	@Test
		void VerifyLoginCredentialsWithInvalidUsernameAndValidPassword() throws InterruptedException {
			driver.findElement(By.id("user-name")).sendKeys("standard-user");
			Thread.sleep(2000);
			driver.findElement(By.id("password")).sendKeys("secret_sauce");
			Thread.sleep(2000);
			driver.findElement(By.id("login-button")).click();
	}
	@Test
		void VerifyLoginCredentialsWithValidUsernameAndInvalidPassword() throws InterruptedException {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		Thread.sleep(2000);
		driver.findElement(By.id("password")).sendKeys("secret-sauce");
		Thread.sleep(2000);
		driver.findElement(By.id("login-button")).click();	
	}
	@Test
	void VerifyLoginCredentialsWithValidUsernameAndValidPassword() {
		try {
			FileInputStream fis = new FileInputStream("D:\\Automation testing Class\\Eclipse_workspace\\Saucedemo_Project\\src\\main\\java\\saucedemo_Project\\Data.properties");
			Properties p = new Properties();
			p.load(fis);
			String username = p.getProperty("username");
			String password = p.getProperty("password");
			driver.findElement(By.id("user-name")).sendKeys(username);
			Thread.sleep(2000);
			driver.findElement(By.id("password")).sendKeys(password);
			Thread.sleep(2000);
			driver.findElement(By.id("login-button")).click();
			Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

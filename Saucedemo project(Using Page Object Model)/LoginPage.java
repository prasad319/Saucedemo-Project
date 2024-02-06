package saucedemo.Project;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	By usernameField=By.id("user-name");
	By passwordField=By.id("password");
	By loginBtn=By.id("login-button");
	public LoginPage(WebDriver d) {
		driver=d;
	}
	public void VerifyPageTitle() {
		String title = driver.getTitle();
		System.out.println("The page title is-"+title);
	}
	public void VerifyLoginCredentialsWithInvalidUsernameAndValidPassword()  {
		driver.findElement(usernameField).sendKeys("standard-user");
		driver.findElement(passwordField).sendKeys("secret_sauce");
		driver.findElement(loginBtn).click();
		driver.findElement(usernameField).clear();
		driver.findElement(passwordField).clear();
	}
	public void VerifyLoginCredentialsWithValidUsernameAndInvalidPassword()  {
		driver.findElement(usernameField).sendKeys("standard_user");
		driver.findElement(passwordField).clear();
		driver.findElement(passwordField).sendKeys("secret-sauce");
		driver.findElement(loginBtn).click();
		driver.findElement(usernameField).clear();
		driver.findElement(passwordField).clear();
	}
	public void VerifyLoginCredentialsWithValidUsernameAndValidPassword() {
		try {
			FileInputStream fis = new FileInputStream("D:\\Automation testing Class\\Eclipse_workspace\\Saucedemo_Project\\src\\main\\java\\saucedemo\\Project\\Data.properties");
			Properties p = new Properties();
			p.load(fis);
			String username = p.getProperty("username");
			String password = p.getProperty("password");
			driver.findElement(usernameField).sendKeys(username);
			driver.findElement(passwordField).clear();
			driver.findElement(passwordField).sendKeys(password);
			driver.findElement(loginBtn).click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

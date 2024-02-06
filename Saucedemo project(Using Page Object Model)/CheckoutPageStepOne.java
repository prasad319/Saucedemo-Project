package saucedemo.Project;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPageStepOne {
	WebDriver driver;
	By FirstName=By.id("first-name");
	By LastName=By.id("last-name");
	By PostalCode=By.id("postal-code");
	By CancelBtn=By.xpath("//button[@id='cancel']");
	By Checkouts=By.xpath("//button[@id='checkout']");
	By ContinueBtn=By.id("continue");
	public CheckoutPageStepOne(WebDriver d) {
		driver=d;
	}
	public void ClickonCancelBtn() {
		driver.findElement(CancelBtn).click();
		driver.findElement(Checkouts).click();
	}
	public void FillInformation() {
		try {
			FileInputStream fis = new FileInputStream("D:\\Automation testing Class\\Eclipse_workspace\\Saucedemo_Project\\src\\main\\java\\saucedemo\\Project\\Data.properties");
			Properties p = new Properties();
			p.load(fis);
			String firstName = p.getProperty("First.Name");
			String lastName = p.getProperty("Last.Name");
			String postalCode =p.getProperty("postal.code");
			driver.findElement(FirstName).sendKeys(firstName);
			driver.findElement(LastName).sendKeys(lastName);
			driver.findElement(PostalCode).sendKeys(postalCode);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void ClickOnContinueBtn() {
		driver.findElement(ContinueBtn).click();
	}
}

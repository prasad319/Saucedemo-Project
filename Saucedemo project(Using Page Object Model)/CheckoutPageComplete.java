package saucedemo.Project;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.google.common.io.Files;

public class CheckoutPageComplete {
	WebDriver driver;
	By BackToHome=By.xpath("//button[@id='back-to-products']");
	public CheckoutPageComplete(WebDriver d) {
		driver=d;
	}
	public void TakeScreenshotOfOrderConfirmation() throws IOException {
		File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(f,new File("D:\\Automation testing Class\\Selenium Screenshot\\order.jpg"));
	}
	public void ClickOnBackToHome() {
		driver.findElement(BackToHome).click();
	}
}

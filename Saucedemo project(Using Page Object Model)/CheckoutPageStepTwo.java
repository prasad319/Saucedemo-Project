package saucedemo.Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPageStepTwo {
	WebDriver driver;
	By CancelBtn=By.xpath("//button[@id='cancel']");
	By FinishBtn=By.xpath("//button[@id='finish']");
	public CheckoutPageStepTwo(WebDriver d) {
		driver=d;
	}
	public void ClickOnCancel() {
		driver.findElement(CancelBtn).click();
		driver.navigate().to("https://www.saucedemo.com/checkout-step-two.html");
	}
	public void ClickOnFinish() {
		driver.findElement(FinishBtn).click();
	}
}

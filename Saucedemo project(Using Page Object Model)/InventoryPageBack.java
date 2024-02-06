package saucedemo.Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPageBack {
	WebDriver driver;
	By MenuBtn=By.xpath("//button[@id='react-burger-menu-btn']");
	By LogoutBtn=By.xpath("//a[@id='logout_sidebar_link']");
	public InventoryPageBack(WebDriver d) {
		driver=d;
	}
	public void ClickOnMenuBtn() {
		driver.findElement(MenuBtn).click();
	}
	public void ClickOnLogout() {
		driver.findElement(LogoutBtn).click();
	}
}

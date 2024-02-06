package saucedemo.Project;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SaucedemoMainPage {

	public static void main(String[] args) {
	try {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.saucedemo.com/");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.VerifyPageTitle();
		loginPage.VerifyLoginCredentialsWithInvalidUsernameAndValidPassword();
		loginPage.VerifyLoginCredentialsWithValidUsernameAndInvalidPassword();
		loginPage.VerifyLoginCredentialsWithValidUsernameAndValidPassword();
		InventoryPage inventoryPage = new InventoryPage(driver);
		inventoryPage.ClickOnMenuBtn();
		inventoryPage.ClickOnCloseMenuoption();
		inventoryPage.ChangeFilter();
		inventoryPage.AddToCart();
		inventoryPage.ClickOnCartIcon();
		CartPage cartPage = new CartPage(driver);
		cartPage.RemoveFromCart();
		cartPage.ClickOnContinueShopping();
		cartPage.ClickOnChekouts();
		CheckoutPageStepOne checkoutPageStepOne = new CheckoutPageStepOne(driver);
		checkoutPageStepOne.FillInformation();
		checkoutPageStepOne.ClickonCancelBtn();
		checkoutPageStepOne.ClickOnContinueBtn();
		CheckoutPageStepTwo checkoutPageStepTwo = new CheckoutPageStepTwo(driver);
		checkoutPageStepTwo.ClickOnCancel();
		checkoutPageStepTwo.ClickOnFinish();
		CheckoutPageComplete checkoutPageComplete = new CheckoutPageComplete(driver);
		checkoutPageComplete.TakeScreenshotOfOrderConfirmation();
		checkoutPageComplete.ClickOnBackToHome();
		InventoryPageBack inventoryPageBack = new InventoryPageBack(driver);
		inventoryPageBack.ClickOnMenuBtn();
		inventoryPageBack.ClickOnLogout();
		driver.manage().window().minimize();
		driver.quit();
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}	
  }

}

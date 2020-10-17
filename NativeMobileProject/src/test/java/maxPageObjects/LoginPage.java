package maxPageObjects;

import BaseClass.PageBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LoginPage extends PageBase {

	public LoginPage(AppiumDriver<MobileElement> driver) {

		super(driver);
	}

	private MobileElement navigationButton() {
		return (MobileElement) driver.findElementById("com.applications.max:id/ivIntroOneAction");
	}

	private MobileElement shopBasedOnGenderButton() {
		return (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@text,'SHOP WOMEN')]");
	}

	// To Click the Login Screen Navigation button

	public void clickNavigationButton() {
		try {
			waitForElementVisible(navigationButton());
			navigationButton().click();
		} catch (Exception e) {
			System.out.println("Message is :" + e.getMessage());
			e.printStackTrace();
		}
	}

	// To click on shop category

	public void clickShopCategory() {
		try {
			shopBasedOnGenderButton().click();
		} catch (Exception e) {
			System.out.println("Message is :" + e.getMessage());
			e.printStackTrace();
		}
	}
}

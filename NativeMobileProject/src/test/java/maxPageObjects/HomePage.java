package maxPageObjects;

import BaseClass.PageBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class HomePage extends PageBase {

	public HomePage(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	private MobileElement logo() {
		return (MobileElement) driver.findElementById("com.applications.max:id/maxLogo");
	}

	private MobileElement chooseAccountButton() {
		return (MobileElement) driver
				.findElementByXPath("//android.widget.FrameLayout[@content-desc='Account']/android.widget.ImageView");
	}

	// Navigation to user Account section

	public void navigateToAccountSection() {
		try {
			waitForElementVisible(logo());
			chooseAccountButton().click();
		} catch (Exception e) {
			System.out.println("Message is :" + e.getMessage());
			e.printStackTrace();
		}
	}
}

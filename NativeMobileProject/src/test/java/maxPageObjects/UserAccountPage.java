package maxPageObjects;

import BaseClass.PageBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class UserAccountPage extends PageBase {

	public UserAccountPage(AppiumDriver<MobileElement> driver) {

		super(driver);
	}

	private MobileElement signInButton() {
		return (MobileElement) driver.findElementById("com.applications.max:id/sign_in");
	}

	private MobileElement emailTextBox() {
		return (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@text,'Email')]");
	}

	private MobileElement passwordTextBox() {
		return (MobileElement) driver.findElementByXPath("//android.widget.EditText[contains(@text,'Password')]");
	}

	private MobileElement accountSignInButton() {
		return (MobileElement) driver.findElementById("com.applications.max:id/btnSignIn");
	}

	private MobileElement accountSignOutButton() {
		return (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@text,'Sign Out')]");
	}

	private MobileElement accountContactUsButton() {
		return (MobileElement) driver.findElementByXPath("//android.widget.TextView[contains(@text,'Contact Us')]");
	}

	private MobileElement accountHeader() {
		return (MobileElement) driver.findElementById("com.applications.max:id/my_account_user_name");
	}

	// To click sign in button

	public void clickSignInButton() {
		try {
			waitForElementClickable(signInButton());
			signInButton().click();
		} catch (Exception e) {
			System.out.println("Message is :" + e.getMessage());
			e.printStackTrace();
		}
	}

	// To click and enter email ID in email ID text box

	public void enterEmailId() {
		try {
			String emailID = readExcel("MAX", "Login", "UserName");
			waitForElementClickable(emailTextBox());
			emailTextBox().click();
			emailTextBox().sendKeys(emailID);
		} catch (Exception e) {
			System.out.println("Message is :" + e.getMessage());
			e.printStackTrace();
		}
	}

	// To click and enter password in password text box

	public void enterPassword() {
		try {
			String password = readExcel("MAX", "Login", "Password");
			passwordTextBox().click();
			passwordTextBox().sendKeys(password);
		} catch (Exception e) {
			System.out.println("Message is :" + e.getMessage());
			e.printStackTrace();
		}
	}

	// To click user account sigin button

	public void clickAccountSignInButton() {
		try {
			accountSignInButton().click();
			waitForElementVisible(accountHeader());
		} catch (Exception e) {
			System.out.println("Message is :" + e.getMessage());
			e.printStackTrace();
		}
	}

	// To perform vertical swipe action

	public void verticalSwipeAction() throws InterruptedException {
		TouchAction swipe = new TouchAction(driver);
		swipe.longPress(PointOption.point(470, 1580)).moveTo(PointOption.point(470, 382)).release().perform();
	}

	// To click account sign out button

	public void clickAccountSignOutButton() {
		try {
			verticalSwipeAction();
			waitForElementVisible(accountContactUsButton());
			verticalSwipeAction();
			waitForElementClickable(accountSignOutButton());
			accountSignOutButton().click();
		} catch (Exception e) {
			System.out.println("Message is :" + e.getMessage());
			e.printStackTrace();
		}
	}

	// To retrieve the created user account ID title

	public String getUserAccountName() {
		String AccountUsername = accountHeader().getText();
		return AccountUsername;
	}
}

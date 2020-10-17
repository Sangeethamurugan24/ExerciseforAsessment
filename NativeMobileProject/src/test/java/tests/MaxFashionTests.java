package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import BaseClass.TestBaseClass;
import maxPageObjects.UserAccountPage;
import maxPageObjects.HomePage;
import maxPageObjects.LoginPage;

public class MaxFashionTests extends TestBaseClass {

	public LoginPage loginPage;
	public UserAccountPage accountPage;
	public HomePage homePage;
	private String ACTUAL_ACCOUNT_USER_NAME = null;
	private String EXPECTED_ACCOUNT_USER_NAME = "Hi, Sangeetha Murugan";

	@BeforeMethod
	public void performPreRequisite() {
		loginPage = new LoginPage(driver);
		accountPage = new UserAccountPage(driver);
		homePage = new HomePage(driver);
	}

	@Test
	public void testSiginAndSignOut() throws InterruptedException {
		loginPage.clickNavigationButton();
		loginPage.clickShopCategory();
		homePage.navigateToAccountSection();
		accountPage.clickSignInButton();
		accountPage.enterEmailId();
		accountPage.enterPassword();
		accountPage.clickAccountSignInButton();
		ACTUAL_ACCOUNT_USER_NAME = accountPage.getUserAccountName();
		Assert.assertEquals(ACTUAL_ACCOUNT_USER_NAME, EXPECTED_ACCOUNT_USER_NAME);
	}

	@AfterMethod
	public void signOut() {
		accountPage.clickAccountSignOutButton();
	}
}

package BaseClass;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestBaseClass {

	public static AppiumDriver<MobileElement> driver;

	@BeforeTest
	public void setup() {

		try {
			DesiredCapabilities dc = new DesiredCapabilities();
			String currentDirectory = System.getProperty("user.dir");
			String separator = System.getProperty("file.separator");
			dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
			dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
			dc.setCapability(MobileCapabilityType.APP, currentDirectory+separator+"Max_Fashion_base.apk");
			dc.setCapability(MobileCapabilityType.DEVICE_NAME, "ZY224557V4");
			dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
			dc.setCapability("unicodeKeyboard", true);
			dc.setCapability("resetKeyboard", true);
			dc.setCapability("noReset", false);
			dc.setCapability("fullReset", true);
			dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.applications.max");
			dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,
					"com.landmarkgroup.landmarkshops.module.splash.activity.SplashActivityV2");
			driver = new AppiumDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), dc);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} catch (Exception e) {
			System.out.println("Message is :" + e.getMessage());
			e.printStackTrace();
		}
	}

	@AfterTest
	public void teardown() {

		driver.quit();
	}
}

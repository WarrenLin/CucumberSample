package android;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.AppiumDriver;
import utils.DriverFactory;

public class Hook {
	public static AppiumDriver driver;
	
	@Before("@android_reinstall")
    public void beforeAndroidScenario(){
		System.out.println("This will run before the Android Scenario");
		driver = new DriverFactory().getAndroidDriver();
	}
	
	@After("@android_reinstall")
    public void tearAndroidDown(Scenario scenario) {
        System.out.println("This will run after the Android Scenario");
        driver.closeApp();
        driver.removeApp("com.wantoto.gomaji2");
        driver.quit();
    }
}

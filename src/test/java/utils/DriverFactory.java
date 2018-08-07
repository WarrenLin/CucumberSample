package utils;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class DriverFactory {
	private static URL remoteUrl;
	
	public DriverFactory() {
		try {
			remoteUrl = new URL("http://localhost:4723/wd/hub");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}	
	}
	
	public static synchronized AppiumDriver<IOSElement> getIOSDriver() {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "iOS");
	    desiredCapabilities.setCapability("platformVersion", "11.4");
	    desiredCapabilities.setCapability("deviceName", "iPhone");
	    desiredCapabilities.setCapability("udid", "E4C84480-423C-4624-BAE4-3C6652BBE13D");
	    desiredCapabilities.setCapability("app", "/Users/Warren/Desktop/gomaji.app");
	    desiredCapabilities.setCapability("automationName", "XCUITest");
	    return new IOSDriver<>(remoteUrl, desiredCapabilities);
	}
	
	public static synchronized AppiumDriver<AndroidElement> getAndroidDriver() {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("platformVersion", "7.0");
	    desiredCapabilities.setCapability("deviceName", "device");
	    desiredCapabilities.setCapability("appPackage", "com.wantoto.gomaji2");
	    desiredCapabilities.setCapability("app", "/Users/Warren/Desktop/GOMAJI_6.3.8.1-381-dev-debug.apk");
	    desiredCapabilities.setCapability("appActivity", "com.janna.gomaji.IntroductionActivity");
	    desiredCapabilities.setCapability("automationName", "uiautomator2");
		return new AndroidDriver<>(remoteUrl, desiredCapabilities);
	}
	
}

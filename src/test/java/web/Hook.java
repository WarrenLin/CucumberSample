package web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.AppiumDriver;
import utils.DriverFactory;

public class Hook {
	public static WebDriver driver;
	public final static String EAN_URL = "https://hotel.gomaji.com/";
	
	@Before
    public void beforeScenario(){
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless");
		chromeOptions.addArguments("start-maximized");
		chromeOptions.addArguments("--disable-gpu");
		chromeOptions.addArguments("--disable-extensions");
		
        driver = new ChromeDriver(chromeOptions);
        driver.get(EAN_URL);
    }

    @After
    public void tearDown(Scenario scenario) {
    	driver.close();
    	driver.quit();
    }
}

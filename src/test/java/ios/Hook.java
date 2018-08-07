package ios;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.AppiumDriver;
import utils.DriverFactory;

public class Hook {
	public static AppiumDriver driver;
	
	@Before("@ios_reinstall")
    public void beforeScenario(){
        System.out.println("This will run before the Scenario");
        driver = new DriverFactory().getIOSDriver();     
//        if(driver.isAppInstalled("com.gomaji.iphone")) {
//        	driver.removeApp("com.gomaji.iphone");
//        }
    }

    @After("@ios_reinstall")
    public void tearDown(Scenario scenario) {
        System.out.println("This will run after the Scenario");
//        try {
//	          if(scenario.isFailed()) {
//	              final byte[] screenshot = driver.getScreenshotAs(OutputType.BYTES);
//	              scenario.embed(screenshot, "image/png");
//	              driver.closeApp();
//	              driver.removeApp("com.gomaji.iphone");
//	//              driver.installApp(appPath);
//	          }
//	      } finally {
	      	driver.closeApp();
	      	driver.removeApp("com.gomaji.iphone");
	        driver.quit();
//	      }
    }
}

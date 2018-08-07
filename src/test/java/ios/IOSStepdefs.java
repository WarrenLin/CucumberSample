package ios;

import java.util.ArrayList;

import org.junit.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileElement;

public class IOSStepdefs {
	
	private void allowPermission() throws Exception{
		ArrayList<MobileElement> els1 = (ArrayList<MobileElement>) Hook.driver.findElementsByName("Allow");
		if(els1.size() > 0) {
			els1.get(0).click();
		}
		Thread.sleep(1500);
		
		ArrayList<MobileElement> els2 = (ArrayList<MobileElement>) Hook.driver.findElementsByName("Allow");
		if(els2.size() > 0) {
			els2.get(0).click();
		}
		Thread.sleep(1500);		
	}
	
	@Given("^介紹頁面呈現$")
	public void 介紹頁面呈現() throws Exception {
		allowPermission();
	}

	@When("^點擊開始使用$")
	public void 點擊開始使用() throws Exception {
		MobileElement el1 = (MobileElement) Hook.driver.findElementByAccessibilityId("開始使用");
		el1.click();
		Thread.sleep(1500);
	}

	@Then("^進入選擇位置畫面$")
	public void 進入選擇位置畫面() throws Exception {
		MobileElement el12 = (MobileElement) Hook.driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"GOMAJI\"]");
		boolean isDisplayed = el12.isDisplayed();
		Assert.assertTrue(isDisplayed);
	}
}

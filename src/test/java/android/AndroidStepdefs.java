package android;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileElement;
import utils.DriverFactory;

public class AndroidStepdefs {

	private void waitDriver() {
		Hook.driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
	}
	
	private void allowPermission() throws Exception{
		MobileElement el1 = (MobileElement) Hook.driver.findElementById("android:id/button2");
		el1.click();
		MobileElement el2 = (MobileElement) Hook.driver.findElementById("com.android.packageinstaller:id/permission_allow_button");
		el2.click();
		Thread.sleep(300);
		el2.click();
		Thread.sleep(300);
		el2.click();
		Thread.sleep(300);
	}
	
	@Given("^介紹頁面呈現$")
	public void 介紹頁面呈現() throws Exception {
		allowPermission();
	}

	@When("^點擊開始使用$")
	public void 點擊開始使用() throws Exception {
		WebDriverWait wait = new WebDriverWait(Hook.driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn_enter")));
		MobileElement el1 = (MobileElement) Hook.driver.findElementById("com.wantoto.gomaji2:id/btn_enter");
		el1.click();
	}

	@Then("^進入選擇位置畫面$")
	public void 進入選擇位置畫面() throws Exception {
		MobileElement el1 = (MobileElement) Hook.driver.findElementById("com.wantoto.gomaji2:id/header");
		boolean isDisplayed = el1.isDisplayed();
		Assert.assertTrue(isDisplayed);
	}

	@When("^點擊輸入MGM按鈕$")
	public void 點擊輸入mgm按鈕() throws Exception {
//		Thread.sleep(1500);
		WebDriverWait wait = new WebDriverWait(Hook.driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn_mgm")));
		MobileElement el1 = (MobileElement) Hook.driver.findElementById("com.wantoto.gomaji2:id/btn_mgm");
		el1.click();
	}

	@Then("^進入手機認證畫面$")
	public void 進入手機認證畫面() throws Exception {
		MobileElement el1 = (MobileElement) Hook.driver.findElementById("com.wantoto.gomaji2:id/tv_set_card_actionbar_title");
		String title = el1.getText();
		Assert.assertTrue(title.equals("手機認證"));
	}

	@When("^輸入手機號碼 (\\d+)$")
	public void 輸入手機號碼(int arg1) throws Exception {
		MobileElement el2 = (MobileElement) Hook.driver.findElementById("com.wantoto.gomaji2:id/etMobilePhone");
		el2.sendKeys("0900000000");
		MobileElement el3 = (MobileElement) Hook.driver.findElementById("com.wantoto.gomaji2:id/btnSignUp");
		el3.click();
	}

	@Then("^進入輸入驗證碼畫面$")
	public void 進入輸入驗證碼畫面() throws Exception {
		//fail
//		MobileElement el1 = (MobileElement) Hook.driver.findElementByXPath("//android.widget.Button[@text='驗證']");
		//fail
//		MobileElement el1 = (MobileElement) Hook.driver.findElementByLinkText("驗證");
		
//		Hook.driver.getPageSource();
//		String source = Hook.driver.getPageSource();
//		System.out.println(source);
//		List<MobileElement> t = (List<MobileElement>) Hook.driver.findElementsByClassName("android.widget.Button");
//		System.out.println("Size:" + t.size());
		
		WebDriverWait wait = new WebDriverWait(Hook.driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnVerify")));
		MobileElement el1 = (MobileElement) Hook.driver.findElementById("com.wantoto.gomaji2:id/btnVerify");
		boolean isDisplayed = el1.isDisplayed();
		Assert.assertTrue(isDisplayed);
	}

	@When("^輸入驗證碼 (\\d+)$")
	public void 輸入驗證碼(int arg1) throws Exception {
		MobileElement el4 = (MobileElement) Hook.driver.findElementById("com.wantoto.gomaji2:id/etVerificationCode");
		el4.sendKeys("1234");
		MobileElement el5 = (MobileElement) Hook.driver.findElementById("com.wantoto.gomaji2:id/btnVerify");
		el5.click();
	}
	
	@Then("^進入MGM畫面$")
	public void 進入mgm畫面() throws Exception {
		WebDriverWait wait = new WebDriverWait(Hook.driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tv_title")));		
		MobileElement el1 = (MobileElement) Hook.driver.findElementById("com.wantoto.gomaji2:id/tv_title");
		boolean isDisplayed = el1.isDisplayed();
		Assert.assertTrue(isDisplayed);
	}
}

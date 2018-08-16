package gomaji;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gomaji.Hook;

public class GomajiStepdefs {
	private String productName = "";
	
	@Given("^打開商品頁面$")
	public void 打開商品頁面_取得商品名稱() throws Exception {
		Hook.driver.get(Hook.productURL);
		productName = Hook.driver.findElement(By.cssSelector("span[class=product-name]")).getText();
		System.out.println("商品名稱:" + productName);
	}

	@When("^點擊馬上購買$")
	public void 點擊馬上購買() throws Exception {
		Hook.driver.findElement(By.cssSelector("a[class=buy-now]")).click();
	}

	@Then("^出現結帳頁面,商品名稱一致$")
	public void 出現結帳頁面_商品名稱一致() throws Exception {
		String verifyPageProductName = Hook.driver.findElement(By.cssSelector("p[class='col product-name']")).getText();
		Assert.assertTrue(verifyPageProductName.equals(productName));
	}
	
	@When("^選擇數量 (\\d+)$")
	public void 選擇數量(int arg1) throws Exception {
		Select select = new Select(Hook.driver.findElement(By.cssSelector("select[id=buy_number]")));
		select.selectByVisibleText(String.valueOf(arg1));
	}

	@When("^選擇atm$")
	public void 選擇atm() throws Exception {
//		List<WebElement> radios = Hook.driver.findElements(By.name("payment_type"));
//		for (int i=0; i<radios.size(); i++) { 
//			String idName = radios.get(i).getAttribute("id");
//			if(idName.equals("atm")) {
//				radios.get(i).click();
//			}
//		}
		
		WebElement element = Hook.driver.findElement(By.cssSelector("input[id=atm]"));
		((JavascriptExecutor) Hook.driver).executeScript("arguments[0].checked = true;", element);
	}

	@When("^點擊同意條款並送出訂單$")
	public void 點擊同意條款並送出訂單() throws Exception {
		Hook.driver.findElement(By.cssSelector("a[class=subm-bu-btn]")).click();
	}

	@When("^輸入mail \"([^\"]*)\"$")
	public void 輸入mail(String arg1) throws Exception {
		Hook.driver.findElement(By.cssSelector("input[id='email']")).sendKeys(arg1);
	}

	@When("^輸入名字 \"([^\"]*)\"$")
	public void 輸入名字(String arg1) throws Exception {
		Hook.driver.findElement(By.cssSelector("input[id='full_name']")).sendKeys(arg1);
	}

	@When("^輸入手機 \"([^\"]*)\"$")
	public void 輸入手機(String arg1) throws Exception {
		Hook.driver.findElement(By.cssSelector("input[id='mobile_phone']")).sendKeys(arg1);
	}

	@Then("^出現Popup \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" 確認畫面$")
	public void 出現popup_確認畫面(String mail, String name, String phone) throws Exception {
		String verifyMail = Hook.driver.findElement(By.cssSelector("p[id=preview_email]")).getText();
		String verifyName = Hook.driver.findElement(By.cssSelector("p[id=preview_full_name]")).getText();
		String verifyPhone = Hook.driver.findElement(By.cssSelector("p[id=preview_mobile_phone]")).getText();
		String paymentType = Hook.driver.findElement(By.cssSelector("p[id=preview_payment_type]")).getText();
		
		Assert.assertTrue(verifyMail.equals(mail));
		Assert.assertTrue(verifyName.equals(name));
		Assert.assertTrue(verifyPhone.equals(phone));
	}
	
}

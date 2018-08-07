package web;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WebStepdefs {
	@Given("^EAN訂房首頁$")
	public void ean訂房首頁() throws Exception {
		Hook.driver.get(Hook.EAN_URL);
	}

	@When("^點擊搜尋Bar$")
	public void 點擊搜尋bar() throws Exception {
		WebElement webElement = Hook.driver.findElement(By.xpath("//*[@id=\"input-search\"]"));
		webElement.click();
	}

	@Then("^出現可選取地名$")
	public void 出現可選取地名() throws Exception {
		WebElement listElement = Hook.driver.findElement(By.xpath("//*[@id=\"hot-keywords-list\"]"));
		List<WebElement> options = listElement.findElements(By.tagName("li"));
		System.out.println("人氣關鍵字:");
		for(int i=0; i<options.size(); i++) {
			WebElement element = options.get(i);
			System.out.println(element.getText());
		}
		Assert.assertTrue(options.size() > 0);
	}

	@Then("^Popup 消失$")
	public void popup_消失() throws Exception {
		WebElement listElement = Hook.driver.findElement(By.cssSelector("div[class='search areaBox dropdown dropdown--border-black js-dropdown']"));
		Assert.assertTrue(listElement.isEnabled());
	}
	
	@When("^輸入搜尋字 \"([^\"]*)\"$")
	public void 輸入搜尋字(String keyword) throws Exception {
		WebElement webElement = Hook.driver.findElement(By.xpath("//*[@id=\"input-search\"]"));
		webElement.click();
		webElement.sendKeys(keyword);
		Thread.sleep(1500);
	}

	@Then("^出現搜尋結果$")
	public void 出現搜尋結果() throws Exception {
		WebElement listElement = Hook.driver.findElement(By.cssSelector("div[id='suggestion-keywords']"));
		List<WebElement> options = listElement.findElements(By.tagName("li"));
		System.out.println("搜尋結果:");
		for(int i=0; i<options.size(); i++) {
			WebElement element = options.get(i);
			String href = element.findElement(By.tagName("a")).getAttribute("href");
			System.out.println(element.getText() + ", Href ->" + href);
		}
		Assert.assertTrue(options.size() > 0);
	}
}

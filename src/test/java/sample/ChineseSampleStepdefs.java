package sample;

import java.util.HashMap;
import java.util.Map;

import cucumber.api.java.zh_tw.假設;
import cucumber.api.java.zh_tw.當;
import cucumber.api.java.zh_tw.那麼;
import org.junit.Assert;

public class ChineseSampleStepdefs {
	Map<String,Integer> pricesMap = new HashMap<>();
	int assertPrice = 0;
	
	@假設("^\"([^\"]*)\"每斤(\\d+)元$")
	public void 每斤_元(String arg1, int arg2) throws Exception {
		pricesMap.put(arg1, arg2);
	}

	@當("^我買了(\\d+)斤\"([^\"]*)\"$")
	public void 我買了_斤(int arg1, String arg2) throws Exception {
		assertPrice = arg1 * pricesMap.get(arg2);
	}

	@那麼("^總價要付(\\d+)元$")
	public void 總價要付_元(int arg1) throws Exception {
		Assert.assertEquals(arg1, assertPrice);
	}
}

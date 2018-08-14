package sample;

import static org.junit.Assert.assertEquals;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

class IsItFriday {
    static String isItFriday(String today) {
    	if (today.equals("Friday")) {
            return "TGIF";
        }
        return "Nope";
    }
}

public class SampleStepdefs {
	private String today;
    private String actualAnswer;

    @Given("^today is Sunday$")
    public void today_is_Sunday() {
        this.today = "Sunday";
    }

    @When("^I ask whether it's Friday yet$")
    public void i_ask_whether_is_s_Friday_yet() {
        this.actualAnswer = IsItFriday.isItFriday(today);
    }

    @Then("^I should be told \"([^\"]*)\"$")
    public void i_should_be_told(String expectedAnswer) {
        assertEquals(expectedAnswer, actualAnswer);
    }
    
    @Given("^today is Friday$")
    public void today_is_Friday() {
        this.today = "Friday";
    }
    
    @Given("^today is \"([^\"]*)\"$")
    public void today_is(String arg1) throws Exception {
    	this.today = arg1;
    }
}

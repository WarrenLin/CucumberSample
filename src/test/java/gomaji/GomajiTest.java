package gomaji;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(tags = {"@gomaji_checkout"},
plugin = {"pretty", "html:target/cucumber-reports/", "json:target/cucumber-reports/gomaji_checkout.json"},
glue = {"gomaji"}, 
features = {"src/test/resources/features/gomaji.feature"})
public class GomajiTest {
}



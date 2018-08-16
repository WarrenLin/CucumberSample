package gomaji;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(tags = {"@gomaji"}, plugin = {"pretty"}, glue = {"gomaji"}, features = {"src/test/resources/features/gomaji.feature"})
public class GomajiTest {
}

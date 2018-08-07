package ios;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(tags = {"@ios_reinstall"}, plugin = {"pretty"}, glue = {"ios"}, features = {"src/test/resources/features/appguide.feature"})
public class IOSCucumberTest {
}

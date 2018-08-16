package android;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(tags = {"@android_reinstall"}, plugin = {"pretty"}, 
glue = {"android", "hook"},
monochrome = true,
features = {"src/test/resources/features"})
public class AndroidCucumberTest {

}

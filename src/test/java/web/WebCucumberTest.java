package web;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(tags = {"@web"}, 
plugin = {"pretty","html:target/cucumber-report/", "json:target/cucumber-report/cucumber.json"}, 
glue = {"web"}, 
monochrome = true,
features = {"src/test/resources/features/gomaji_ean.feature"})
public class WebCucumberTest {
}

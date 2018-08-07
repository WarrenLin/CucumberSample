package web;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(tags = {"@web"}, plugin = {"pretty"}, glue = {"web"}, 
monochrome = true,
features = {"src/test/resources/features/gomaji_ean.feature"})
public class WebCucumberTest {
}

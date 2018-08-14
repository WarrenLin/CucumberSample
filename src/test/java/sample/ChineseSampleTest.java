package sample;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(tags = {"@chinese"}, 
plugin = {"pretty"}, glue = {"sample"}, features = {"src/test/resources/features/chinese_sample.feature"})
public class ChineseSampleTest {

}

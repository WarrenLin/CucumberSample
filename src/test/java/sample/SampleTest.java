package sample;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(tags = {"@tag"}, plugin = {"pretty"}, glue = {"sample"}, features = {"src/test/resources/features/english_sample.feature"})
public class SampleTest {
}

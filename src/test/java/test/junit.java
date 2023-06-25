package test;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
/*import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;*/


@RunWith(Cucumber.class)
@CucumberOptions(
features = "feature"
,glue= {"step"},plugin = { "pretty", "html:target/cucumber-reports" },
monochrome = true
)
public class junit {

}

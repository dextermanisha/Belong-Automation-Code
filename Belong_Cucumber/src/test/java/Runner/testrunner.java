package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
features = "src/test/java/features"
,glue= "seleniumgluecode"
,plugin = { "pretty", "html:target/htmlreports" }
)

public class testrunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

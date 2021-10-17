package runnerlead;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features = "src/test/java/featurelead/login.feature",
monochrome=true,	 glue="steplead"  , publish=true)
public class CucumberRunnerLead extends AbstractTestNGCucumberTests {

}

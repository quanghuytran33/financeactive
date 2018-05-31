package financeactive.computetax.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(glue = "financeactive.cucumber",
                 features = "src/test/resources/features")
public class ComputeTaxFeatures {
}

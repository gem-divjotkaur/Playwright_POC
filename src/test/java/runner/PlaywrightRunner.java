package runner;

//import io.cucumber.junit.CucumberOptions;
//import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)


    /**
     * features connect PlaywrightRunner class with feature file folder
     * glue connect PlaywrightRunner class with stepdefinitions folder
     * monochrome as true shows you colorless output
     * plugins are to generate reports like html, json, junit
     */
    @CucumberOptions(
            features = "src/test/resources/features",
            glue = "stepdefinitions",
            monochrome = true,
            //tags="@Authentication",
            plugin = {"pretty", "html:target/htmlReports/report.html",
                    "json:target/jsonReports/report.json",
                    "junit:target/junitReports/report.junit"}
    )
    public class PlaywrightRunner {

    }


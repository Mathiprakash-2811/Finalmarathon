package runner;

import base.BaseClass;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/main/java/features",glue="pages",
monochrome = true, publish = true)

public class Cucumbermarathon extends BaseClass{

}

package com.RunnerClass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/MyNewCucumberProject/MyNewCucumberProject/F04LoginToOHRM.feature",
                 glue= "com.StepDef",
                 publish = true)
public class R04LoginToOHRM {

}

package com.qa.google.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(monochrome = true,
    features = {"./src/test/resource/com/qa/google/features/Google.feature"},
    glue = {"helpers","StepDefinition"})

public class TestRunner extends AbstractTestNGCucumberTests {


}

package org.example.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C:\\Users\\HP\\IdeaProjects\\UIAutomation\\src\\test\\java\\featurefiles"
        ,glue={"org.example.stepdefinition"},
        tags = "@SmokeTest",
        monochrome = true
        ,plugin = {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)

public class CommonRunner {

}
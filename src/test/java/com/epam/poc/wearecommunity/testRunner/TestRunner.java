package com.epam.poc.wearecommunity.testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com/epam/poc/wearecommunity/stepDefinitions", "com/epam/poc/wearecommunity/utilities/hook"},
        tags = "@Smoke",
        plugin = {
                "pretty",
                "html:cucumberReport/cucumber-report-html/cucumber.html",
                "json:cucumberReport/json/cucumber.json"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class TestRunner {
}

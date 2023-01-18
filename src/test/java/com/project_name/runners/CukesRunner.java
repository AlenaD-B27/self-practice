package com.project_name.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-report.html", //html report
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                "json:target/cucumber.json"}, // cucumber report
        features = "src/test/resources/features",
        glue = "com/project_name/step_definitions",
        dryRun = false,
        tags = "@p1",
        publish = true
)
public class CukesRunner {


}

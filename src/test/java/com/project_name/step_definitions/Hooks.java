package com.project_name.step_definitions;

import com.project_name.utilities.DB_Util;
import com.project_name.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;


public class Hooks {

	@Before("@db")
	public void dbHook() {
		System.out.println("---> HOOKS --->creating database connection");
		DB_Util.createConnection();
	}

	@After("@db")
	public void afterDbHook() {
		System.out.println("---> HOOKS ---> closing database connection");
		DB_Util.destroy();

	}
	
	@Before("@ui")
	public void setUp() {
		// we put a logic that should apply to every scenario
		Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
	@After("@ui")
	public void tearDown(Scenario scenario) {
		// only takes a screenshot if the scenario fails
		if (scenario.isFailed()) {
			// taking a screenshot
			final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png","screenshot");
		}
		Driver.closeDriver();
	}
	
	
	
	
	
}

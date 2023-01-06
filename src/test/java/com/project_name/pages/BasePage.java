package com.project_name.pages;

import com.project_name.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
	public BasePage() {
		PageFactory.initElements(Driver.get(), this);
	}


	@FindBy(css = ".collapse.navbar-collapse") // it is just an example
	public WebElement nameElement;


}

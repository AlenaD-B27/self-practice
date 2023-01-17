package com.project_name.pages;

import com.project_name.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DemoQaHomePage {

    public DemoQaHomePage (){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[contains(@class, 'top-card')]")
    public List<WebElement> main_modules;

    public void clickMainModule(String moduleName){

        for(WebElement each : main_modules){
            if(each.getText().equals(moduleName)){
                each.click();
                break;
            }
        }

    }









}

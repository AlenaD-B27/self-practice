package com.project_name.pages;

import com.project_name.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DemoQaElementsPage {
    public DemoQaElementsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = ".element-list.collapse.show>ul>li")
    public List<WebElement> elementOptions;

    public void clickElementOption(String option){
        for(WebElement eachOption : elementOptions){
            if(eachOption.getText().equals(option)){
                eachOption.click();
                break;
            }
        }
    }



}

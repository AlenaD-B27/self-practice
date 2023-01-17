package com.project_name.pages;

import com.project_name.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DemoQaTextBoxPage {
    public DemoQaTextBoxPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    private WebElement inputBox;

    void setInputBoxType(String inputBoxName){
        String inputType = "";


        if (inputBoxName.equals("Full Name") || inputBoxName.equals("Email")) {
            inputType = "input";
        } else if (inputBoxName.equals("Current Address") || inputBoxName.equals("Permanent Address")){
            inputType = "textarea";
        } else {
            System.out.println("The input box \"" + inputBoxName + "\" doesn't exist");
        }


        this.inputBox = Driver.getDriver().findElement(By.xpath("//label[.='" + inputBoxName + "']/parent::div/following-sibling::div//" + inputType));
    }


    public void inputData(String inputBoxName, String inputData) {

        setInputBoxType(inputBoxName);
        inputBox.sendKeys(inputData);

    }

    public String getDataOfBox(String inputBoxName){
        setInputBoxType(inputBoxName);
        return inputBox.getAttribute("value");
    }

        @FindBy(id = "submit")
        public WebElement submitBtn;

        @FindBy(className = "mb-1")
        public List<WebElement> outputResultBoxByLine;





}

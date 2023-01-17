package com.project_name.step_definitions;

import com.github.javafaker.Faker;
import com.project_name.pages.DemoQaElementsPage;
import com.project_name.pages.DemoQaHomePage;
import com.project_name.pages.DemoQaTextBoxPage;
import com.project_name.utilities.BrowserUtils;
import com.project_name.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class Demoqa_stepDefs {

    Faker faker = new Faker();

    DemoQaHomePage homePage = new DemoQaHomePage();
    DemoQaElementsPage elementsPage = new DemoQaElementsPage();
    DemoQaTextBoxPage textBoxPage = new DemoQaTextBoxPage();



    @Given("As a user I open {string}")
    public void as_a_user_i_open(String url) {
        Driver.getDriver().get(url);
    }
    @When("I click on {string} it directs me to the page where I see next options:")
    public void i_click_on_it_directs_me_to_the_page_where_i_see_next_options(String moduleName, List<String> moduleOptions) {
        homePage.clickMainModule(moduleName);

        for (int i = 0; i < moduleOptions.size(); i++) {
            Assert.assertEquals(moduleOptions.get(i), elementsPage.elementOptions.get(i).getText());
        }


    }
    @When("I click on {string}")
    public void i_click_on(String option) {
        elementsPage.clickElementOption(option);

    }

    @When("Fill in the random data into {string} input box")
    public void fill_in_the_random_data_into_input_box(String nameOfInputBox) {

        String randomData = "";


        if(nameOfInputBox.equalsIgnoreCase("Full Name")){
            randomData = faker.funnyName().name();
        } else if(nameOfInputBox.equalsIgnoreCase("Email")){
            randomData = faker.internet().emailAddress();
        } else if(nameOfInputBox.equalsIgnoreCase("Current Address") || nameOfInputBox.equals("Permanent Address")){
            randomData = faker.address().fullAddress();
        } else {
            System.out.println("No such an input box known");
        }


        textBoxPage.inputData(nameOfInputBox, randomData);
    }



    @Then("I click Submit button")
    public void i_click_submit_button() {
        if(Driver.getDriver().getCurrentUrl().contains("text-box")){
          // BrowserUtils.waitForClickability(textBoxPage.submitBtn,120);
            BrowserUtils.clickWithJS(textBoxPage.submitBtn);
          // textBoxPage.submitBtn.click();
        }
    }


    @And("Verify the output data of {string} is the same as input data")
    public void verifyTheOutputDataOfIsTheSameAsInputData(String inputBoxName) {




        textBoxPage.outputResultBoxByLine.forEach(line -> {
            String actualResult = "";
            if(line.getText().contains(inputBoxName)){
                actualResult = (line.getText().substring(line.getText().indexOf(":") + 1));
                Assert.assertEquals(textBoxPage.getDataOfBox(inputBoxName), actualResult);
            }
        });
    }
}

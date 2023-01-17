Feature: I want to practice with https://demoqa.com/

  @p1
  Scenario Outline:
    Given As a user I open "https://demoqa.com/"
    When I click on "Elements" it directs me to the page where I see next options:
    |Text Box|
    |Check Box|
    |Radio Button|
    |Web Tables|
    |Buttons|
    |Links|
    |Broken Links - Images|
    |Upload and Download|
    |Dynamic Properties |
    And I click on "Text Box"
    * Fill in the random data into "Full Name" input box
    * Fill in the random data into "Email" input box
    * Fill in the random data into "Current Address" input box
    * Fill in the random data into "Permanent Address" input box
    Then I click Submit button
    And Verify the output data of "<input box>" is the same as input data

    Examples:
    |input box|
    |Full Name        |
    |Email       |
    |Current Address|
    |Permanent Address|

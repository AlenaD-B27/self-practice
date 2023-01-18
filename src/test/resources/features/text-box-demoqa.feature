Feature: I want to practice with https://demoqa.com/

  Background:
    Given As a user I open "DemoQa" homepage
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

  @p1 @ui
  Scenario Outline:

    And I click on "Text Box"
    * Fill in the random data into "Full Name" input box
    * Fill in the random data into "Email" input box
    * Fill in the random data into "Current Address" input box
    * Fill in the random data into "Permanent Address" input box
    Then I click Submit button
    And Verify the output data of "<output box>" is the same as input data

    Examples:
    |output box       |
    |Full Name        |
    |Email            |
    |Current Address  |
    |Permanent Address|

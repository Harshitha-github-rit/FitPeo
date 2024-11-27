Feature: FitPeo Revenue Calculator Test

  Scenario: Navigate to Revenue Calculator Page and adjust slider
    Given Navigate to the FitPeo Homepage
    When Click on Revenue Calculator Page
    Then Scroll down to the Slider section
    And Adjust the Slider to the value 820
    And Verify the updated value of 820 in the text field
    #When User entered value 560 into textbox
    #Then Validate slider position


  Scenario Outline: Select CPT Codes
    Given Navigate to the FitPeo Homepage
    When Click on Revenue Calculator Page
    Then Select the following CPT codes
    	|input1|input2|input3|input4|
    	|CPT-99091|CPT-99453|CPT-99454|CPT-99474|
    And Validate recurring payment
  
      
      
      
      
      
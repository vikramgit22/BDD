@smoke
Feature: Sample test to verify framework

@smoke
  Scenario: First demo testSmoke
    Given user enter URL on browser
    When clicked on enter
    Then homepage should be loaded


  @Negative
  Scenario: First demo testReg
    Given user enter URL on browser
    When clicked on enter
    Then homepage should be loaded
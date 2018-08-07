#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@web
Feature: 首頁搜尋功能
  
  Scenario: 首頁點選搜尋功能
    Given EAN訂房首頁
    When 點擊搜尋Bar
    Then 出現可選取地名
    When 點擊搜尋Bar
    Then Popup 消失
  
  Scenario Outline: 首頁搜尋功能
    Given EAN訂房首頁
    When 點擊搜尋Bar
    Then 出現可選取地名
    When 輸入搜尋字 "<keyword>"
    Then 出現搜尋結果

    Examples: 
      | keyword |
      | Hotel   |
      | 台				|
      | 台中			|

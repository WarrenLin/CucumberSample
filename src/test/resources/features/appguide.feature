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
@android_reinstall
Feature: 第一次安裝介紹頁面
  使用者第一次安裝呈現的4 card畫面

  @ios_reinstall 
  Scenario: 介紹頁面直接開始使用
    Given 介紹頁面呈現
    When 點擊開始使用
    Then 進入選擇位置畫面

  Scenario: 介紹頁面輸入MGM
    Given 介紹頁面呈現
    When 點擊輸入MGM按鈕
    Then 進入手機認證畫面
    When 輸入手機號碼 0900000000
    Then 進入輸入驗證碼畫面
    When 輸入驗證碼 1234
    Then 進入MGM畫面

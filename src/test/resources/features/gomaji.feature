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
@gomaji_checkout
Feature: 結帳
  RS 商品結帳功能

  Scenario: 商品頁面
    Given 打開商品頁面
    When 點擊馬上購買
    Then 出現結帳頁面,商品名稱一致     

  Scenario Outline: 前往購買頁面嘗試購買 
  	Given 打開商品頁面
  	When 點擊馬上購買
  	When 選擇數量 1
  	When 輸入mail "<mail>"
  	When 輸入名字 "<name>"
  	When 輸入手機 "<phone>"
  	When 選擇atm
  	When 點擊同意條款並送出訂單
  	Then 出現Popup "<mail>","<name>","<phone>" 確認畫面
  	
  Examples:
    | name | mail |	phone |
    | test | test@gomaji.com | 0900000000 |
    | James | james@gomaji.com | 0912345678 |
    | Fail | fail@gomaji.com | 123456789 |
  	
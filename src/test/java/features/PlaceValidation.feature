# Created By Rasheed
Feature: Validating Place API 

Scenario Outline: Verify that place is being successfully added using AddPlaceAPI
	Given Add Place payload with "<name>" "<language>" "<address>" 
	When User call "AddPlaceAPI" with post request
	Then the API call is success with status code 200
	And "status" in response body is "OK"
	And "scope" in response body is "APP"
	
	
Examples:
 | name | language | address |
 | AAA  | AAA      | AAAA    |
 | BBB  | BBB      | BBBB    |
 | CCC  | CCC      | CCCC    |

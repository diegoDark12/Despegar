#Author:  d.restrepo.florez@accenture.com
@Despegar
Feature: Flight booking on the Viva Air website
	As a Despegar customer
	I want to book a flight
	To go from Medellin to Bogota
	
	Background: Enter the Despegar home page
    Given I'm on the home page
	

@FistScenario
  Scenario Outline: Flight reservation
    When I book my flight <Numscenario>
    Then I validate the final purchase page
    Examples: 
   |Numscenario       |
   ##@externaldata@./src/test/resources/files/DataDespegar.xlsx@prueba1
   |2   |
   |3   |



























   

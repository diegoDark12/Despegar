package com.co.certification.despegarautomation.stepdefinitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import org.hamcrest.Matchers;

import com.co.certification.despegarautomation.questions.ThePage;
import com.co.certification.despegarautomation.tasks.BuyFlighs;
import com.co.certification.despegarautomation.tasks.OpenTheBrowser;
import com.co.certification.despegarautomation.tasks.SearchFligh;
import com.co.certification.despegarautomation.userinterfaces.DespegarHomePage;
import com.co.certification.despegarautomation.utils.Words;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class DespegarAutomationStepDefinition {
	private DespegarHomePage page;
	
	@Before
	public void init() {
		OnStage.setTheStage(new OnlineCast());
		OnStage.theActorCalled("diego");
	}
	
	@Given("^I'm on the home page$")
	public void iMOnTheHomePage() {
		theActorInTheSpotlight().wasAbleTo(OpenTheBrowser.open(page));
	}


	@When("^I book my flight (.*)$")
	public void iBookMyFlight(String numScenario) {
		theActorInTheSpotlight().attemptsTo(SearchFligh.searh(numScenario));
		theActorInTheSpotlight().attemptsTo(BuyFlighs.buy());
	}

	@Then("^I validate the final purchase page$")
	public void iValidateTheFinalPurchasePage() {
		theActorInTheSpotlight().should(seeThat(ThePage.validate(),Matchers.equalTo(Words.MESSAGE_FORM)));
	}


}

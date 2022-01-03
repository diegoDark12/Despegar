package com.co.certification.despegarautomation.tasks;

import org.openqa.selenium.TimeoutException;

import com.co.certification.despegarautomation.exceptions.WaitDespegarException;
import com.co.certification.despegarautomation.models.Data;
import com.co.certification.despegarautomation.userinterfaces.DespegarHomePage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class SearchFligh implements Task{
private String scenarioNumber;
	

	public SearchFligh(String scenarioNumber) {
		this.scenarioNumber = scenarioNumber;
	}
	

	@Override
	public <T extends Actor> void performAs(T actor) {
		
	   try {
		Data.dataLoad(scenarioNumber);
		 String[] dateSplit = (Data.data().getDateGo().split(" ")[0]).split("/");
		    int daySplit = 1+Integer.parseInt(dateSplit[0]);
		    String day = Integer.toString(daySplit);
		    
		    String[] dateSplitReturn = (Data.data().getDateReturn().split(" ")[0]).split("/");
		    int dayReturnSplit = 1+Integer.parseInt(dateSplitReturn[0]);
		    String dayReturn = Integer.toString(dayReturnSplit);
		actor.attemptsTo(WaitUntil.the(DespegarHomePage.CITY_ORIGIN,WebElementStateMatchers.isEnabled()).forNoMoreThan(5).seconds(),
				Click.on(DespegarHomePage.CITY_ORIGIN),
				Enter.theValue(" " + Data.data().getCityOrigin()).into(DespegarHomePage.CITY_ORIGIN),
				Click.on(DespegarHomePage.ITEM_CITY),
				Click.on(DespegarHomePage.CITY_DESTINATION),
				Enter.theValue(" " + Data.data().getCityDestination()).into(DespegarHomePage.CITY_DESTINATION),
				Click.on(DespegarHomePage.ITEM_CITY_DETINATION),
				Click.on(DespegarHomePage.DATE_GO),
				Click.on(DespegarHomePage.SELECT_DATE_GO.of(day)),
				Click.on(DespegarHomePage.SELECT_DATE_RETURN.of(dayReturn)),
				Click.on(DespegarHomePage.BUTTON_SEARCH));
	   }
	    catch (TimeoutException e) {
	      throw new WaitDespegarException(WaitDespegarException.MESSAGE_TIME_WAIT, e);
	    }
	}
	
	public static SearchFligh searh(String scenarioNumber) {
		return Tasks.instrumented(SearchFligh.class, scenarioNumber);
		
	}

}

package com.co.certification.despegarautomation.tasks;

import org.openqa.selenium.TimeoutException;

import com.co.certification.despegarautomation.exceptions.WaitDespegarException;
import com.co.certification.despegarautomation.userinterfaces.BuyFligh;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class BuyFlighs implements Task{

	@Override
	public <T extends Actor> void performAs(T actor) {
		
		try {
		actor.attemptsTo(
				WaitUntil.the(BuyFligh.BUTTON_BUY, WebElementStateMatchers.isVisible()).forNoMoreThan(5).seconds(),
				Click.on(BuyFligh.BUTTON_BUY),
				WaitUntil.the(BuyFligh.BUTTON_CONTINUE, WebElementStateMatchers.isClickable()).forNoMoreThan(5).seconds(),
				Click.on(BuyFligh.BUTTON_CONTINUE));
		
		}
	    catch (TimeoutException e) {
	      throw new WaitDespegarException(WaitDespegarException.MESSAGE_TIME_WAIT, e);
	    }
	}
	
	public static BuyFlighs buy() {
		return Tasks.instrumented(BuyFlighs.class);
	}

}

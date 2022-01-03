package com.co.certification.despegarautomation.tasks;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

public class OpenTheBrowser implements Task {
	
	private PageObject page;
	
	public OpenTheBrowser(PageObject page) {
		this.page = page;
	}


	@Override
	public <T extends Actor> void performAs(T actor) {
		
		actor.attemptsTo(Open.browserOn(page));
	}
	
	public static OpenTheBrowser open(PageObject page) {
		return Tasks.instrumented(OpenTheBrowser.class, page);
		
	}

}

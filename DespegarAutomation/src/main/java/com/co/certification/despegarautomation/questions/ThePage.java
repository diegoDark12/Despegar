package com.co.certification.despegarautomation.questions;

import com.co.certification.despegarautomation.userinterfaces.BuyFligh;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ThePage implements Question<String>{

	@Override
	public String answeredBy(Actor actor) {
		return Text.of(BuyFligh.PAY).viewedBy(actor).asString();
	}
	
	public static ThePage validate() {
		return new ThePage();
	}

}

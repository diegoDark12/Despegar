package com.co.certification.despegarautomation.userinterfaces;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class BuyFligh {
	public static final Target BUTTON_BUY = Target.the("Button buy").located(By.xpath("(//*[@class='btn-text'][text()='Comprar'])[1]"));
    public static final Target BUTTON_CONTINUE = Target.the("Button continue").located(By.xpath("//*[@class='btn-text'][text()='Continuar']"));
    public static final Target PAY = Target.the("Form for pay the fligh").located(By.xpath("//*[@class='chk-main-title -eva-3-hide-small -eva-3-hide-medium']"));

}

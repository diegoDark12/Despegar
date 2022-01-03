package com.co.certification.despegarautomation.userinterfaces;

import org.openqa.selenium.By;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.despegar.com.co/")
public class DespegarHomePage extends PageObject{
	public static final Target CITY_ORIGIN =  Target.the("Field for the city origin").located(By.xpath("(//*[@placeholder='Ingresa desde dónde viajas'])[1]"));
	public static final Target ITEM_CITY = Target.the("select city").locatedBy("//*[@class='item-text'][text() ='Medellín, Antioquia, Colombia']");
    public static final Target CITY_DESTINATION = Target.the("Field city destination").located(By.xpath("(//*[@placeholder='Ingresa hacia dónde viajas'])[1]"));
    public static final Target ITEM_CITY_DETINATION = Target.the("Selecet city destination").locatedBy("(//*[@class='item-text']//*[contains(text(),'Bogotá')])[1]");
    public static final Target DATE_GO = Target.the("Option for the date go").located(By.xpath("//*[@id=\"searchbox-sbox-box-flights\"]/div/div[2]/div[1]/div[1]/div[2]/div/div[1]/div/div/div/div"));
    public static final Target SELECT_DATE_GO = Target.the("Select in calendar the date go").locatedBy("(//*[@class='sbox5-monthgrid-datenumber-number'][text() ='{0}'])[1]");	
    public static final Target SELECT_DATE_RETURN = Target.the("Select in calendar the date return").locatedBy("(//*[@class='sbox5-monthgrid-datenumber-number'][text() ='{0}'])[1]");
    public static final Target BUTTON_SEARCH = Target.the("Buton search").located(By.xpath("//*[@class='btn-text'][text()='Buscar']"));
    

}

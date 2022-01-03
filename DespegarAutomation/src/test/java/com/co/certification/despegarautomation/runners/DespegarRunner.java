package com.co.certification.despegarautomation.runners;

import java.io.IOException;
import java.sql.SQLException;

import javax.xml.bind.JAXBException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.runner.RunWith;

import com.co.certification.despegarautomation.utils.SetFeature;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;

@RunWith(RunnerPersonalizado.class)
@CucumberOptions(
        features="src/test/resources/features/despegar_automation.feature",
        tags= {"@FistScenario"},
        glue="com.co.certification.despegarautomation.stepdefinitions",
        snippets=SnippetType.CAMELCASE,
        monochrome = true,
        dryRun = false
        )

public class DespegarRunner {

	@BeforeSuite
	public static void test() throws InvalidFormatException, IOException, JAXBException, SQLException {
		SetFeature.overrideFeatureFiles("src/test/resources/features/despegar_automation.feature");
	}


}

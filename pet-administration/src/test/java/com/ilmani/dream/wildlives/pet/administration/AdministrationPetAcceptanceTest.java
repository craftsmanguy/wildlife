package com.ilmani.dream.wildlives.pet.administration;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:featureRaceReport" }, features = { "src/test/resources/steps_definitions" })
public class AdministrationPetAcceptanceTest {

}

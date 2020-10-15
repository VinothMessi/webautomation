package com.nextgen.webautomation.testcases;

import com.nextgen.webautomation.base.TestBase;
import com.nextgen.webautomation.workflows.VisaRegistrationWorkFlow;

import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class VisaRegistrationTesting extends TestBase {

	@Value("${visa.app}")
	private String visaApp;

	@Test
	public void visaRegistration() {
		VisaRegistrationWorkFlow.visaPage((p) -> {
			p.goTo(visaApp);
			p.waitTillPageLoads();
			assertThat(p.getPageTitle()).isEqualTo("VISA Registration Form");
			p.startRegistration();
		}, myBrowser).visaRegistrationPage((p) -> {
			p.waitTillPageLoads();
			p.enterUserDetails("Kraig", "Wiza");
			p.enterCountryDetails("Isle of Man", "Mali");
			p.enterBirthDetails("JANUARY", "1", "2000");
			p.enterContactDetails("Kraig@nobody.com", "(162)", "387-0305");
			p.enterComments("Registration Completed Successfully");
			p.submitVisaForm();
		}, myBrowser).visaConfirmationPage((p) -> {
			p.waitTillPageLoads();
			p.getConfirmationMessage();
		}, myBrowser);
	}

}
package com.nextgen.webautomation.testcases;

import com.nextgen.webautomation.base.TestBase;
import com.nextgen.webautomation.entiry.User;
import com.nextgen.webautomation.repository.UserRepository;
import com.nextgen.webautomation.workflows.VisaRegistrationWorkFlow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class VisaRegistrationTesting extends TestBase {

	@Value("${visa.app}")
	private String visaApp;

	@Value("${page.title}")
	private String pageTitle;

	@Autowired
	private UserRepository repository;

	@Test(dataProvider = "VisaRegistration")
	public void visaRegistration(User u) {
		VisaRegistrationWorkFlow.visaPage((p) -> {
			p.goTo(this.visaApp);
			p.waitTillPageLoads();
			assertThat(p.getPageTitle()).matches((title) -> title.equals(this.pageTitle), "Page Title validation");
			p.startRegistration();
		}, myBrowser).visaRegistrationPage((p) -> {
			p.waitTillPageLoads();
			p.getElementValidators().stream().parallel().map(ev -> ev.validate()).forEach(b -> assertThat(b));
			p.enterUserDetails(u.getFirstName(), u.getLastName());
			p.enterCountryDetails(u.getFromCountry(), u.getToCountry());
			p.enterBirthDetails(u.getBirthMonth(), u.getBirthDay(), u.getBirthYear());
			p.enterContactDetails(u.getEmail(), u.getAreaCode(), u.getPhoneNumber());
			p.enterComments(u.getComments());
			p.submitVisaForm();
		}, myBrowser).visaConfirmationPage((p) -> {
			p.waitTillPageLoads();
			System.out.println(p.getConfirmationMessage());
		}, myBrowser);
	}

	@DataProvider(name = "VisaRegistration")
	private Object[] getData() {
		return this.repository.findAll().toArray();
	}

}
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
			p.goTo(this.visaApp).waitTillPageLoads();
			assertThat(p.getPageTitle()).matches((title) -> title.equals(this.pageTitle), "Page Title validation");
			p.startRegistration();
		}, myBrowser).visaRegistrationPage((p) -> {
			p.waitTillPageLoads().getElementValidators().stream().parallel().map(ev -> ev.validate())
					.forEach(b -> assertThat(b));
			p.enterUserDetails(u.getFirstName(), u.getLastName())
					.enterCountryDetails(u.getFromCountry(), u.getToCountry())
					.enterBirthDetails(u.getBirthMonth(), u.getBirthDay(), u.getBirthYear())
					.enterContactDetails(u.getEmail(), u.getAreaCode(), u.getPhoneNumber())
					.enterComments(u.getComments()).submitVisaForm();
		}, myBrowser).visaConfirmationPage((p) -> {
			System.out.println(p.waitTillPageLoads().getConfirmationMessage());
		}, myBrowser);
	}

	@DataProvider(name = "VisaRegistration")
	private Object[] getData() {
		return this.repository.findAll().toArray();
	}

}
package com.nextgen.webautomation.testcases;

import static org.assertj.core.api.Assertions.*;

import com.nextgen.webautomation.base.TestBase;
import com.nextgen.webautomation.workflows.DemoRegistrationWorkFlow;

import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.Test;

public class DemoRegistrationTesting extends TestBase {

	@Value("${demo.app}")
	private String demoApp;

	@Value("${demo.login.page.title}")
	private String loginPageTitle;

	@Value("${demo.webtable.page.title}")
	private String webTablePageTitle;

	@Test
	public void demoRegistration() {
		DemoRegistrationWorkFlow.loginPage((p) -> {
			p.goTo(this.demoApp);
			p.waitTillPageLoads();
			assertThat(p.getPageTitle()).matches(title -> title.equals(this.loginPageTitle), "Verifying Page Title");
			p.getElementValidators().stream().parallel().map(ev -> ev.validate()).forEach(b -> assertThat(b));
			p.logIn("vinothone2one@gmail.com");
		}, myBrowser).registrationPage((p) -> {
			p.waitTillPageLoads();
			p.getUserDetails().getElementValidators();
			p.getUserDetails().fillUserDetails("Lionel", "Messi", "Sample address");
			p.getContactDetails().getElementValidators();
			p.getContactDetails().fillContactDetails("test8@gmail.com", "1234567898");
			p.getGenderDetails().getElementValidators();
			p.getGenderDetails().fillGenderDetails("male");
			p.getHobbyDetails().getElementValidators();
			p.getHobbyDetails().fillHobby("cricket");
			p.getOtherDetails().getElementValidators();
			p.getOtherDetails().fillOtherDetails("APIs", "Australia");
			p.getBirthDetails().getElementValidators();
			p.getBirthDetails().fillBirthDetails("2000", "January", "10");
			p.setPasswords("Liverpool123!@", "Liverpool123!@");
			p.submit();
		}, myBrowser).webTablePage((p) -> {
			p.waitTillPageLoads();
			assertThat(p.getPageTitle()).matches(title -> title.equals(this.webTablePageTitle), "Verifying Page Title");
		}, myBrowser);
	}

}
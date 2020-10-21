package com.nextgen.webautomation.testcases;

import static org.assertj.core.api.Assertions.*;

import com.nextgen.webautomation.base.TestBase;
import com.nextgen.webautomation.entiry.Demo;
import com.nextgen.webautomation.repository.DemoRepository;
import com.nextgen.webautomation.workflows.DemoRegistrationWorkFlow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DemoRegistrationTesting extends TestBase {

	@Value("${demo.app}")
	private String demoApp;

	@Value("${demo.login.page.title}")
	private String loginPageTitle;

	@Value("${demo.webtable.page.title}")
	private String webTablePageTitle;

	@Value("${demo.app.user.name}")
	private String userName;

	@Autowired
	private DemoRepository repository;

	@Test(dataProvider = "DemoUserRegistration")
	public void demoRegistration(Demo u) {
		DemoRegistrationWorkFlow.loginPage((p) -> {
			p.goTo(this.demoApp);
			p.waitTillPageLoads();
			assertThat(p.getPageTitle()).matches(title -> title.equals(this.loginPageTitle), "Verifying Page Title");
			p.getElementValidators().stream().parallel().map(ev -> ev.validate()).forEach(b -> assertThat(b));
			p.logIn(this.userName);
		}, myBrowser).registrationPage((p) -> {
			p.waitTillPageLoads();
			p.getUserDetails().getElementValidators();
			p.getUserDetails().fillUserDetails(u.getFirstName(), u.getLastName(), u.getAddress());
			p.getContactDetails().getElementValidators();
			p.getContactDetails().fillContactDetails(u.getEmail(), u.getPhoneNumber());
			p.getGenderDetails().getElementValidators();
			p.getGenderDetails().fillGenderDetails(u.getGender());
			p.getHobbyDetails().getElementValidators();
			p.getHobbyDetails().fillHobby(u.getHobby());
			p.getOtherDetails().getElementValidators();
			p.getOtherDetails().fillOtherDetails(u.getSkill(), u.getCountry());
			p.getBirthDetails().getElementValidators();
			p.getBirthDetails().fillBirthDetails(u.getBirthYear(), u.getBirthMonth(), u.getBirthDay());
			p.setPasswords(u.getPassword(), u.getPassword());
			p.submit();
		}, myBrowser).webTablePage((p) -> {
			p.waitTillPageLoads();
			assertThat(p.getPageTitle()).matches(title -> title.equals(this.webTablePageTitle), "Verifying Page Title");
		}, myBrowser);
	}

	@DataProvider(name = "DemoUserRegistration")
	private Object[] getData() {
		return this.repository.findAll().toArray();
	}

}
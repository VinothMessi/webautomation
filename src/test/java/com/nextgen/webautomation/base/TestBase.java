package com.nextgen.webautomation.base;

import com.nextgen.webautomation.browser.config.BrowserFactory;
import com.nextgen.webautomation.visaapppages.VisaConfirmationPage;
import com.nextgen.webautomation.visaapppages.VisaPage;
import com.nextgen.webautomation.visaapppages.VisaRegistrationPage;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@SpringBootTest
public class TestBase extends AbstractTestNGSpringContextTests {

	@Value("${visa.app}")
	private String visaApp;

	@Value("${browser.name}")
	private String browserName;

	@Autowired
	private ApplicationContext ctx;

	protected WebDriver myBrowser;

	protected VisaPage visaPage;
	protected VisaRegistrationPage registrationPage;
	protected VisaConfirmationPage confirmationPage;

	@BeforeClass
	public void before_each_testClass() {
		myBrowser = BrowserFactory.launch(this.browserName, this.ctx);
		visaPage = new VisaPage(myBrowser);
	}

	@AfterClass
	public void after_each_testClass() {
		myBrowser.quit();
	}

}
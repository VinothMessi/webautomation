package com.nextgen.webautomation.base;

import com.nextgen.webautomation.browser.config.BrowserFactory;

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

	@BeforeClass
	public void before_each_testClass() {
		myBrowser = BrowserFactory.launch(this.browserName, this.ctx);
	}

	@AfterClass
	public void after_each_testClass() {
		myBrowser.quit();
	}

}
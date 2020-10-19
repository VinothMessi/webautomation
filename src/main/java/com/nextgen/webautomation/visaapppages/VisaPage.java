package com.nextgen.webautomation.visaapppages;

import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;

import com.nextgen.webautomation.basepage.BasePage;

import org.awaitility.Awaitility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VisaPage extends BasePage {

	@FindBy(className = "jotform-form")
	private WebElement form;

	public VisaPage(WebDriver driver) {
		super(driver);
	}

	public void goTo(String url) {
		get.accept(myDriver, url);
	}

	public String getPageTitle() {
		return getTitle.apply(myDriver);
	}

	public VisaRegistrationPage startRegistration() {
		clickOn.accept(this.form);
		return new VisaRegistrationPage(myDriver);
	}

	@Override
	public void waitTillPageLoads() {
		Awaitility.await("Wait till Registration form is displayed").atMost(10, TimeUnit.SECONDS)
				.until(() -> isDisplayed.test(form));
	}

}
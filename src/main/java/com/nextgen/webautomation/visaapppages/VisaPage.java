package com.nextgen.webautomation.visaapppages;

import java.util.concurrent.TimeUnit;

import com.nextgen.webautomation.basepage.BasePage;

import static org.awaitility.Awaitility.*;
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
		await("Wait till Registration form is displayed").atMost(10, TimeUnit.SECONDS)
				.until(() -> isDisplayed.test(form));
	}

}
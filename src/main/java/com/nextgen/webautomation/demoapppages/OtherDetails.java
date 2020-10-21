package com.nextgen.webautomation.demoapppages;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.nextgen.webautomation.actions.MyActions;
import com.nextgen.webautomation.validator.ElementValidator;
import com.nextgen.webautomation.validator.Validator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.awaitility.Awaitility.*;

public class OtherDetails implements MyActions {

	@FindBy(id = "msdd")
	private WebElement language;

	@FindBy(xpath = "//div[@id='msdd']/following-sibling::div/child::ul/li")
	private List<WebElement> languages;

	@FindBy(id = "Skills")
	private WebElement skills;

	@FindBy(id = "countries")
	private WebElement country;

	@FindBy(xpath = "//span[@role='combobox']")
	private WebElement selectCountry;

	public OtherDetails(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public List<Validator> getElementValidators() {
		return Arrays.asList(new ElementValidator(this.language), new ElementValidator(this.skills),
				new ElementValidator(this.country), new ElementValidator(this.selectCountry));
	}

	public void fillOtherDetails(String skill, String country) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> isDisplayed.and(isEnabled).test(this.skills));
		selectText.accept(skill, this.skills);
		selectText.accept(country, this.country);
	}

}
package com.nextgen.webautomation.demoapppages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import com.nextgen.webautomation.actions.MyActions;

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

	public void select(String skill, String country) {
		await().atMost(10, TimeUnit.SECONDS).until(() -> isDisplayed.and(isEnabled).test(this.skills));
		selectText.accept(skill, this.skills);
		selectText.accept(country, this.country);
	}

}
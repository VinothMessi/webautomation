package com.nextgen.webautomation.visaapppages;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.nextgen.webautomation.basepage.BasePage;
import com.nextgen.webautomation.validator.ElementValidator;
import com.nextgen.webautomation.validator.Validator;

import static org.awaitility.Awaitility.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VisaRegistrationPage extends BasePage {

	@FindBy(id = "header_1")
	private WebElement pageHeader;

	@FindBy(id = "subHeader_1")
	private WebElement pageSubHeader;

	@FindBy(id = "first_4")
	private WebElement firstName;

	@FindBy(id = "middle_4")
	private WebElement middleName;

	@FindBy(id = "last_4")
	private WebElement lastName;

	@FindBy(id = "input_46")
	private WebElement fromCountry;

	@FindBy(id = "input_47")
	private WebElement toCountry;

	@FindBy(id = "input_24_month")
	private WebElement birthMonth;

	@FindBy(id = "input_24_day")
	private WebElement birthDay;

	@FindBy(id = "input_24_year")
	private WebElement birthYear;

	@FindBy(id = "input_6")
	private WebElement userEmail;

	@FindBy(id = "input_27_area")
	private WebElement areaCode;

	@FindBy(id = "input_27_phone")
	private WebElement phoneNumber;

	@FindBy(id = "input_45")
	private WebElement adComments;

	@FindBy(id = "submitBtn")
	private WebElement submit;

	public VisaRegistrationPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public void waitTillPageLoads() {
		await("Wait till Page header and Sub header are displayed").atMost(10, TimeUnit.SECONDS).until(
				() -> isDisplayed.test(pageHeader) && isDisplayed.test(pageSubHeader));
	}

	public void enterUserDetails(String fName, String lName) {
		type.accept(this.firstName, fName);
		type.accept(this.lastName, lName);
	}

	public void enterCountryDetails(String fCountry, String tCountry) {
		selectText.accept(fCountry, this.fromCountry);
		selectText.accept(tCountry, this.toCountry);
	}

	public void enterBirthDetails(String bMonth, String bDay, String bYear) {
		selectValue.accept(bMonth, this.birthMonth);
		selectValue.accept(bDay, this.birthDay);
		selectValue.accept(bYear, this.birthYear);
	}

	public void enterContactDetails(String eMail, String aCode, String phNumber) {
		type.accept(this.userEmail, eMail);
		type.accept(this.areaCode, aCode);
		type.accept(this.phoneNumber, phNumber);
	}

	public void enterComments(String comments) {
		type.accept(this.adComments, comments);
	}

	public VisaConfirmationPage submitVisaForm() {
		clickOn.accept(this.submit);
		return new VisaConfirmationPage(myDriver);
	}

	public List<Validator> getElementValidators() {
		return Arrays.asList(new ElementValidator(this.firstName), new ElementValidator(this.middleName),
				new ElementValidator(this.lastName), new ElementValidator(this.fromCountry),
				new ElementValidator(this.toCountry), new ElementValidator(this.birthMonth),
				new ElementValidator(this.birthDay), new ElementValidator(this.birthYear),
				new ElementValidator(this.userEmail), new ElementValidator(this.areaCode),
				new ElementValidator(this.phoneNumber), new ElementValidator(this.adComments));
	}

}
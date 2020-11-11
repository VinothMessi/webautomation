package com.nextgen.webautomation.stratergypatternapp;

import com.nextgen.webautomation.actions.MyActions;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreditCard implements PaymentOptions, MyActions {

	@FindBy(id = "cc")
	private WebElement cc;

	@FindBy(id = "year")
	private WebElement year;

	@FindBy(id = "cvv")
	private WebElement cvv;

	@Override
	public void enterDetails(Map<String, String> paymentDetails) {
		type.accept(this.cc, paymentDetails.get("cc"));
		type.accept(this.year, paymentDetails.get("year"));
		type.accept(this.cvv, paymentDetails.get("cvv"));
	}

}
package com.nextgen.webautomation.stratergypatternapp;

import com.nextgen.webautomation.actions.MyActions;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NetBanking implements PaymentOptions, MyActions {

	@FindBy(id = "bank")
	private WebElement banks;

	@FindBy(id = "acc_number")
	private WebElement accNumber;

	@FindBy(id = "pin")
	private WebElement pin;

	@Override
	public void enterDetails(Map<String, String> paymentDetails) {
		selectValue.accept(paymentDetails.get("bank"), this.banks);
		type.accept(this.accNumber, paymentDetails.get("accountNumber"));
		type.accept(this.pin, paymentDetails.get("atmPin"));
	}

}
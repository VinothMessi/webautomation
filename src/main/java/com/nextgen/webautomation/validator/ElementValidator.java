package com.nextgen.webautomation.validator;

import com.nextgen.webautomation.actions.MyActions;

import org.openqa.selenium.WebElement;

public class ElementValidator implements Validator {

	private WebElement lElement;

	public ElementValidator(WebElement element) {
		this.lElement = element;
	}

	@Override
	public boolean validate() {
		return MyActions.isDisplayed.and(MyActions.isEnabled).test(this.lElement);
	}

}
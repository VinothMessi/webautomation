package com.nextgen.webautomation.workflows;

import java.util.function.Consumer;

import org.openqa.selenium.WebDriver;

import com.nextgen.webautomation.stratergypatternapp.PaymentPage;

public class PaymentWorkFlow {

	// This is static to give an entry point
	public static void paymentPage(Consumer<PaymentPage> c, WebDriver driver) {
		PaymentPage p = new PaymentPage(driver);
		c.accept(p);
	}

}
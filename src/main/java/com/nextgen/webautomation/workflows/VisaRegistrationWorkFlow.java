package com.nextgen.webautomation.workflows;

import java.util.function.Consumer;

import com.nextgen.webautomation.visaapppages.VisaConfirmationPage;
import com.nextgen.webautomation.visaapppages.VisaPage;
import com.nextgen.webautomation.visaapppages.VisaRegistrationPage;

import org.openqa.selenium.WebDriver;

public class VisaRegistrationWorkFlow {

    // This is static to give an entry point
    public static VisaRegistrationWorkFlow visaPage(Consumer<VisaPage> c, WebDriver driver) {
        VisaPage p = new VisaPage(driver);
        c.accept(p);
        return new VisaRegistrationWorkFlow();
    }


    public VisaRegistrationWorkFlow visaRegistrationPage(Consumer<VisaRegistrationPage> c, WebDriver driver) {
        VisaRegistrationPage p = new VisaRegistrationPage(driver);
        c.accept(p);
        return new VisaRegistrationWorkFlow();
    }


    public void visaConfirmationPage(Consumer<VisaConfirmationPage> c, WebDriver driver) {
        VisaConfirmationPage p = new VisaConfirmationPage(driver);
        c.accept(p);
    }

}
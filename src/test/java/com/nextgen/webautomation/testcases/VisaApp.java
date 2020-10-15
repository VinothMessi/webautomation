package com.nextgen.webautomation.testcases;

import com.nextgen.webautomation.base.TestBase;

import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class VisaApp extends TestBase {

    @Value("${visa.app}")
    private String visaApp;

    @Test
    public void visaRegistration() {
        visaPage.goTo(visaApp);
        visaPage.waitTillPageLoads();
        assertThat(visaPage.getPageTitle()).isEqualTo("VISA Registration Form");

        registrationPage = visaPage.startRegistration();
        registrationPage.waitTillPageLoads();
        registrationPage.enterUserDetails("Kraig", "Wiza");
        registrationPage.enterCountryDetails("Isle of Man", "Mali");
        registrationPage.enterBirthDetails("JANUARY", "1", "2000");
        registrationPage.enterContactDetails("Kraig@nobody.com", "(162)", "387-0305");
        registrationPage.enterComments("Registration Completed Successfully");

        confirmationPage = registrationPage.submitVisaForm();
        confirmationPage.waitTillPageLoads();
        System.out.println(confirmationPage.getConfirmationMessage());
    }

}
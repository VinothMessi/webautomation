package com.nextgen.webautomation.workflows;

import java.util.function.Consumer;

import com.nextgen.webautomation.demoapppages.LoginPage;
import com.nextgen.webautomation.demoapppages.RegisterationPage;
import com.nextgen.webautomation.demoapppages.WebTablePage;

import org.openqa.selenium.WebDriver;

public class DemoRegistrationWorkFlow {

    // This is static to give an entry point
    public static DemoRegistrationWorkFlow loginPage(Consumer<LoginPage> c, WebDriver driver) {
        LoginPage p = new LoginPage(driver);
        c.accept(p);
        return new DemoRegistrationWorkFlow();
    }

    public DemoRegistrationWorkFlow registrationPage(Consumer<RegisterationPage> c, WebDriver driver) {
        RegisterationPage p = new RegisterationPage(driver);
        c.accept(p);
        return new DemoRegistrationWorkFlow();
    }

    public void webTablePage(Consumer<WebTablePage> c, WebDriver driver) {
        WebTablePage p = new WebTablePage(driver);
        c.accept(p);
    }

}
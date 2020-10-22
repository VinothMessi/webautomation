package com.nextgen.webautomation.demoapppages;

import com.nextgen.webautomation.actions.MyActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactDetails implements MyActions {

    @FindBy(xpath = "//input[@ng-model='EmailAdress']")
    private WebElement email;

    @FindBy(xpath = "//input[@ng-model='Phone']")
    private WebElement phone;

    public ContactDetails(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void fill(String mail, String ph) {
        type.accept(this.email, mail);
        type.accept(this.phone, ph);
    }

}
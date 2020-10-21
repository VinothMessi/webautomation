package com.nextgen.webautomation.demoapppages;

import java.util.Arrays;
import java.util.List;

import com.nextgen.webautomation.actions.MyActions;
import com.nextgen.webautomation.validator.ElementValidator;
import com.nextgen.webautomation.validator.Validator;

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

    public List<Validator> getElementValidators() {
        return Arrays.asList(new ElementValidator(this.email), new ElementValidator(this.phone));
    };

    public void fillContactDetails(String mail, String ph) {
        type.accept(this.email, mail);
        type.accept(this.phone, ph);
    }

}
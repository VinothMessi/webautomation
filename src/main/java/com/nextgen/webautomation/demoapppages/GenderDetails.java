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

public class GenderDetails implements MyActions {

    @FindBy(xpath = "//input[@value='Male']")
    private WebElement male;

    @FindBy(xpath = "//input[@value='FeMale']")
    private WebElement female;

    public GenderDetails(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public List<Validator> getElementValidators() {
        return Arrays.asList(new ElementValidator(this.male), new ElementValidator(this.female));
    };

    public void fillGenderDetails(String gender) {
        if (gender.equals("male")) {
            clickOn.accept(this.male);
        } else {
            clickOn.accept(this.female);
        }
    }

}
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

public class UserDetails implements MyActions {

    @FindBy(xpath = "//input[@placeholder='First Name']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    private WebElement lastName;

    @FindBy(xpath = "//textarea[@ng-model='Adress']")
    private WebElement address;

    public UserDetails(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public List<Validator> getElementValidators() {
        return Arrays.asList(new ElementValidator(this.firstName), new ElementValidator(this.lastName),
                new ElementValidator(this.address));
    };

    public void fillUserDetails(String fName, String lName, String add) {
        type.accept(this.firstName, fName);
        type.accept(this.lastName, lName);
        type.accept(this.address, add);
    }

}
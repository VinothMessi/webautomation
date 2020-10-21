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

public class BirthDetails implements MyActions {

    @FindBy(id = "yearbox")
    private WebElement yearOfBirth;

    @FindBy(xpath = "//select[@placeholder='Month']")
    private WebElement monthOfBirth;

    @FindBy(id = "daybox")
    private WebElement dayOfBirth;

    public BirthDetails(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public List<Validator> getElementValidators() {
        return Arrays.asList(new ElementValidator(this.yearOfBirth), new ElementValidator(this.monthOfBirth),
                new ElementValidator(this.dayOfBirth));
    }

    public void fillBirthDetails(String year, String month, String day) {
        selectText.accept(year, this.yearOfBirth);
        selectText.accept(month, this.monthOfBirth);
        selectText.accept(day, this.dayOfBirth);
    }

}
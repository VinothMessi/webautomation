package com.nextgen.webautomation.demoapppages;

import com.nextgen.webautomation.actions.MyActions;

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

    public void enter(String fName, String lName, String add) {
        type.accept(this.firstName, fName);
        type.accept(this.lastName, lName);
        type.accept(this.address, add);
    }

}
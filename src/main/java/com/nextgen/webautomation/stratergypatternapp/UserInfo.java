package com.nextgen.webautomation.stratergypatternapp;

import com.nextgen.webautomation.actions.MyActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserInfo implements MyActions {

    @FindBy(id = "fn")
    private WebElement firstName;

    @FindBy(id = "ln")
    private WebElement lastName;

    @FindBy(id = "email")
    private WebElement email;

    public UserInfo(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void enter(String fName, String lName, String mail) {
        type.accept(this.firstName, fName);
        type.accept(this.lastName, lName);
        type.accept(this.email, mail);
    }

}
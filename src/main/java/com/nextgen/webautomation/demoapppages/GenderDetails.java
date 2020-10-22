package com.nextgen.webautomation.demoapppages;

import java.util.List;

import com.nextgen.webautomation.actions.MyActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GenderDetails implements MyActions {

    @FindBy(xpath = "//label[text()='Gender*']/following::div[1]/label")
    private List<WebElement> genders;

    @FindBy(xpath = "//input[@value='Male']")
    private WebElement male;

    @FindBy(xpath = "//input[@value='FeMale']")
    private WebElement female;

    public GenderDetails(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void chooseGender(String gender) {
        this.genders.stream().filter(e -> e.getText().trim().equals(gender)).forEach(e -> e.click());
    }

}
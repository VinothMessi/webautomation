package com.nextgen.webautomation.demoapppages;

import com.nextgen.webautomation.basepage.BasePage;
import com.nextgen.webautomation.validator.ElementValidator;
import com.nextgen.webautomation.validator.Validator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.awaitility.Awaitility.*;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginPage extends BasePage {

    @FindBy(id = "logo")
    private WebElement logo;

    @FindBy(id = "email")
    private WebElement signUp;

    @FindBy(id = "enterimg")
    private WebElement enter;

    @FindBy(id = "btn1")
    private WebElement signIn;

    @FindBy(id = "btn2")
    private WebElement skipSignIn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage goTo(String url) {
        get.accept(myDriver, url);
        return this;
    }

    public String getPageTitle() {
        return getTitle.apply(myDriver);
    }

    @Override
    public LoginPage waitTillPageLoads() {
        await("Wait till enter option is displayed and enabled").atMost(10, TimeUnit.SECONDS)
                .until(() -> isDisplayed.and(isEnabled).test(enter));
        return this;
    }

    public List<Validator> getElementValidators() {
        return Arrays.asList(new ElementValidator(logo), new ElementValidator(signUp), new ElementValidator(signIn),
                new ElementValidator(skipSignIn));
    }

    public void logIn(String mailID) {
        type.accept(signUp, mailID);
        clickOn.accept(enter);
    }

}
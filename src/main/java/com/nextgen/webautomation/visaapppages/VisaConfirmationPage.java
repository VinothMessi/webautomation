package com.nextgen.webautomation.visaapppages;

import java.util.concurrent.TimeUnit;

import com.nextgen.webautomation.basepage.BasePage;

import static org.awaitility.Awaitility.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VisaConfirmationPage extends BasePage {

    @FindBy(id = "panel")
    private WebElement messagePanel;

    @FindBy(id = "requestnumber")
    private WebElement requestNumber;

    public VisaConfirmationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitTillPageLoads() {
        await().atMost(10, TimeUnit.SECONDS).until(() -> !getText.apply(this.requestNumber).isEmpty());
    }

    public String getConfirmationMessage() {
        return getText.apply(this.messagePanel);
    }

}
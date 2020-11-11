package com.nextgen.webautomation.stratergypatternapp;

import com.nextgen.webautomation.actions.MyActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderInfo implements MyActions {

    @FindBy(id = "buy")
    private WebElement buyNow;

    @FindBy(id = "ordernumber")
    private WebElement orderNumber;

    public OrderInfo(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void placeOrder() {
        clickOn.accept(this.buyNow);
    }

    public String getOrderNumber() {
        return getText.apply(this.orderNumber);
    }

}
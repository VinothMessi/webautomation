package com.nextgen.webautomation.stratergypatternapp;

import com.nextgen.webautomation.basepage.BasePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.awaitility.Awaitility.*;

import java.util.concurrent.TimeUnit;

public class PaymentPage extends BasePage {

    private UserInfo userInfo;
    private OrderInfo orderInfo;
    private PaymentOptions paymentOptions;

    @FindBy(id = "ecomsite")
    private WebElement table;

    public PaymentPage(WebDriver driver) {
        super(driver);
        setUserInfo(new UserInfo(driver));
        setOrderInfo(new OrderInfo(driver));
    }

    public PaymentPage goTo(String url) {
        get.accept(myDriver, url);
        return this;
    }

    @Override
    public PaymentPage waitTillPageLoads() {
        await().atMost(10, TimeUnit.SECONDS).until(() -> isDisplayed.and(isEnabled).test(this.table));
        return this;
    }

    public String getPageTitle() {
        return getTitle.apply(myDriver);
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public OrderInfo getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }

    public PaymentOptions getPaymentOptions() {
        return paymentOptions;
    }

    public void setPaymentOptions(PaymentOptions paymentOptions) {
        this.paymentOptions = paymentOptions;
        PageFactory.initElements(myDriver, this.paymentOptions);
    }

}
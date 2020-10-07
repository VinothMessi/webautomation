package com.nextgen.webautomation.testcases;

import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.Uninterruptibles;
import com.nextgen.webautomation.base.TestBase;

import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.Test;

public class Sanity5 extends TestBase {

    @Value("${app.url5}")
    private String appURL5;

    @Test
    public void sanitycheck() {
        browser.get(this.appURL5);
        System.out.println("Page Title: " + browser.getTitle());
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
    }

}
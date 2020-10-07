package com.nextgen.webautomation.testcases;

import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.Uninterruptibles;
import com.nextgen.webautomation.base.TestBase;

import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.Test;

public class Sanity3 extends TestBase {

    @Value("${app.url3}")
    private String appURL3;

    @Test
    public void sanitycheck() {
        browser.get(this.appURL3);
        System.out.println("Page Title: " + browser.getTitle());
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
    }

}
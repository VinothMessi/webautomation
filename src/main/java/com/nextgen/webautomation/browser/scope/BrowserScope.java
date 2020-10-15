package com.nextgen.webautomation.browser.scope;

import java.util.Objects;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.SimpleThreadScope;

public class BrowserScope extends SimpleThreadScope {

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        Object obj = super.get(name, objectFactory);
        if (Objects.isNull(((RemoteWebDriver) obj).getSessionId())) {
            super.remove(name);
            obj = super.get(name, objectFactory);
        }
        return obj;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {
    }

}
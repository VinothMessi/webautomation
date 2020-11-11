package com.nextgen.webautomation.actions;

import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import static org.awaitility.Awaitility.*;
import static org.assertj.core.api.Assertions.*;

public interface Activities {

    Consumer<Object> isNotNull = i -> {
        assertThat(i).isNotNull();
    };

    Consumer<Object> isNotEmpty = i -> {
        assertThat(i).asString().isNotEmpty();
    };

    Consumer<Object> isNotBlank = i -> {
        assertThat(i).asString().isNotBlank();
    };

    BiConsumer<String, WebDriver> goTo = (url, d) -> {
        isNotNull.andThen(isNotEmpty).andThen(isNotBlank).accept(url);
        isNotNull.accept(d);
        d.get(url);
    };

    Function<WebDriver, String> getPageTitle = d -> {
        isNotNull.accept(d);
        String pageTitle = d.getTitle();
        isNotNull.andThen(isNotEmpty).andThen(isNotBlank).accept(pageTitle);
        return pageTitle;
    };

    Predicate<WebElement> canWeSee = e -> {
        await("wait till element is displayed").atMost(10, TimeUnit.SECONDS).until(() -> e.isDisplayed());
        return true;
    };

    Predicate<WebElement> canWeClick = e -> {
        await("wait till element is enabled").atMost(10, TimeUnit.SECONDS).until(() -> e.isEnabled());
        return true;
    };

    Consumer<WebElement> clear = e -> {
        canWeSee.and(canWeClick).test(e);
        e.clear();
    };

    Consumer<WebElement> click = e -> {
        canWeSee.and(canWeClick).test(e);
        e.click();
    };

    Function<WebElement, String> getText = e -> {
        canWeSee.and(canWeClick).test(e);
        String text = e.getText();
        isNotNull.andThen(isNotEmpty).andThen(isNotBlank).accept(text);
        return text;
    };

    BiConsumer<String, WebElement> type = (s, e) -> {
        isNotNull.andThen(isNotEmpty).andThen(isNotBlank).accept(s);
        canWeSee.and(canWeClick).test(e);
        e.sendKeys(s);
    };

    BiFunction<String, WebElement, Select> select = (s, e) -> {
        isNotNull.andThen(isNotEmpty).andThen(isNotBlank).accept(s);
        canWeSee.and(canWeClick).test(e);
        Select dropDown = new Select(e);
        return dropDown;
    };
    BiConsumer<String, WebElement> selectTheText = (s, e) -> select.apply(s, e).selectByVisibleText(s);
    BiConsumer<String, WebElement> selectTheValue = (s, e) -> select.apply(s, e).selectByValue(s);
    BiConsumer<String, WebElement> selectTheInteger = (s, e) -> select.apply(s, e).selectByIndex(Integer.parseInt(s));

    Function<WebDriver, Actions> actions = d -> {
        Actions action = new Actions(d);
        return action;
    };
    BiConsumer<WebElement, WebDriver> mouseOver = (e, d) -> actions.apply(d).moveToElement(e).build().perform();
    BiConsumer<WebElement, WebDriver> clickOn = (e, d) -> actions.apply(d).click(e).build().perform();
    BiConsumer<WebElement, WebDriver> rightClick = (e, d) -> actions.apply(d).contextClick(e).build().perform();
    BiConsumer<WebElement, WebDriver> doubleClick = (e, d) -> actions.apply(d).doubleClick(e).build().perform();
    BiConsumer<WebElement, WebDriver> clickAndHold = (e, d) -> actions.apply(d).clickAndHold(e).build().perform();

    BiConsumer<String, WebDriver> switchToWindowByTitle = (s, d) -> {
        d.getWindowHandles().stream().map(handle -> d.switchTo().window(handle).getTitle()).filter(t -> t.startsWith(s))
                .findFirst().orElseThrow(() -> {
                    throw new RuntimeException("No such window");
                });
    };

    BiConsumer<Integer, WebDriver> switchToWindowByIndex = (i, d) -> {
        String[] handles = d.getWindowHandles().toArray(new String[0]);
        d.switchTo().window(handles[i]);
    };
}
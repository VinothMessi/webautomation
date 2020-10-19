package com.nextgen.webautomation.actions;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public interface MyActions {

	Consumer<String> print = System.out::println;

	Consumer<WebDriver> quit = WebDriver::quit;
	Consumer<WebDriver> close = WebDriver::close;
	Consumer<WebElement> clearOut = WebElement::clear;
	Consumer<WebElement> clickOn = WebElement::click;

	BiFunction<WebDriver, By, WebElement> find = WebDriver::findElement;
	BiFunction<WebDriver, By, List<WebElement>> findAll = WebDriver::findElements;
	BiConsumer<WebDriver, String> get = WebDriver::get;
	Function<WebDriver, String> getTitle = WebDriver::getTitle;

	BiConsumer<WebElement, String> type = WebElement::sendKeys;
	Function<WebElement, String> getText = WebElement::getText;

	Predicate<WebElement> isDisplayed = WebElement::isDisplayed;
	Predicate<WebElement> isEnabled = WebElement::isEnabled;
	Predicate<WebElement> isSelected = WebElement::isSelected;

	Function<WebElement, Select> dropDown = e -> new Select(e);
	BiConsumer<String, WebElement> selectText = (s, e) -> dropDown.apply(e).selectByVisibleText(s);
	BiConsumer<String, WebElement> selectValue = (s, e) -> dropDown.apply(e).selectByValue(s);
	BiConsumer<String, WebElement> selectIndex = (s, e) -> dropDown.apply(e).selectByIndex(Integer.parseInt(s));

}
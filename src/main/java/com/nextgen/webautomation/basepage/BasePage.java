package com.nextgen.webautomation.basepage;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public abstract class BasePage {

	protected WebDriver myDriver;
	private Consumer<WebDriver> maximize = d -> d.manage().window().maximize();

	public BasePage(WebDriver driver) {
		maximize.accept(driver);
		myDriver = driver;
		PageFactory.initElements(myDriver, this);
	}

	protected abstract void waitTillPageLoads();

	protected BiFunction<WebDriver, By, WebElement> find = WebDriver::findElement;
	protected BiFunction<WebDriver, By, List<WebElement>> findAll = WebDriver::findElements;
	protected BiConsumer<WebDriver, String> get = WebDriver::get;
	protected Function<WebDriver, String> getTitle = WebDriver::getTitle;

	protected Consumer<WebElement> clickOn = WebElement::click;
	protected BiConsumer<WebElement, String> type = WebElement::sendKeys;
	protected Function<WebElement, Boolean> isDisplayed = WebElement::isDisplayed;
	protected Function<WebElement, String> getText = WebElement::getText;

	protected Function<WebElement, Select> dropDown = e -> new Select(e);
	protected BiConsumer<String, WebElement> selectText = (s, e) -> dropDown.apply(e).selectByVisibleText(s);
	protected BiConsumer<String, WebElement> selectValue = (s, e) -> dropDown.apply(e).selectByValue(s);
	protected BiConsumer<String, WebElement> selectIndex = (s, e) -> dropDown.apply(e)
			.selectByIndex(Integer.parseInt(s));

}
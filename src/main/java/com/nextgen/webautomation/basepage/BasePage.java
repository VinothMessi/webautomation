package com.nextgen.webautomation.basepage;

import java.util.function.Consumer;
import java.util.function.Predicate;

import com.nextgen.webautomation.actions.MyActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage implements MyActions {

	protected WebDriver myDriver;
	private Consumer<WebDriver> maximize = d -> d.manage().window().maximize();

	public BasePage(WebDriver driver) {
		maximize.accept(driver);
		myDriver = driver;
		PageFactory.initElements(myDriver, this);
	}

	protected abstract void waitTillPageLoads();
>
}
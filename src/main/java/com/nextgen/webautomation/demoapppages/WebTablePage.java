package com.nextgen.webautomation.demoapppages;

import com.nextgen.webautomation.basepage.BasePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.awaitility.Awaitility.*;

import java.util.concurrent.TimeUnit;

public class WebTablePage extends BasePage {

	@FindBy(xpath = "//div[@class='ui-grid-contents-wrapper']")
	private WebElement userTable;

	public WebTablePage(WebDriver driver) {
		super(driver);
	}

	@Override
	public void waitTillPageLoads() {
		await("Wait till page title is not empty").atMost(20, TimeUnit.SECONDS)
				.until(() -> getTitle.apply(myDriver).contains("Table"));
	}

	public String getPageTitle() {
		return getTitle.apply(myDriver);
	}

}
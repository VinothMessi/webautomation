package com.nextgen.webautomation.demoapppages;

import java.util.List;

import com.nextgen.webautomation.actions.MyActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HobbyDetails implements MyActions {
	
	@FindBy(xpath = "//label[text()='Hobbies']/following::div[1]/div")
	private List<WebElement> hobbies;

    @FindBy(id = "checkbox1")
    private WebElement cricket;

    @FindBy(id = "checkbox2")
    private WebElement movies;

    @FindBy(id = "checkbox3")
    private WebElement hockey;

    public HobbyDetails(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    
    public void chooseHobby(String hobby) {
        this.hobbies.stream()
        .filter(e -> e.findElement(By.tagName("input")).getAttribute("value").trim().equals(hobby))
        .forEach(e -> e.click());
    }

}
package com.nextgen.webautomation.demoapppages;

import java.util.Arrays;
import java.util.List;

import com.google.common.base.Predicate;
import com.nextgen.webautomation.actions.MyActions;
import com.nextgen.webautomation.validator.ElementValidator;
import com.nextgen.webautomation.validator.Validator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HobbyDetails implements MyActions {

    @FindBy(id = "checkbox1")
    private WebElement cricket;

    @FindBy(id = "checkbox2")
    private WebElement movies;

    @FindBy(id = "checkbox3")
    private WebElement hockey;

    public HobbyDetails(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public List<Validator> getElementValidators() {
        return Arrays.asList(new ElementValidator(this.cricket), new ElementValidator(this.movies),
                new ElementValidator(this.hockey));
    };

    Predicate<String> hobbyIsCricket = s -> s.equals("cricket");
    Predicate<String> hobbyIsMovies = s -> s.equals("movies");
    Predicate<String> hobbyIsHockey = s -> s.equals("hockey");

    public void fillHobby(String hobby) {
        if (hobbyIsCricket.apply(hobby)) {
            clickOn.accept(this.cricket);
        } else if (hobbyIsMovies.apply(hobby)) {
            clickOn.accept(this.movies);
        } else {
            clickOn.accept(this.hockey);
        }
    }

}
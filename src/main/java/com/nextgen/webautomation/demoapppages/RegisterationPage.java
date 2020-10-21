package com.nextgen.webautomation.demoapppages;

import com.nextgen.webautomation.basepage.BasePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.awaitility.Awaitility.*;

import java.util.concurrent.TimeUnit;

public class RegisterationPage extends BasePage {

    private UserDetails userDetails;
    private ContactDetails contactDetails;
    private GenderDetails genderDetails;
    private HobbyDetails hobbyDetails;
    private OtherDetails otherDetails;
    private BirthDetails birthDetails;

    @FindBy(id = "firstpassword")
    private WebElement password;

    @FindBy(id = "secondpassword")
    private WebElement confirmPassword;

    @FindBy(id = "imagesrc")
    private WebElement photoUpload;

    @FindBy(id = "submitbtn")
    private WebElement submit;

    @FindBy(id = "Button1")
    private WebElement refresh;

    public RegisterationPage(WebDriver driver) {
        super(driver);
        setUserDetails(new UserDetails(driver));
        setContactDetails(new ContactDetails(driver));
        setGenderDetails(new GenderDetails(driver));
        setHobbyDetails(new HobbyDetails(driver));
        setOtherDetails(new OtherDetails(driver));
        setBirthDetails(new BirthDetails(driver));
    }

    @Override
    public void waitTillPageLoads() {
        await("Wait till enter option is displayed and enabled").atMost(10, TimeUnit.SECONDS)
                .until(() -> isDisplayed.and(isEnabled).test(this.photoUpload));
    }

    public void setPasswords(String passwd, String conPasswd) {
        type.accept(this.password, passwd);
        type.accept(this.confirmPassword, conPasswd);
    }

    public void submit() {
        clickOn.accept(this.submit);
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(ContactDetails contactDetails) {
        this.contactDetails = contactDetails;
    }

    public GenderDetails getGenderDetails() {
        return genderDetails;
    }

    public void setGenderDetails(GenderDetails genderDetails) {
        this.genderDetails = genderDetails;
    }

    public HobbyDetails getHobbyDetails() {
        return hobbyDetails;
    }

    public void setHobbyDetails(HobbyDetails hobbyDetails) {
        this.hobbyDetails = hobbyDetails;
    }

    public OtherDetails getOtherDetails() {
        return otherDetails;
    }

    public void setOtherDetails(OtherDetails otherDetails) {
        this.otherDetails = otherDetails;
    }

    public BirthDetails getBirthDetails() {
        return birthDetails;
    }

    public void setBirthDetails(BirthDetails birthDetails) {
        this.birthDetails = birthDetails;
    }

}
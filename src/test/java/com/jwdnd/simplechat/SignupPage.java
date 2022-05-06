package com.jwdnd.simplechat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {

    @FindBy(id = "inputFirstName")
    private WebElement firstName;

    @FindBy(id = "inputLastName")
    private WebElement lastName;

    @FindBy(id = "inputUsername")
    private WebElement userName;

    @FindBy(id = "inputPassword")
    private WebElement userPassword;

    @FindBy(id = "submit-button")
    private WebElement submit;

    public SignupPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver,this);
    }

    public void registerUser(String fName, String lName, String uName, String password) {
        firstName.clear();
        lastName.clear();
        userName.clear();
        userPassword.clear();
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        userName.sendKeys(uName);
        userPassword.sendKeys(password);
        submit.click();
    }
}

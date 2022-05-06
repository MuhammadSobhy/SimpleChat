package com.jwdnd.simplechat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = "inputUsername")
    private WebElement userName;

    @FindBy(id = "inputPassword")
    private WebElement userPassword;

    @FindBy(id = "submit-button")
    private WebElement submit;

    public LoginPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver,this);
    }

    public void loginUser(String uName, String password) {
        userName.clear();
        userPassword.clear();
        userName.sendKeys(uName);
        userPassword.sendKeys(password);
        submit.click();
    }

}

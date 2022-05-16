package com.dmall.uat.mallfront.elements;

import org.openqa.selenium.By;

public interface ISignInPageElement {

    By CREATE_ACCOUNT_BUTTON = By.xpath("//a[@id='createAccountSubmit']");
    By CONTINUE_BUTTON = By.id("continue");
    By EMAIL_TEXTBOX = By.name("email");
    By PASSWORD_TEXTBOX = By.name("password");
    By SIGN_IN_SUBMIT_BUTTON = By.id("signInSubmit");
    By NOT_NOW_BUTTON = By.id("ap-account-fixup-phone-skip-link");
}

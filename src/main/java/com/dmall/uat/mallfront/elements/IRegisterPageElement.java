package com.dmall.uat.mallfront.elements;

import org.openqa.selenium.By;

public interface IRegisterPageElement {

    By CUSTOMER_NAME_TEXT = By.name("customerName");
    By CUSTOMER_EMAIL_TEXT = By.name("email");
    By PASSWORD_TEXT = By.name("password");
    By PASSWORD_CHECK_TEXT = By.name("passwordCheck");
    By CONTINUE_BUTTON = By.id("continue");
    By CREATE_ACCOUNT_BUTTON = By.id("cvf-submit-otp-button-announce");
    By VERIFY_EMAIL_BUTTON = By.id("auth-continue");
    By OTP_TEXTBOX = By.id("cvf-input-code");
    By VERIFY_BUTTON = By.className("a-button-input");
}

package com.dmall.uat.mallfront.pages;

import com.dmall.uat.mallfront.elements.ISignInPageElement;
import com.dmall.uat.mallfront.utils.Config;

import static com.dmall.uat.mallfront.elements.IHomePageElement.*;

public class SignInPage extends Page implements ISignInPageElement {

    private static final String PAGE_URL = Config.BASE_URL + "ap/signin";

    public SignInPage() {
        this.url = PAGE_URL;
    }

    public Boolean isUserLoggedIn;

    private RegisterPage registerPage;

    public void moveToSignInPage() {
        mouseOver(HAMBURGER_MENU_BUTTON);
        clickToBy(SIGN_IN_BUTTON);
    }

    public RegisterPage createNewUser() {
        clickToBy(ISignInPageElement.CREATE_ACCOUNT_BUTTON);
        return registerPage;
    }

    public void login(String email, String password) {
        type(ISignInPageElement.EMAIL_TEXTBOX, email, true);
        clickToBy(ISignInPageElement.CONTINUE_BUTTON);
        type(ISignInPageElement.PASSWORD_TEXTBOX, password, true);
        clickToBy(ISignInPageElement.SIGN_IN_SUBMIT_BUTTON);
    }

    public boolean isUserLoggedIn() {
        visibilityWait(ACCOUNT_CONTENT_TEXT);
        String message = findElement(ACCOUNT_CONTENT_TEXT).getText();
        if (!message.toLowerCase().contains("hello")) {
            isUserLoggedIn = false;
        }
        return true;
    }
}

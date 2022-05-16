package com.dmall.uat.mallfront.signinpage;

import com.dmall.uat.mallfront.pages.SignInPage;
import com.thoughtworks.gauge.Step;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;

public class SignInPageStepImplementation {

    SignInPage signInPage = new SignInPage();

    @Step({"Move to sign in page.", "Giriş ekranına git."})
    public void moveToSignInPage() {
        signInPage.moveToSignInPage();
    }

    @Step({"Create new account.", "Yeni kayıt oluştur."})
    public void createNewAccount() {
        signInPage.createNewUser();
    }

    @Step("Login with register user <email> <password>.")
    public void login(String email, String password) {
        signInPage.login(email, password);
    }

    @Step("User should login successfully.")
    public void shouldLoginSuccessfully() {
        MatcherAssert.assertThat("User should not logged in", signInPage.isUserLoggedIn(), CoreMatchers.is(true));
    }
}

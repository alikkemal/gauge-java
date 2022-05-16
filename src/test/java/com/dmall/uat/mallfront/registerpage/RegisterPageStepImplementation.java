package com.dmall.uat.mallfront.registerpage;

import com.dmall.uat.mallfront.pages.RegisterPage;
import com.thoughtworks.gauge.Step;

public class RegisterPageStepImplementation {

    RegisterPage registerPage = new RegisterPage();

    @Step({"Fill account info.", "Hesap bilgilerini gir."})
    public void fillAccountInfo() {
        registerPage.fillAccountInfo();
    }
}

package com.dmall.uat.mallfront.pages;

import com.dmall.uat.mallfront.elements.IRegisterPageElement;
import com.dmall.uat.mallfront.models.visitor.Visitor;
import org.apache.commons.lang3.RandomStringUtils;

public class RegisterPage extends Page implements IRegisterPageElement {

    public void fillAccountInfo() {
        typeUsername().typeEmail()
                .typePassword()
                .verifyEmail();
    }

    private RegisterPage typeUsername() {
        Visitor visitor = new Visitor();
        visitor.setUsername("Tester" + RandomStringUtils.randomAlphabetic(5).toLowerCase());
        type(IRegisterPageElement.CUSTOMER_NAME_TEXT, visitor.getUsername(), true);
        return this;
    }

    private RegisterPage typeEmail() {
        Visitor visitor = new Visitor();
        visitor.setEmail(RandomStringUtils.randomAlphabetic(10).toLowerCase() + "@mailinator.com");
        type(IRegisterPageElement.CUSTOMER_EMAIL_TEXT, visitor.getEmail(), true);
        return this;
    }

    private RegisterPage typePassword() {
        Visitor visitor = new Visitor();
        visitor.setPassword(RandomStringUtils.randomNumeric(6));
        type(IRegisterPageElement.PASSWORD_TEXT, visitor.getPassword(), true);
        type(IRegisterPageElement.PASSWORD_CHECK_TEXT, visitor.getPassword(), true);
        return this;
    }

    private RegisterPage verifyEmail() {
        clickToBy(IRegisterPageElement.VERIFY_EMAIL_BUTTON);
        return this;
    }
}

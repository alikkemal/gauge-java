package com.dmall.uat.mallfront.elements;

import org.openqa.selenium.By;

public interface IHomePageElement {

    By HAMBURGER_MENU_BUTTON = By.id("nav-link-accountList");
    By SIGN_IN_BUTTON = By.className("nav-action-inner");
    By ACCOUNT_CONTENT_TEXT = By.id("nav-link-accountList-nav-line-1");
    By ADDRESS_POPUP = By.className("a-button-input");

}

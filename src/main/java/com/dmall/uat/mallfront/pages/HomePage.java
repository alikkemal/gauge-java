package com.dmall.uat.mallfront.pages;


import com.dmall.uat.mallfront.elements.IHomePageElement;
import com.dmall.uat.mallfront.utils.Config;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HomePage extends Page implements IHomePageElement {

    private static final String PAGE_URL = Config.BASE_URL;

    public HomePage() {
        this.url = PAGE_URL;
    }

    private Logger logger = LogManager.getLogger(HomePage.class);

    public HomePage closePopup() {
        if (isElementPresent(IHomePageElement.ADDRESS_POPUP)) {
            clickToBy(IHomePageElement.ADDRESS_POPUP);
        }
        return this;
    }

    public HomePage goToHomePage() {
        logger.info("<-------WEBDRIVER BUILD-------->");
        webDriver.manage().window().maximize();
        webDriver.get(url);
        return this;
    }
}

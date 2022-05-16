package com.dmall.uat.mallfront.homepage;

import com.dmall.uat.mallfront.pages.HomePage;
import com.thoughtworks.gauge.Step;

public class HomePageStepImplementation {

    private HomePage homePage = new HomePage();

    @Step({"Go to web site.", "Web site'sine git."})
    public void goToWebSite() {
        homePage.goToHomePage().closePopup();
    }
}

package com.dmall.uat.mallfront.models.browsers.chrome;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chrome {

    protected static WebDriver webDriver;

    @BeforeScenario
    public void initDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-notifications");
        options.addArguments("disable-infobars");
        webDriver = new ChromeDriver(options);
    }

    @AfterScenario
    public void terminateDriver() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}

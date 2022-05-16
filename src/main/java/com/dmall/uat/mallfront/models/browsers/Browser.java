package com.dmall.uat.mallfront.models.browsers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static com.dmall.uat.mallfront.utils.Config.WAITTIME_MEDIUM;

public class Browser extends SeleniumBrowser {

    private Logger logger = LogManager.getLogger(Browser.class);

    public void close() {
        webDriver.quit();
    }

    public void type(By by, String text) {
        type(by, text, true);
    }

    public void type(By by, String text, boolean clear) {
        try {
            type(visibilityWait(WAITTIME_MEDIUM, by), text, clear);
        } catch (StaleElementReferenceException sere) {
            type(by, text, clear);
        }
    }

    public void type(WebElement element, String text, boolean clear) {
        highlightElement(element);
        moveElement(element);
        if (clear) element.clear();
        element.sendKeys(text);
    }

    public void clickToBy(By by) {
        try {
            clickTo(visibilityWait(WAITTIME_MEDIUM, by));
        } catch (StaleElementReferenceException sere) {
            logger.error("Stale element exception has been thrown, will try again. " + sere);
            visibilityWait(by);
            clickToBy(by);
        }
    }

    public void clickTo(WebElement element) {
        highlightElement(element);
        moveElement(element);
        visibilityWait(WAITTIME_MEDIUM, element);
        element.click();
    }

    public void highlightElement(WebElement element) {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].style.background = 'yellow';", element);
    }

    protected void moveElement(WebElement element) {
        Actions actions = new Actions(webDriver);
        visibilityWait(WAITTIME_MEDIUM, element);
        actions.moveToElement(element);
        actions.perform();
    }

    public boolean isElementPresent(By by) {
        return !webDriver.findElements(by).isEmpty();
    }
}

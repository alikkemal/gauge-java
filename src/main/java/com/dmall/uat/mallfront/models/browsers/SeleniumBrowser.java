package com.dmall.uat.mallfront.models.browsers;

import com.dmall.uat.mallfront.models.browsers.chrome.Chrome;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;

import static com.dmall.uat.mallfront.utils.Config.WAITTIME_INSTANT;
import static com.dmall.uat.mallfront.utils.Config.WAITTIME_MEDIUM;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class SeleniumBrowser extends Chrome {

    private Logger logger = LogManager.getLogger(SeleniumBrowser.class);


    public void visibilityWait(By by) {
        new WebDriverWait(webDriver, WAITTIME_MEDIUM).until(elementToBeClickable(by));
    }

    public WebElement visibilityWait(int timeoutInSeconds, WebElement element) {
        Wait<WebDriver> wait = new FluentWait<>(webDriver).
                withTimeout(ofSeconds(timeoutInSeconds)).
                pollingEvery(ofMillis(500)).
                ignoring(NotFoundException.class).ignoring(java.util.NoSuchElementException.class);
        return wait.until(visibilityOf(element));
    }

    public WebElement visibilityWait(int timeoutInSeconds, By by) {
        Wait<WebDriver> wait = new FluentWait<>(webDriver).
                withTimeout(ofSeconds(timeoutInSeconds)).
                pollingEvery(ofMillis(500)).
                ignoring(NotFoundException.class).ignoring(org.openqa.selenium.NoSuchElementException.class);
        return wait.until(visibilityOfElementLocated(by));
    }

    public boolean isElementPresent(long timeoutInSeconds, By by) {
        Wait<WebDriver> wait = new FluentWait<>(webDriver).
                withTimeout(ofSeconds(timeoutInSeconds)).
                pollingEvery(ofMillis(500)).
                ignoring(NotFoundException.class).ignoring(NoSuchElementException.class);
        wait.until(presenceOfElementLocated(by));
        return true;
    }

    public WebElement findElement(By by) {
        return findElement(by, null);
    }

    public WebElement findElement(int timeout, By by) {
        waitForPresenceOf(timeout, by);
        return findElement(by, null);
    }

    private WebElement findElement(By by, WebElement element) {
        List<WebElement> elements;
        if (element != null) {
            elements = element.findElements(by);
        } else {
            elements = webDriver.findElements(by);
        }
        return elements.isEmpty() ? null : elements.get(0);
    }

    public List<WebElement> findElements(By by) {
        return webDriver.findElements(by);
    }

    public List<WebElement> findElements(By by, WebElement element) {
        return element.findElements(by);
    }

    public void waitForPresenceOf(int seconds, By elementLocator) {
        WebDriverWait wait = new WebDriverWait(webDriver, seconds);
        wait.until(visibilityOfElementLocated(elementLocator));
    }

    public void mouseOver(By by) {
        Actions actions = new Actions(webDriver);
        visibilityWait(by);
        WebElement mainMenu = webDriver.findElement(by);
        actions.moveToElement(mainMenu).perform();
    }

    protected void waitForPageToCompleteState(WebDriver driver) {
        int counter = 0;
        int maxNoOfRetries = 15;
        while (counter != maxNoOfRetries) {
            try {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                if (js.executeScript("return document.readyState").toString().equals("complete")) {
                    break;
                }
                wait(WAITTIME_INSTANT);
            } catch (Exception e) {
                logger.warn("The Page is still loading.");
            }
            counter++;
        }
    }
}

package com.dmall.uat.mallfront.elements;

import org.openqa.selenium.By;

public interface ISearchPageElement {

    By SEARCH_TEXTBOX = By.id("twotabsearchtextbox");
    By SEARCH_BUTTON = By.id("nav-search-submit-button");
    By TEXT_CONTENT = By.className("s-no-outline");
    By SEARCH_FILTER_DROPDOWNMENU = By.xpath("//span[@class='a-button-text a-declarative']");
    By FILTER_VALUE_LABEL = By.xpath("//li[@class='a-dropdown-item']/a");
    By PRODUCT_LINK = By.xpath("//span[@data-component-type='s-search-results']//div[@data-component-type='s-search-result']//h2/a");
    By PRODUCT_POINT_LABEL = By.xpath("//span[@data-component-type='s-search-results']//div[@data-component-type='s-search-result']//span[@class='a-size-base s-underline-text']");
    By PRODUCT_REVIEW_POINT_LABEL = By.xpath("//span[@data-component-type='s-search-results']//div[@data-component-type='s-search-result']//span[@class='a-size-base s-underline-text']");
    By PRODUCT_PRICE_LABEL = By.xpath("//span[@data-component-type='s-search-results']//div[@data-component-type='s-search-result']//span[@class='a-price'][1]");
    By PRODUCT_PRICE_SALE_LABEL = By.xpath("//span[@data-component-type='s-search-results']//div[@data-component-type='s-search-result']//span[@class='a-size-base s-highlighted-text-padding aok-inline-block s-coupon-highlight-color']");
}

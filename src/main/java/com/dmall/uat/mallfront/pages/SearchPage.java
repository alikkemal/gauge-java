package com.dmall.uat.mallfront.pages;

import com.dmall.uat.mallfront.elements.ISearchPageElement;
import com.dmall.uat.mallfront.utils.WriteFile;
import com.thoughtworks.gauge.Table;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchPage extends Page implements ISearchPageElement {

    private Logger logger = LogManager.getLogger(SearchPage.class);

    Map<String, String> clusterOne = new HashMap<>();
    Map<String, String> clusterTwo = new HashMap<>();
    Map<String, String> clusterThree = new HashMap<>();
    Map<String, String> clusterFour = new HashMap<>();

    public void searchKeyword(Table table) {
        type(ISearchPageElement.SEARCH_TEXTBOX, table.getColumnValues("keyword").get(0), true);
        clickToBy(ISearchPageElement.SEARCH_BUTTON);
    }

    public boolean isAppliedSearchKeyword(Table table) {
        return findElement(ISearchPageElement.TEXT_CONTENT).getText().contains(table.getColumnValues("keyword").get(0));
    }

    public SearchPage writeToConsoleAndSaveToFileAsProductFilterType(String type, int count) {
        waitForPageToCompleteState(webDriver);

        for (int x = 0; x < count; x++) {
            if (type.equalsIgnoreCase("point")) {
                List<WebElement> productPointList = findElements(PRODUCT_POINT_LABEL);
                clusterOne.put(findElements(PRODUCT_LINK).get(x).getAttribute("href"), "" + productPointList.get(x).getText().replace(",", ".") + "");
            } else if (type.equalsIgnoreCase("review")) {
                List<WebElement> productReviewList = findElements(PRODUCT_REVIEW_POINT_LABEL);
                clusterTwo.put(findElements(PRODUCT_LINK).get(x).getAttribute("href"), "" + productReviewList.get(x).getText().replace("$", "") + "");
            } else if (type.equalsIgnoreCase("price")) {
                List<WebElement> productPriceList = findElements(PRODUCT_PRICE_LABEL);
                clusterThree.put(findElements(PRODUCT_LINK).get(x).getAttribute("href"), "" + productPriceList.get(x).getText().replace(",", ".") + "");
            } else if (type.equalsIgnoreCase("sale")) {
                List<WebElement> productSaleList = findElements(PRODUCT_PRICE_SALE_LABEL);
                clusterFour.put(findElements(PRODUCT_LINK).get(x).getAttribute("href"), "" + productSaleList.get(x).getText().replace("Save", "") + "");
            }

            if (type.equalsIgnoreCase("point")) {
                WriteFile.writeToFile(clusterOne.values());
                System.out.println(clusterOne.values());
            } else if (type.equalsIgnoreCase("review")) {
                WriteFile.writeToFile(clusterTwo.values());
                System.out.println(clusterTwo.values());
            } else if (type.equalsIgnoreCase("price")) {
                WriteFile.writeToFile(clusterThree.values());
                System.out.println(clusterThree.values());
            } else if (type.equalsIgnoreCase("sale")) {
                WriteFile.writeToFile(clusterFour.values());
                System.out.println(clusterFour.values());
            }
        }
        return this;
    }
}
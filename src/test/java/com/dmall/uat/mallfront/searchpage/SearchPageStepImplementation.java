package com.dmall.uat.mallfront.searchpage;

import com.dmall.uat.mallfront.pages.SearchPage;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;

public class SearchPageStepImplementation {

    SearchPage searchPage = new SearchPage();

    @Step({"Search keyword. <table>", "Kelime arama. <table>"})
    public void searchKeyword(Table table) {
        searchPage.searchKeyword(table);
    }

    @Step({"Should showing keyword as successfully. <table>", "Kelime aramasının görüldüğü doğrulanmalı. <table>"})
    public void shouldShowingKeyword(Table table) {
        MatcherAssert.assertThat("Expected keyword could not applied", searchPage.isAppliedSearchKeyword(table), CoreMatchers.is(true));
    }

    @Step({"Write to console and save to file as product filter <type> item <10>.", "Ürün tipine göre filtreleyerek konsola ve dosyaya yazdır <item> <10>."})
    public void writeToConsoleAndSaveToFileAsProductFilterType(String type, int count) {
        searchPage.writeToConsoleAndSaveToFileAsProductFilterType(type, count);
    }
}

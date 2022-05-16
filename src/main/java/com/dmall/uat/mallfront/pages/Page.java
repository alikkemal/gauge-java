package com.dmall.uat.mallfront.pages;

import com.dmall.uat.mallfront.models.browsers.Browser;

public class Page extends Browser {

    public String url;

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl(String url) {
        return url;
    }

    public String url() {
        return this.url;
    }
}

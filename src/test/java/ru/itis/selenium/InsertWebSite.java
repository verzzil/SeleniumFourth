package ru.itis.selenium;

import org.junit.Assert;
import org.junit.Test;
import ru.itis.selenium.model.Currency;
import ru.itis.selenium.model.SalaryData;
import ru.itis.selenium.model.WebSiteData;
import ru.itis.selenium.tests.TestBase;

public class InsertWebSite extends TestBase {

    private final WebSiteData webSiteData = new WebSiteData("http://xannanov.com/");

    @Test
    public void insertWebSite() {
        app.getEditData().addWebSite(webSiteData);

        Assert.assertEquals(app.getData().getExpectedWebSiteData().getUrl(), webSiteData.getUrl());
    }
}

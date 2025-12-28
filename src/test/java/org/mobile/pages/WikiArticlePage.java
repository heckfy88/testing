package org.mobile.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WikiArticlePage extends WikiBasePage {

    private final By titleLocator = By.xpath("//android.widget.TextView[1]");

    public WikiArticlePage(AndroidDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return wait
                .until(ExpectedConditions.visibilityOfElementLocated(titleLocator))
                .getText();
    }

    public String getSection(String sectionName) {
        return driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))"
                        + ".scrollIntoView(new UiSelector().textContains(\""
                        + sectionName + "\"))"
        )).getText();
    }
}

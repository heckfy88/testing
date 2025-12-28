package org.mobile.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WikiMainPage extends WikiBasePage {

    private final By searchContainer = By.id("org.wikipedia:id/search_container");

    public WikiMainPage(AndroidDriver driver) {
        super(driver);
    }

    public void openSearch() {
        wait.until(ExpectedConditions.elementToBeClickable(searchContainer)).click();
    }

    public boolean isDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(searchContainer))
                .isDisplayed();
    }
}

package org.mobile.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class WikiSearchPage extends WikiBasePage {

    private final By searchInput = By.id("org.wikipedia:id/search_src_text");
    private final By firstResultTitle = By.id("org.wikipedia:id/page_list_item_title");

    private final By searchContainer = By.id("org.wikipedia:id/search_results_display");
    private final By searchResultTitles = By.id("org.wikipedia:id/page_list_item_title");

    private final By closePopupButton = By.id("org.wikipedia.alpha:id/closeButton");

    public WikiSearchPage(AndroidDriver driver) {
        super(driver);
    }

    public void search(String text) {
        closePopupIfPresent();
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchInput))
                .sendKeys(text);
    }

    public void openFirstResult() {
        closePopupIfPresent();
        wait.until(ExpectedConditions.elementToBeClickable(firstResultTitle)).click();
    }

    public boolean areSearchResultsDisplayed() {
        try {
            WebElement container = wait.until(ExpectedConditions.presenceOfElementLocated(searchContainer));
            return container.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public int getSearchResultsCount() {
        try {
            List<WebElement> titles = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(searchResultTitles));
            return titles.size();
        } catch (Exception e) {
            return 0;
        }
    }

    public void closePopupIfPresent() {
        try {
            Thread.sleep(1000);
            if (isElementPresent(closePopupButton)) {
                driver.findElement(closePopupButton).click();
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            // Игнорируем
        }
    }

    private boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
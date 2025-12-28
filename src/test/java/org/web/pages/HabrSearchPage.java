package org.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HabrSearchPage {

    private static final By SEARCH_INPUT = By.cssSelector("input.tm-search__input");
    private static final By SEARCH_RESULTS = By.cssSelector("article h2 a");
    private final WebDriver driver;
    private final WebDriverWait wait;

    public HabrSearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() {
        driver.get("https://habr.com/en/search");
        wait.until(ExpectedConditions.visibilityOfElementLocated(SEARCH_INPUT));
    }

    public void searchFor(String query) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(SEARCH_INPUT));
        input.clear();
        input.sendKeys(query);
        input.sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(SEARCH_RESULTS));
    }

    public boolean areResultsDisplayed() {
        List<WebElement> results = driver.findElements(SEARCH_RESULTS);
        return !results.isEmpty();
    }

    public int getResultsCount() {
        List<WebElement> results = driver.findElements(SEARCH_RESULTS);
        return results.size();
    }

    public void clickFirstResult() {
        WebElement first = wait.until(ExpectedConditions.elementToBeClickable(SEARCH_RESULTS));
        first.click();
    }
}

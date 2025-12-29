package org.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HabrMainPage extends HabrBasePage {

    private static final By ARTICLES_LIST = By.cssSelector("div.tm-articles-list");
    private static final By SEARCH_ICON_LINK = By.cssSelector("a.tm-header-user-menu__search");


    public HabrMainPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://habr.com/en/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(ARTICLES_LIST));
    }

    public void goToSearchPage() {
        WebElement searchLink = wait.until(ExpectedConditions.elementToBeClickable(SEARCH_ICON_LINK));
        searchLink.click();
        wait.until(ExpectedConditions.urlContains("/search/"));
    }

    public void openFirstArticle() {
        WebElement firstArticle =
                wait.until(ExpectedConditions.elementToBeClickable(
                        By.cssSelector("article h2 a")
                ));
        firstArticle.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
    }

    public boolean isArticlesListDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ARTICLES_LIST)).isDisplayed();
    }

    public String getTitle() {
        return driver.getTitle();
    }
}

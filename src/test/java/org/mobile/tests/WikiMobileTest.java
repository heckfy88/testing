package org.mobile.tests;

import org.mobile.pages.WikiArticlePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WikiMobileTest extends BaseWikiTest {

    @Test(priority = 1, description = "Проверка отображения главного экрана")
    public void mainScreenShouldBeDisplayed() {
        Assert.assertTrue(
                mainPage.isDisplayed(),
                "Главный экран должен отображаться"
        );
    }

    @Test(priority = 2, description = "Проверка поиска и получения результатов")
    public void testSearchArticle() {
        String query = "Java programming language";

        mainPage.openSearch();
        searchPage.search(query);

        Assert.assertTrue(
                searchPage.getSearchResultsCount() > 0,
                "Должны быть найдены результаты поиска"
        );

        Assert.assertTrue(
                searchPage.areSearchResultsDisplayed(),
                "Результаты поиска должны быть показаны"
        );
    }

    @Test(priority = 3, description = "Проверка отображения найденной статьи")
    public void searchArticleAndOpen() {
        String query = "Java";

        mainPage.openSearch();
        searchPage.search(query);
        searchPage.openFirstResult();

        WikiArticlePage browsedArticlePage = new WikiArticlePage(driver);

        String title = browsedArticlePage.getTitle();

        Assert.assertFalse(
                title.isEmpty(),
                "Статья не была открыта"
        );
    }

    @Test(priority = 4, description = "Проверка прокрутки до секции статьи")
    public void shouldScrollToHistorySection() {
        mainPage.openSearch();
        searchPage.search("Appium");
        searchPage.openFirstResult();

        String section = articlePage.getSection("History");

        Assert.assertTrue(section.contains("History"), "Секция не была найдена");
    }
}
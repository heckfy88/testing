package org.web.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HabrWebTest extends BaseHabrTest {

    @Test(priority = 1, description = "Открытие главной страницы")
    public void openMainPageTest() {
        mainPage.open();

        Assert.assertTrue(
                mainPage.getTitle().contains("Habr"),
                "Заголовок страницы должен содержать Habr"
        );
    }

    @Test(priority = 2, description = "Проверка отображения списка статей")
    public void articlesListDisplayedTest() {
        mainPage.open();

        Assert.assertTrue(
                mainPage.isArticlesListDisplayed(),
                "Список статей должен отображаться"
        );
    }

    @Test(priority = 3, description = "Открытие первой статьи")
    public void openFirstArticleTest() {
        mainPage.open();
        mainPage.openFirstArticle();

        Assert.assertFalse(
                mainPage.getTitle().isEmpty(),
                "Заголовок статьи не должен быть пустым"
        );
    }

    @Test(priority = 4, description = "Переход на страницу поиска через клик на лупу")
    public void testGoToSearchPage() {
        mainPage.open();
        mainPage.goToSearchPage();

        Assert.assertTrue(driver.getCurrentUrl().contains("/search/"), "Должна открыться страница поиска");
    }

    @Test(priority = 5, description = "Поиск статьи на странице /search/")
    public void testSearchArticle() {
        searchPage.open();
        searchPage.searchFor("Java programming language");

        Assert.assertTrue(searchPage.areResultsDisplayed(), "Результаты поиска должны отображаться");
        Assert.assertTrue(searchPage.getResultsCount() > 0, "Должны быть найдены результаты поиска");

        searchPage.clickFirstResult();
        Assert.assertFalse(driver.getTitle().isEmpty(), "Заголовок первой статьи не должен быть пустым");
    }
}
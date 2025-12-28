package org.web.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.web.pages.HabrMainPage;
import org.web.pages.HabrSearchPage;
import org.web.utils.WebDriverCustomUtil;

public class BaseHabrTest {

    protected WebDriver driver;

    protected HabrMainPage mainPage;
    protected HabrSearchPage searchPage;

    @BeforeClass
    public void setUp() {
        driver = WebDriverCustomUtil.getOrCreateDriver();
        initPages();
    }

    @AfterClass
    public void tearDown() {
        WebDriverCustomUtil.quitDriver();
    }

    private void initPages() {
        mainPage = new HabrMainPage(driver);
        searchPage = new HabrSearchPage(driver);
    }
}

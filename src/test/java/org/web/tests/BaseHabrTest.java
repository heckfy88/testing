package org;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.util.WebDriverCustomUtil;
import org.web.pages.HabrMainPage;
import org.web.pages.HabrSearchPage;

public class BaseHabrTest {

    protected WebDriver driver;
    protected HabrMainPage mainPage;
    protected HabrSearchPage searchPage;

    @BeforeClass
    public void setUp() {
        driver = WebDriverCustomUtil.getOrCreateDriver();
        mainPage = new HabrMainPage(driver);
        searchPage = new HabrSearchPage(driver);
    }

    @AfterClass
    public void tearDown() {
        WebDriverCustomUtil.quitDriver();
    }
}

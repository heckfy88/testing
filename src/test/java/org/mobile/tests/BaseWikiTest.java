package org.mobile.tests;

import io.appium.java_client.android.AndroidDriver;
import org.mobile.pages.WikiArticlePage;
import org.mobile.pages.WikiMainPage;
import org.mobile.pages.WikiOnboardingPage;
import org.mobile.pages.WikiSearchPage;
import org.mobile.utils.AppiumCustomDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

public class BaseWikiTest {

    protected AndroidDriver driver;

    protected WikiMainPage mainPage;
    protected WikiArticlePage articlePage;
    protected WikiSearchPage searchPage;
    protected WikiOnboardingPage onboardingPage;


    @BeforeClass
    public void setUp() throws MalformedURLException {
        driver = AppiumCustomDriver.getDriver();
        driver.activateApp("org.wikipedia");

        initPages();
    }

    @BeforeMethod
    public void reload() {
        driver.terminateApp("org.wikipedia");  // закрыть приложение
        driver.activateApp("org.wikipedia");
    }


    @AfterClass
    public void tearDown() {
        AppiumCustomDriver.quitDriver();
    }

    private void initPages() {
        mainPage = new WikiMainPage(driver);
        articlePage = new WikiArticlePage(driver);
        searchPage = new WikiSearchPage(driver);
        onboardingPage = new WikiOnboardingPage(driver);
        onboardingPage.skipIfPresent(); // приложение запускается с приветствием
    }
}

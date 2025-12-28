package org.mobile.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class WikiOnboardingPage extends WikiBasePage {

    private final By skipButton = By.id("org.wikipedia:id/fragment_onboarding_skip_button");

    public WikiOnboardingPage(AndroidDriver driver) {
        super(driver);
    }

    public void skipIfPresent() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(skipButton))
                    .click();
        } catch (Exception ignored) {
            // Онбординга нет - игнор
        }
    }
}
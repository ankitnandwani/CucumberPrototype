package com.ankitnandwani.cucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by mac on 25/08/17.
 */
public class Hooks {
    public void explicitWait(WebDriver driver, int time, WebElement element){
        (new WebDriverWait(driver, time)).until(ExpectedConditions.visibilityOf(element));
    }
}

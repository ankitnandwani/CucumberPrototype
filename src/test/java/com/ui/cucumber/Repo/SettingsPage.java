package com.ui.cucumber.Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by mac on 28/08/17.
 */
public class SettingsPage {

    public SettingsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(partialLinkText = "⇶")
    private WebElement settingsLink;

    @FindBy(partialLinkText = "All Settings")
    private WebElement allSettings;

    @FindBy(id = "setting_kp")
    private WebElement safeSearch;

    @FindBy(partialLinkText = "Save and Exit")
    private WebElement saveButton;

    public WebElement getSettingsLink(){
        return settingsLink;
    }

    public WebElement getAllSettings(){
        return allSettings;
    }

    public WebElement getSafeSearch(){
        return safeSearch;
    }

    public WebElement getSaveButton(){
        return saveButton;
    }
}

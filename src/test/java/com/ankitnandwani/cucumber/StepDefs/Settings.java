package com.ankitnandwani.cucumber.StepDefs;

import com.ankitnandwani.cucumber.Browser;
import com.ankitnandwani.cucumber.Hooks;
import com.ankitnandwani.cucumber.Repo.SettingsPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Properties;
import java.util.Random;

/**
 * Created by mac on 28/08/17.
 */
public class Settings {

    private WebDriver driver;
    private Properties prop;
    private Browser browser;
    private SettingsPage settings;
    Select safeSearch;
    String expected;
    Hooks hooks = new Hooks();

    public Settings(Browser browser){
        this.browser = browser;
    }

    @Given("^I'm at duckduckgo settings page$")
    public void imAtDuckduckgoHomepage(){
        driver = browser.getDriver();
        prop = browser.getProp();
        settings = browser.getSettingsPage();
        driver.get(prop.getProperty("URL"));
        settings.getSettingsLink().click();
        hooks.explicitWait(driver,2, settings.getOtherSettings());
        settings.getOtherSettings().click();
    }

    @When("^I toggle safe search dropdown and click save$")
    public void iEnterInSearchBar(){
        safeSearch = new Select(settings.getSafeSearch());
        safeSearch.selectByIndex(new Random().nextInt(safeSearch.getOptions().size()));
        expected = safeSearch.getFirstSelectedOption().getText();
        settings.getSaveButton().click();

    }

    @Then("^dropdown should be changed successfully$")
    public void searchResultsShouldBeDisplayed(){
        settings.getSettingsLink().click();
        hooks.explicitWait(driver,2, settings.getOtherSettings());
        settings.getOtherSettings().click();
        hooks.explicitWait(driver,2, settings.getSafeSearch());
        String actual = safeSearch.getFirstSelectedOption().getText();
        Assert.assertEquals(expected, actual);

    }

}

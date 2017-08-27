package com.ankitnandwani.cucumber.StepDefs;

import com.ankitnandwani.cucumber.Browser;
import com.ankitnandwani.cucumber.Hooks;
import com.ankitnandwani.cucumber.Repo.HomePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Properties;

/**
 * Created by mac on 25/05/17.
 */
public class Search {

    private WebDriver driver;
    private Properties prop;
    private Browser browser;
    private HomePage homePage;

    public Search(Browser browser){
        this.browser = browser;
    }

    Hooks hooks = new Hooks();

    @Given("^I'm at duckduckgo homepage$")
    public void imAtDuckduckgoHomepage(){
        driver = browser.getDriver();
        prop = browser.getProp();
        homePage = browser.getHomePage();
        driver.get(prop.getProperty("URL"));
    }

    @When("^I enter (.*) in search bar$")
    public void iEnterInSearchBar(String keyword){
        homePage.getSearchBar().sendKeys(keyword);
        homePage.getSearchButton().click();

    }

    @Then("^Search results should be displayed$")
    public void searchResultsShouldBeDisplayed(){
        Assert.assertTrue(homePage.getResultOne().isDisplayed());
    }

    @Then("^(.*) text should be displayed$")
    public void textShouldBeDisplayed(String expected){
        String actual;
        switch (expected) {
            case "We don’t store your personal information. Ever." :
                expected = "We don’t store your\npersonal information. Ever.";
                actual = homePage.getHomePageText().get(0).getText();
                break;

            case "Our privacy policy is simple: we don’t collect or share any of your personal information." :
                expected = "Our privacy policy is simple: we don’t collect\nor share any of your personal information.";
                actual = homePage.getHomePageSubText().get(0).getText();
                break;

            case "We don’t follow you around with ads." :
                expected = "We don’t follow you\naround with ads.";
                actual = homePage.getHomePageText().get(1).getText();
                break;

            case "We don’t store your search history. We therefore have nothing to sell to advertisers that track you across the internet." :
                expected = "We don’t store your search history. We therefore have nothing\nto sell to advertisers that track you across the internet.";
                actual = homePage.getHomePageSubText().get(1).getText();
                break;

            case "We don’t track you in or out of private browsing mode." :
                expected = "We don’t track you in or out\nof private browsing mode.";
                actual = homePage.getHomePageText().get(2).getText();
                break;

            case "Other search engines track your searches even when you’re in private browsing mode. We don’t track you — period." :
                expected = "Other search engines track your searches even when you’re\nin private browsing mode. We don’t track you — period.";
                actual = homePage.getHomePageSubText().get(2).getText();
                break;

            case "Switch to DuckDuckGo and take back your privacy!" :
                expected = "Switch to DuckDuckGo and\ntake back your privacy!";
                actual = homePage.getHomePageText().get(3).getText();
                break;

            case "No tracking, no ad targeting, just searching." :
                actual = homePage.getHomePageSubText().get(3).getText();
                break;

            default :
                actual = "";
                break;
        }
        Assert.assertEquals(expected,actual);
    }
}
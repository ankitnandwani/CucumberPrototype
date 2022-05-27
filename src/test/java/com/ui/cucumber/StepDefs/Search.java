package com.ui.cucumber.StepDefs;

import com.ui.cucumber.Browser;
import com.ui.cucumber.Hooks;
import com.ui.cucumber.Repo.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
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

            default :
                actual = "";
                break;
        }
        Assert.assertEquals(expected,actual);
    }
}
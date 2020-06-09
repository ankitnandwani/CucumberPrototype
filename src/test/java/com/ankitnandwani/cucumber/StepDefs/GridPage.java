package com.ankitnandwani.cucumber.StepDefs;

import com.ankitnandwani.cucumber.Browser;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.selenium.fluent.Target;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

public class GridPage {

    private Browser browser;
    private WebDriver driver;
    private Eyes eyes;

    public GridPage(Browser browser) {
        this.browser = browser;
    }

    @Given("^I am at AppliFashion Homepage$")
    public void IAmAtAppliFashionHomepage(){
        driver = browser.getDriver();
        eyes = browser.getEyes();
        driver.get("https://demo.applitools.com/gridHackathonV2.html");
        eyes.open(driver, "Task 1", "Cross-Device Elements Test", new RectangleSize(800,600));

    }

    @When("^I do nothing$")
    public void IDoNothing(){

    }

    @Then("^Page should be displayed correctly$")
    public void ThenPageShouldBeDisplayedCorrectly(){
        eyes.check(Target.window().fully().withName("Home Page"));
        eyes.closeAsync();
    }
}

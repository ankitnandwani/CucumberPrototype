package com.ankitnandwani.cucumber.Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by mac on 25/08/17.
 */
public class HomePage {

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "search_form_input_homepage")
    private WebElement searchBar;

    @FindBy(id = "search_button_homepage")
    private WebElement searchButton;

    @FindBy(id = "r1-0")
    private WebElement resultOne;

    @FindAll(@FindBy(css = "h1[class='onboarding-ed__title js-onboarding-ed-balance-text']"))
    private List<WebElement> homePageText;

    @FindAll(@FindBy(css = "p[class='onboarding-ed__subtitle js-onboarding-ed-balance-text']"))
    private List<WebElement> homePageSubText;

    public WebElement getSearchBar(){
        return searchBar;
    }

    public WebElement getSearchButton(){
        return searchButton;
    }

    public WebElement getResultOne(){
        return resultOne;
    }

    public List<WebElement> getHomePageText() {return homePageText; }

    public List<WebElement> getHomePageSubText() {return homePageSubText; }



}

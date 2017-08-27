package com.ankitnandwani.cucumber;


import com.ankitnandwani.cucumber.Repo.HomePage;
import com.ankitnandwani.cucumber.Repo.SettingsPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by mac on 25/08/17.
 */
public class Browser {

    private WebDriver driver;
    private Properties prop;
    private HomePage homePage;
    private SettingsPage settings;

    @Before
    public void setUp(){
        FileInputStream f = null;
        try{
            f = new FileInputStream(new File("src/test/Resources/com/ankitnandwani/cucumber/Config.properties"));
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }

        prop = new Properties();
        try{
            prop.load(f);
        }catch (IOException e){
            e.printStackTrace();
        }
        String browser = prop.getProperty("browser");
        switch (browser){
            case "chrome" :
                System.setProperty("webdriver.chrome.driver",prop.getProperty("driverExecutable") + "/chromedriver");
                driver = new ChromeDriver();
                break;

            case "firefox" :
                System.setProperty("webdriver.gecko.driver",prop.getProperty("driverExecutable") + "/geckodriver");
                driver = new FirefoxDriver();
                break;

            case "safari" :
                driver = new SafariDriver();
        }

        homePage = new HomePage(driver);
        settings = new SettingsPage(driver);

    }

    public WebDriver getDriver(){
        return driver;
    }

    public Properties getProp(){
        return prop;
    }

    public HomePage getHomePage(){
        return homePage;
    }

    public SettingsPage getSettingsPage(){
        return settings;
    }

    @After
    public void tearDown(){
        driver.quit();
    }


}

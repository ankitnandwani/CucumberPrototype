package com.ankitnandwani.cucumber;


import com.ankitnandwani.cucumber.Repo.HomePage;
import com.ankitnandwani.cucumber.Repo.SettingsPage;
import com.ankitnandwani.cucumber.StepDefs.GridPage;
import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.TestResultsSummary;
import com.applitools.eyes.selenium.BrowserType;
import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.visualgrid.model.DeviceName;
import com.applitools.eyes.visualgrid.model.ScreenOrientation;
import com.applitools.eyes.visualgrid.services.VisualGridRunner;
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
    private Eyes eyes;
    private VisualGridRunner runner;


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
                break;

            case "applitools" :
                System.setProperty("webdriver.chrome.driver",prop.getProperty("driverExecutable") + "/chromedriver");
                driver = new ChromeDriver();
                runner = new VisualGridRunner(10);
                eyes = new Eyes(runner);
                configureEyes(eyes);

        }

        homePage = new HomePage(driver);
        settings = new SettingsPage(driver);

    }

    public void configureEyes(Eyes eyes) {

        // Initialize eyes Configuration
        Configuration config = new Configuration();

        // You can get your api key from the Applitools dashboard
        config.setApiKey("ENTER_YOUR_API_KEY");

        // create a new batch info instance and set it to the configuration
        config.setBatch(new BatchInfo("UFG Hackathon"));

        // Add browsers with different viewports
        config.addBrowser(800, 600, BrowserType.CHROME);
        config.addBrowser(700, 500, BrowserType.FIREFOX);
        config.addBrowser(1600, 1200, BrowserType.IE_11);
        config.addBrowser(1024, 768, BrowserType.EDGE_CHROMIUM);
        config.addBrowser(800, 600, BrowserType.SAFARI);

        // Add mobile emulation devices in Portrait mode
        config.addDeviceEmulation(DeviceName.iPhone_X, ScreenOrientation.PORTRAIT);
        config.addDeviceEmulation(DeviceName.Pixel_2, ScreenOrientation.PORTRAIT);

        // Set the configuration object to eyes
        eyes.setConfiguration(config);

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

    public Eyes getEyes() {
        return eyes;
    }

    @After
    public void tearDown(){

        eyes.abortAsync();
        driver.quit();
        TestResultsSummary allTestResults = runner.getAllTestResults(false);
        System.out.println(allTestResults);
    }


}

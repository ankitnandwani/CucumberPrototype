# CucumberPrototype
BDD Framework Structure for UI Automation using Cucumber, Java, Selenium and Maven

This is a fully functional, highly scalable Cucumber Selenium framework structure developed using Cucumber, Selenium, Java, Maven and Page Factory Design Pattern. This is a Behaviour Driven Development (BDD) Framework which can be used for functional UI automation. I'll keep updating it regularly with new features. Pull requests are always welcome.


### Getting Started
To start a new project, clone the repo without the commit history
``` 
git clone --depth 1 https://github.com/ankitnandwani/CucumberPrototype.git
```

### Run maven goal
There are some sample test cases, to verify the setup is correct.
```
mvn test
```
If build is successful, you can start writing your test cases.

### Debug
1. Make sure your chrome (or firefox) version matches the chromedriver (or geckodriver) version.


### Applitools Integration
Added the ability to execute tests on applitools cloud platform. For executing in cloud, you need to update 
1. Set ```browser``` to ```applitools``` in ```Config.properties```
2. Replace ```ENTER_YOUR_API_KEY``` in ```config.setApiKey``` method in ```Browser.java``` to your account key, which you get from applitools.com

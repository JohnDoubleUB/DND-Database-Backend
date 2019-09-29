package com.qa.selenium;

//This class holds constants for the selenium testing, the commented out ones were used for local testing, the current setting should work on linux
// In each selenium test file there is also commented out code for local tests, this is because on linux I have set selenium to function without showing the browser

public class SeleniumConst {
    public static final String DRIVER_KEY= "webdriver.chrome.driver";

    // Driver for Linux
    public static final String DRIVER_LOCATION = "src/test/resources/chromedriver";

    // Driver for windows
//    public static final String DRIVER_LOCATION = "src/test/resources/chromedriver.exe";

    public static final String HOMEPAGE_URL = "http://localhost/";

//    public static final String HOMEPAGE_URL = "file:///C:/Users/johnw/Desktop/QAIndividualProj/QASoloProject/FrontEnd/";
}

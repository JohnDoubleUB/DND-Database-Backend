package com.qa.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NavigationTest {
    private ChromeDriver driver;

    @Before
    public void setUp(){
        System.setProperty(SeleniumConst.DRIVER_KEY, SeleniumConst.DRIVER_LOCATION);

//        driver = new ChromeDriver();
//        driver.manage().window().maximize();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);
    }

    @After
    public void tearDown(){
        driver.close();
        //driver.quit();
    }

    @Test
    public void navigationTest() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String[] pages = {"index.html","create-edit-character.html", "create-edit-inventory.html", "view-delete-character.html", "view-delete-inventory.html"};
        String URL;
        driver.get(SeleniumConst.HOMEPAGE_URL+pages[4]);

        Thread.sleep(2000);
        List<WebElement> navigation = driver.findElement(By.id("mainNav")).findElement(By.tagName("ul")).findElements(By.tagName("li"));

        for(int i= 0; i < navigation.size(); i++){
            navigation = driver.findElement(By.id("mainNav")).findElement(By.tagName("ul")).findElements(By.tagName("li"));
            navigation.get(i).click();
            Thread.sleep(500);
            URL = driver.getCurrentUrl();

            //Check that each page goes where it is expected to
            assertEquals(URL, SeleniumConst.HOMEPAGE_URL+pages[i]);
        }
    }
}

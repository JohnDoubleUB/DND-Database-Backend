package com.qa.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NavigationTest {
    private ChromeDriver driver;

    @Before
    public void setUp(){
        System.setProperty(SeleniumConst.DRIVER_KEY, SeleniumConst.DRIVER_LOCATION);
        //ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--headless");
        //driver = new ChromeDriver(chromeOptions);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void navigationTest() throws InterruptedException {
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

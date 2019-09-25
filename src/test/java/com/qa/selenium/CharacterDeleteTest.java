package com.qa.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CharacterDeleteTest {
    private ChromeDriver driver;

    @Before
    public void setUp(){
        System.setProperty(SeleniumConst.DRIVER_KEY, SeleniumConst.DRIVER_LOCATION);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        driver.close();
        //driver.quit();
    }

    //Create a inventory test!

    @Test
    public void deleteTest() throws InterruptedException {
        driver.get(SeleniumConst.HOMEPAGE_URL+"view-delete-character.html");
        Thread.sleep(2000);

        List<WebElement> tableRecords = driver.findElement(By.id("tableBody")).findElements(By.tagName("tr"));

        //Should have two entries currently (From previous tests)
        assertEquals(2, tableRecords.size());

        //Find delete button for first record
        WebElement record2DeleteButton = tableRecords.get(1).findElement(By.tagName("button"));

        //Click delete
        record2DeleteButton.click();
        Thread.sleep(500);

        //Check table size (Which should now be 1)
        tableRecords = driver.findElement(By.id("tableBody")).findElements(By.tagName("tr"));

        assertEquals(1,tableRecords.size());

        //Check the inventory for the character deleted was also removed

        driver.get(SeleniumConst.HOMEPAGE_URL+"view-delete-inventory.html");
        Thread.sleep(500);

        tableRecords = driver.findElement(By.id("tableBody")).findElements(By.tagName("tr"));

        assertEquals(0, tableRecords.size());

        //check that the character is no longer on the list
        driver.get(SeleniumConst.HOMEPAGE_URL+"create-edit-character.html");
        Thread.sleep(500);

        WebElement charSelection = driver.findElement(By.id("playerId"));
        int charSelectionSize = charSelection.findElements(By.tagName("option")).size();

        assertEquals(2, charSelectionSize);

        driver.get(SeleniumConst.HOMEPAGE_URL+"view-delete-character.html");
        Thread.sleep(500);

        tableRecords = driver.findElement(By.id("tableBody")).findElements(By.tagName("tr"));
        WebElement record1DeleteButton = tableRecords.get(0).findElement(By.tagName("button"));

        record1DeleteButton.click();
    }
}

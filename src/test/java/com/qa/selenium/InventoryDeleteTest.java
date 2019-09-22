package com.qa.selenium;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class InventoryDeleteTest {
    private ChromeDriver driver;

    @Before
    public void setUp(){
        System.setProperty(SeleniumConst.DRIVER_KEY, SeleniumConst.DRIVER_LOCATION);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);
        //driver = new ChromeDriver();
        //driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        driver.close();
    }

    //Create a inventory test!

    @Test
    public void inventoryDeleteTest() throws InterruptedException {
        driver.get(SeleniumConst.HOMEPAGE_URL+"view-delete-inventory.html");

        List<WebElement> tableRecords = driver.findElement(By.id("tableBody")).findElements(By.tagName("tr"));

        //Should have two entries currently (From previous tests)
        assertEquals(2, tableRecords.size());

        //Find delete button for first record
        WebElement record1DeleteButton = tableRecords.get(0).findElement(By.tagName("button"));

        //Click delete
        record1DeleteButton.click();


        Thread.sleep(1000);

        //Check table size (Which should now be 1)
        tableRecords = driver.findElement(By.id("tableBody")).findElements(By.tagName("tr"));

        assertEquals(1,tableRecords.size());

        //Check Create/Edit inventory page for this character

        driver.get(SeleniumConst.HOMEPAGE_URL+"create-edit-inventory.html");
        Thread.sleep(1000);

        WebElement charSelection = driver.findElement(By.id("playerId"));
        Select charSelect = new Select(charSelection);

        //Select the right character
        charSelect.selectByIndex(1);

        List<WebElement> inputFields = driver.findElement(By.id("invsub")).findElements(By.tagName("input"));
        WebElement equipmentField = driver.findElement(By.id("invsub")).findElement(By.tagName("textarea"));

        //Check that all the number fields are default value
        inputFields.stream().filter(element -> element.getAttribute("type").equals("number")).forEach(element -> assertEquals("0", element.getAttribute("value")));

        //Check equipment text area is empty
        assertEquals("", equipmentField.getAttribute("value"));
    }
}

package com.qa.selenium;

import org.junit.After;
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

public class InventoryCreateTest {
    private ChromeDriver driver;

    private ArrayList<int[]> intFields = new ArrayList<int[]>(Arrays.asList(
            new int[]{4, 6, 10, 0},
            new int[]{2, 8, 22, 2}
    ));

    private String[] textField = {"S's old inventory", "Jeff's old inventory"};



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

    @Test
    public void invSubmissionBoxValueResetTest() {
        driver.get(SeleniumConst.HOMEPAGE_URL+"create-edit-inventory.html");

        Actions actions = new Actions(driver);

        List<WebElement> inputFields = driver.findElement(By.id("invsub")).findElements(By.tagName("input"));

        int max;
        int min;
        String defaultValue;

        //Get for each input in inputFields
        for(WebElement element : inputFields) {
            //Check if it is of type "number"
            if(element.getAttribute("type").equals("number")) {
                //get max
                max = Integer.parseInt(element.getAttribute("max"));
                //get min
                min = Integer.parseInt(element.getAttribute("min"));

                //Get default value!
                defaultValue = element.getAttribute("value");

                //Check greater than max values cause reset!
                actions.click(element).sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE).sendKeys(Integer.toString(max+1)).sendKeys(Keys.ENTER).perform();
                assertEquals(defaultValue, element.getAttribute("value"));

                //Check less than max values cause reset!
                actions.click(element).sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE).sendKeys(Integer.toString(min-1)).sendKeys(Keys.ENTER).perform();
                assertEquals(defaultValue, element.getAttribute("value"));
            }
        }
    }

    //Create a inventory test!

    @Test
    public void invSubmissionWriteTest() throws InterruptedException {
        driver.get(SeleniumConst.HOMEPAGE_URL+"create-edit-inventory.html");
        Actions actions = new Actions(driver);

        List<WebElement> inputFields = driver.findElement(By.id("invsub")).findElements(By.tagName("input"));
        WebElement equipmentField = driver.findElement(By.id("invsub")).findElement(By.tagName("textarea"));
        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"invsub\"]/div/div[2]/input[5]"));

        //Get the character dropdown
        WebElement charSelection = driver.findElement(By.id("playerId"));
        Select charSelect = new Select(charSelection);

        //Create variables needed for handling the generation of characters
        int noFieldCount;

        //For each text field entry create a character
        int[] intField;

        for(int i = 0; i < intFields.size(); i++){
            intField = intFields.get(i);

            charSelect.selectByIndex(i+1);

            noFieldCount = 0;

            //Get for each input in inputFields
            for(WebElement element : inputFields) {
                //Check if it is of type "number"
                if(element.getAttribute("type").equals("number")) {
                    element.clear();
                    actions.click(element).sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE).sendKeys(Integer.toString(intField[noFieldCount])).perform();
                    noFieldCount++;
                    Thread.sleep(100);
                }
            }

            actions.click(equipmentField).sendKeys(textField[i]).perform();
            Thread.sleep(100);

            submitButton.click();
            Thread.sleep(100);

            charSelect.selectByIndex(0);

            assertEquals("0", inputFields.get(1).getAttribute("value"));
        }
    }



    //Update one of them as a test



    //create inventories for both

    //update one of them

    //delete one from the inventories page

    //delete the other character // Then check the inventories page is empty

    //this would conclude basic functionality testing!
}

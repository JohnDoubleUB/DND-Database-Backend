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

public class InventoryUpdateTest {
    private ChromeDriver driver;

    private ArrayList<int[]> intFields = new ArrayList<int[]>(Arrays.asList(
            new int[]{2, 8, 22, 2},
            new int[]{4, 6, 10, 0}
    ));

    private String[] textField = {"Jeff's new Inventory!", "S's new Inventory!"};



    @Before
    public void setUp(){
        System.setProperty(SeleniumConst.DRIVER_KEY, SeleniumConst.DRIVER_LOCATION);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);
        driver.get(SeleniumConst.HOMEPAGE_URL+"create-edit-inventory.html");
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
    public void updateTest() throws InterruptedException {

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
            Thread.sleep(500);

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
            equipmentField.clear();
            actions.click(equipmentField).sendKeys(textField[i]).perform();

            submitButton.click();
            Thread.sleep(500);

            charSelect = new Select(charSelection);

            charSelect.selectByIndex(0);
            Thread.sleep(500);

            assertEquals("0", inputFields.get(1).getAttribute("value"));
        }

        //Check that updated inventories persist

        for(int i = 0; i < intFields.size(); i++){
            intField = intFields.get(i);

            charSelect.selectByIndex(i+1);
            Thread.sleep(500);

            noFieldCount = 0;

            //Get for each input in inputFields
            for(WebElement element : inputFields) {
                //Check if it is of type "number"
                if(element.getAttribute("type").equals("number")) {
                    assertEquals(Integer.toString(intField[noFieldCount]) ,element.getAttribute("value"));
                    noFieldCount++;
                }
            }

            assertEquals(textField[i], equipmentField.getAttribute("value"));
        }
    }
}

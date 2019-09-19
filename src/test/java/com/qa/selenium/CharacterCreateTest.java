package com.qa.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class CharacterCreateTest {
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
    public void charSubmissionEmptyFieldsTest() throws InterruptedException {
        driver.get(SeleniumConst.HOMEPAGE_URL+"create-edit-character.html");
        WebElement charSelection = driver.findElement(By.id("playerId"));
        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"charsub\"]/input"));
        String defaultValue = charSelection.getAttribute("value");

        submitButton.click();

        Thread.sleep(100);

        charSelection = driver.findElement(By.id("playerId"));

        Thread.sleep(100);

        assertEquals(charSelection.getAttribute("value"), defaultValue);

        Thread.sleep(100);
    }

    @Test
    public void charSubmissionBoxValueResetTest() {
        driver.get(SeleniumConst.HOMEPAGE_URL+"create-edit-character.html");

        Actions actions = new Actions(driver);

        List<WebElement> inputFields = driver.findElement(By.id("charsub")).findElements(By.tagName("input"));

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

    //Create a character test!

    @Test
    public void charSubmissionWriteTest1() throws InterruptedException {
        driver.get(SeleniumConst.HOMEPAGE_URL+"create-edit-character.html");
        Actions actions = new Actions(driver);

        List<WebElement> inputFields = driver.findElement(By.id("charsub")).findElements(By.tagName("input"));
        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"charsub\"]/input"));

        //Get the character dropdown
        WebElement charSelection = driver.findElement(By.id("playerId"));
        Select charSelect = new Select(charSelection);
        String defaultOption = charSelect.getFirstSelectedOption().getText();

        int max;
        int min;
        int randomNo;
        Random r = new Random();
        int textFieldCount = 0;
        int noFieldCount = 0;
        String[] textFieldEntries1 = {"Socrowtes", "Kenku", "Monk", "Criminal", "Chaotic Neutral"};
        int[] intFieldEntries1 = new int[9];

        //Get for each input in inputFields
        for(WebElement element : inputFields) {
            //Check if it is of type "number"
            if(element.getAttribute("type").equals("number")) {
                //get max
                max = Integer.parseInt(element.getAttribute("max"));
                //get min
                min = Integer.parseInt(element.getAttribute("min"));

                //Check greater than max values cause reset!
                randomNo = r.nextInt((max+1)-min) + min; //Generate a random number within the max and min of the box!
                intFieldEntries1[noFieldCount] = randomNo;
                noFieldCount++;

                actions.click(element).sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE).sendKeys(Integer.toString(randomNo)).perform();
                Thread.sleep(200);


            } else if(element.getAttribute("type").equals("text")){ //If its a text field
                actions.click(element).sendKeys(textFieldEntries1[textFieldCount]);
                textFieldCount++;
            }
        }

        submitButton.click();
        Thread.sleep(500);

        assertEquals(textFieldEntries1[0],charSelect.getFirstSelectedOption().getText());

        charSelect.selectByIndex(0);

        assertEquals(inputFields.get(0).getAttribute("value"),"");

        Thread.sleep(700);
    }


    //Create one more character

    //Update one of them as a test

    //create inventories for both

    //update one of them

    //delete one from the inventories page

    //delete the other character // Then check the inventories page is empty

    //this would conclude basic functionality testing!
}

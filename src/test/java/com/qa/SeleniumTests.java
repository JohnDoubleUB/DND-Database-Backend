package com.qa;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SeleniumTests {
    private ChromeDriver driver;
    private String pageDir = "file:///C:/Users/johnw/Desktop/QAIndividualProj/QASoloProject/FrontEnd/";
    private String dir = System.getProperty("user.dir");

    @Before
    public void setUp(){
        //Establish chrome driver location
        System.setProperty("webdriver.chrome.driver",dir+"\\src\\test\\resources\\chromedriver.exe");

        //System.setProperty("webdriver.chrome.driver","C:\\Users\\johnw\\IdeaProjects\\dnddatabase\\src\\test\\resources\\chromedriver.exe");
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
        driver.get(pageDir+pages[4]);

        Thread.sleep(2000);
        List<WebElement> navigation = driver.findElement(By.id("mainNav")).findElement(By.tagName("ul")).findElements(By.tagName("li"));

        for(int i= 0; i < navigation.size(); i++){
            navigation = driver.findElement(By.id("mainNav")).findElement(By.tagName("ul")).findElements(By.tagName("li"));
            navigation.get(i).click();
            Thread.sleep(500);
            URL = driver.getCurrentUrl();

            assertEquals(URL, pageDir+pages[i]);
        }
    }



}

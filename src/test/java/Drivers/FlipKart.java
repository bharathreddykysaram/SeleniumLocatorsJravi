package Drivers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class FlipKart {

    public static final String url = "https://www.flipkart.com/";
    WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = DriverfactoryTest.createDriver(DriverfactoryTest.Browsertype.CHROME);

    }
//here below used actions api for performing mouse hover using actions api
    @Test
    public void idlocators() {

        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        NavigationTest.delay();


        WebElement menu=driver.findElement(By.cssSelector("[class$='emupdz']"));
        Assert.assertTrue( menu.isDisplayed());
       WebElement fashion= menu.findElement(By.cssSelector("div[class^='_1ch8e_'][aria-label='Fashion']"));
        Assert.assertTrue(menu.findElement(By.cssSelector("a[href^='/clothing-and-accessories/topwear/pr'][class$='MZbx']")).isDisplayed());
        Assert.assertTrue(menu.findElement(By.cssSelector("a[href^='/clothing-and-accessories/topwear/pr'][class$='MZbx']")).isEnabled());

        Actions action=new Actions(driver) ;
        action.moveToElement(fashion).perform();
        NavigationTest.delay();
       // action.moveToElement(topwear);



    }

    @AfterTest
    public void teardown(){
        if(driver!=null){
            driver.quit();
        }
    }

}

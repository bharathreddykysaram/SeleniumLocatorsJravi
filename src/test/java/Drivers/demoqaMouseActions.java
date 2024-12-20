package Drivers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class demoqaMouseActions {

    public static final String url = "https://demoqa.com/menu";
    WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = DriverfactoryTest.createDriver(DriverfactoryTest.Browsertype.CHROME);

    }
//here below used actions api for performing mouse hover using actions api
    @Test
    public void idlocators() {

        driver.get(url);
     //   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement menu=driver.findElement(By.xpath("//a[text()='Main Item 2']"));
        Actions actions=new Actions(driver);
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight / 3");
        actions.moveToElement(menu).perform();
        NavigationTest.delay();
        WebElement subel1=menu.findElement(By.xpath("//a[text()='Sub Item']"));
        WebElement subel2=menu.findElement(By.xpath("//a[text()='Sub Item']"));
        WebElement subel3=menu.findElement(By.xpath("//a[text()='SUB SUB LIST »']"));
        Assert.assertTrue(subel1.isDisplayed());
        Assert.assertTrue(subel2.isDisplayed());
        Assert.assertTrue(subel3.isDisplayed());

        Actions action=new Actions(driver) ;
        //action.moveToElement(fashion);
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

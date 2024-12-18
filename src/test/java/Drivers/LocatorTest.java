package Drivers;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LocatorTest {

    public static final String url="https://www.demoblaze.com/index.html";
    WebDriver driver;

    @BeforeTest
    public void setup(){
        driver=DriverfactoryTest.createDriver(DriverfactoryTest.Browsertype.CHROME);

    }
    @Test
    public void idlocators(){

        driver.get(url);

        NavigationTest.delay();
        //webelemnt is interface
        WebElement ele=driver.findElement(By.id("nava"));
       String dashboardText= driver.findElement(By.id("nava")).getText();

       System.out.println("dashboardText"+dashboardText);
        Assert.assertTrue(ele.isDisplayed());
        Assert.assertTrue(ele.isEnabled());
        Assert.assertFalse(ele.isSelected());


        ele.sendKeys("test");

        //invalid element state since its anchor tag no input text
       // ele.clear();



        Assert.assertEquals(driver.getCurrentUrl(),url);

        NavigationTest.delay();
        ele.click();




    }

    @AfterTest
    public void teardown(){
        if(driver!=null){
            driver.quit();
        }
    }
}

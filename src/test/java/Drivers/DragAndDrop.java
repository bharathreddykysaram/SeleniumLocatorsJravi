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

public class DragAndDrop {

    public static final String url = "https://demoqa.com/droppable";
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

        WebElement draggable=driver.findElement(By.cssSelector("#draggable"));
        WebElement droppable=driver.findElement(By.cssSelector("#droppable"));
        ((JavascriptExecutor)driver).executeScript(
                "window.scrollTo(0, document.body.scrollHeight / 3)");

        new Actions(driver).dragAndDrop(draggable,droppable).perform();

        String droppblestext=droppable.getText();
        Assert.assertEquals(droppblestext,"Dropped!");



    }

    @AfterTest
    public void teardown(){
        if(driver!=null){
            driver.quit();
        }
    }

}

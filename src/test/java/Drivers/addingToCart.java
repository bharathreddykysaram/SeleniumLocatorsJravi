package Drivers;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class addingToCart {

    WebDriver driver;
    public static final String url="https://www.demoblaze.com/index.html";
    @BeforeTest
    public void setup() {
        driver = DriverfactoryTest.createDriver(DriverfactoryTest.Browsertype.CHROME);

    }
    @Test
    public void addmobiletocart(){
driver.get(url);
        NavigationTest.delay();
       WebElement ele= driver.findElement(By.className("hrefch"));
        Assert.assertTrue( ele.isDisplayed());
        Assert.assertTrue( ele.isEnabled());
        ele.click();
        NavigationTest.delay();
        WebElement Btnele= driver.findElement(By.xpath("//a[@class='btn btn-success btn-lg']"));
        Assert.assertTrue( Btnele.isDisplayed());
        Assert.assertTrue( Btnele.isEnabled());
        Btnele.click();

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());

        //alert is an interface
        Alert alert=driver.switchTo().alert();
        alert.accept();

        WebElement cartlink= driver.findElement(By.xpath("//a[text()='Cart']"));
        Assert.assertTrue( cartlink.isDisplayed());
        Assert.assertTrue( cartlink.isEnabled());
        cartlink.click();

        WebElement cartsuccess= driver.findElement(By.className("success"));
        Assert.assertTrue( cartsuccess.isDisplayed());
        Assert.assertTrue( cartsuccess.isEnabled());

    }

    @AfterTest
    public void teardown(){
        if(driver!=null){
            driver.quit();
        }
    }
}

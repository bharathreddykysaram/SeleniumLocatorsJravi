package Drivers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CssSelectors {

    WebDriver driver;
    public static final String url="https://www.saucedemo.com/";
    @BeforeTest
    public void setup() {
        driver = DriverfactoryTest.createDriver(DriverfactoryTest.Browsertype.CHROME);

    }

    @Test
    public void sauceshopping()
    {
        driver.get(url);
        NavigationTest.delay();
       WebElement LoginEEL= driver.findElement(By.cssSelector("div.login-box"));

       LoginEEL.isEnabled();
       LoginEEL.isDisplayed();

       WebElement username=driver.findElement(By.cssSelector("#user-name"));
       username.sendKeys("standard_user");
        WebElement password=driver.findElement(By.cssSelector("input#password"));
        password.sendKeys("secret_sauce");
        driver.findElement(By.cssSelector(".submit-button")).click();
        NavigationTest.delay();

        Assert.assertEquals(driver.getCurrentUrl(),url+"inventory.html");

    }


    @AfterTest
    public void teardown(){
        if(driver!=null){
            driver.quit();
        }
    }
}

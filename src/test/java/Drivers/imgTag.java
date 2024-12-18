package Drivers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class imgTag {

    WebDriver driver;
    public static final String url="https://www.demoblaze.com/index.html";
    @BeforeTest
    public void setup() {
        driver = DriverfactoryTest.createDriver(DriverfactoryTest.Browsertype.CHROME);

    }
    //single image tag
    @Test
    public void imgtagval(){
        driver.get(url);
        WebElement ele=driver.findElement(By.tagName("img"));
        String srcAttribute=ele.getAttribute("src");
        Assert.assertNotNull(srcAttribute);

        System.out.println("image source"+srcAttribute);


    }

    //mutilpe img tags will return

    @Test
    public void mulimgtagval(){
        driver.get(url);
        List<WebElement> ele=driver.findElements(By.tagName("img"));
        for(WebElement eles:ele) {
            String srcAttribute = eles.getAttribute("src");
            Assert.assertNotNull(srcAttribute);
            System.out.println("mul image source" + srcAttribute);
        }
    }

    @Test
    public void allImagesVal()
    {
        driver.get(url);
        NavigationTest.delay();
        WebElement ele=driver.findElement(By.id("itemc"));
        ele.isDisplayed();
        ele.isEnabled();
        ele.click();

        List<WebElement> items=driver.findElements(By.id("itemc"));
        for(WebElement item:items){
            System.out.println("category........"+item.getText());
            item.click();
            NavigationTest.delay();

           WebElement containerel=driver.findElement(By.id("tbodyid"));
           //search a subset of the dom (to find only the links with in the main page)
            //here we are using "containerel" instead of driver to get only subset elements
           List<WebElement>linksEls=containerel.findElements(By.tagName("a"));
            for (WebElement device:linksEls) {
                String hrefattr=device.getAttribute("href");
                System.out.println("URL.."+hrefattr);

            }
        }

    }

    @Test
    public void nameLocatorsTest(){
        driver.get(url);
        WebElement formel=driver.findElement(By.id("frm"));
        formel.isDisplayed();
        formel.isEnabled();

        List<WebElement>btns=formel.findElements(By.tagName("button"));

        //make sure we have two buttons are displayed
        Assert.assertEquals(btns.size(),2);
        Assert.assertTrue(btns.get(0).isDisplayed());
        Assert.assertTrue(btns.get(1).isDisplayed());

            System.out.println("btns text..."+btns.get(0).getText());
        System.out.println("btns text..."+btns.get(1).getText());


    }

    @AfterTest
    public void teardown(){
        if(driver!=null){
            driver.quit();
        }
    }
}

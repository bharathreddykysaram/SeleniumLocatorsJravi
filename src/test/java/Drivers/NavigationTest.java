package Drivers;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NavigationTest{
    private WebDriver driver;

    public static final  String url="https://www.skillsoft.com/";
    public static final  String aboutus="https://www.skillsoft.com/about";
    public static final  String leadership="https://www.skillsoft.com/leadership-team";


    @BeforeTest
        public void setup(){
            driver=DriverfactoryTest.createDriver(DriverfactoryTest.Browsertype.CHROME);

    }

    public static void delay(){
        try{
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void navigationTest(){
        driver.get(url);
     //   Assert.assertEquals(driver.getCurrentUrl(),"Employee Development: Online Training Solutions | Skillsoft");
        driver.get(aboutus);


        ///navigate().back()

        driver.navigate().back();
        delay();
        String Tile=driver.getTitle();
        System.out.println("Tile"+Tile);
        Assert.assertEquals(driver.getCurrentUrl(),url);
        Assert.assertEquals(driver.getTitle(),"Employee Development: Online Training Solutions | Skillsoft");

///navigate().forword()
        driver.navigate().forward();
        delay();
        Assert.assertEquals(driver.getCurrentUrl(),aboutus);
        Assert.assertEquals(driver.getTitle(),"About Us - Skillsoft");

///navigate().refresh()
        driver.navigate().refresh();
        delay();
        Assert.assertEquals(driver.getCurrentUrl(),aboutus);
        Assert.assertEquals(driver.getTitle(),"About Us - Skillsoft");

///navigate().to("url")
        driver.navigate().to(leadership);
        delay();
        Assert.assertEquals(driver.getCurrentUrl(),leadership);

        Assert.assertEquals(driver.getTitle(),"The Skillsoft Leadership Team");





    }

@AfterTest
    public void teardown(){
        if(driver!=null){
            driver.quit();
        }
}

        }

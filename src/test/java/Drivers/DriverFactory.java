package Drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class DriverFactory {

    @Test
    public void navigateTopageusingchrome(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://google.com");
        driver.quit();
    }

    @Test
    public void navigateTopageusingFF(){
        WebDriver driver=new FirefoxDriver();
        driver.get("https://google.com");
        driver.quit();
    }

    @Test
    public void navigateTopageusingEdge(){
        WebDriver driver=new EdgeDriver();
        driver.get("https://google.com");
        driver.quit();
    }
}

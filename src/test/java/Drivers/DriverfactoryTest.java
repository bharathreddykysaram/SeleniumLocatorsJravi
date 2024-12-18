package Drivers;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class DriverfactoryTest {
    public enum Browsertype{
        CHROME,
        FIREFOX,
        EDGE,

    }

    public static WebDriver createDriver(Browsertype browsertype){
        WebDriver driver=null;
        switch (browsertype){
            case CHROME:
                ChromeOptions chromeOptions=new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                driver=new ChromeDriver(chromeOptions);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                break;

            case FIREFOX:;
                FirefoxOptions firefoxOptions=new FirefoxOptions();
                driver=new FirefoxDriver(firefoxOptions);
                break;

            default:
                throw new InvalidArgumentException("unsupported browser type"+browsertype);
        }
        return driver;

    }
}

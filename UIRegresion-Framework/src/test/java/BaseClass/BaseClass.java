package BaseClass;

import Helpers.Helpers;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

    public WebDriver driver;
    Helpers helpers= new Helpers();

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-gpu");
        driver = new ChromeDriver();
    }

    //@AfterMethod
    //public void Fished(){
      //  driver.quit();
    //}
}

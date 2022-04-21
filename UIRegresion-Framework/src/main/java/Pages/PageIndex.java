package Pages;

import Helpers.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageIndex {

    public WebDriver driver;
    public Helpers helpers;

    public PageIndex(WebDriver driver){
        this.driver=driver;
        helpers = new Helpers(driver);//para inicializar el Helpers
    }

    //Web Element - Web Element

    public By departureCitySelect = By.name("fromPort");
    public By destinationCitySelect = By.name("toPort");
    public By bottonFindFligth = By.xpath("//input[@value=\"Find Flights\"]");
    // by.class no acepta las clases compuestas eje: btn btn-primary

    // Funciones - Funciones

    public  void selectDepartureCity(String city){
        helpers.SendText(departureCitySelect, city);
        //driver.findElement(departureCitySelect).sendKeys("Mexico City");
    }
    public void selectDestinationCity(String city){
        helpers.SendText(destinationCitySelect, city);
        //driver.findElement(destinationCitySelect).sendKeys("Berlin");
    }
    public void click_find_flights(){
        helpers.clickBy(bottonFindFligth);
    }
}

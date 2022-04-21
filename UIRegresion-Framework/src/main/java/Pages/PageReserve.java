package Pages;

import Helpers.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageReserve {

    public WebDriver driver;
    public Helpers helpers;

    public  PageReserve(WebDriver driver){
        this.driver=driver;
        helpers = new Helpers(driver);
    }

    // WebElement
    public By titleH3 = By.tagName("h3");
    public By numFlight = By.xpath("//tr[1]/td[2]");
    public By airlines = By.xpath("//tr[1]/td[3]");
    public By departs = By.xpath("//tr[1]/td[4]");
    public By arrives = By.xpath("//tr[1]/td[5]");
    public By prices = By.xpath("//tr[1]/td[1]");
    public By bottomChose  = By.xpath("//input[@value=\"Choose This Flight\"]");


    //FUNCIONES
    public String getNumberFlight(){
        String numbrFlight = driver.findElement(numFlight).getText();
        System.out.println(numbrFlight);
        return numbrFlight;
    }
    public String getairLine(){
        String airLine = driver.findElement(airlines).getText();
        System.out.println(airLine);
        return airLine;

    }
    public void getdeparts(){
        String depart = driver.findElement(departs).getText();
        System.out.println(depart);
    }
    public void getArrives(){
        String arrive = driver.findElement(arrives).getText();
        System.out.println(arrive);
    }
    public void getPrice(){
        String price = driver.findElement(prices).getText();
        System.out.println(price);
    }
    public void clicBottom(){
        helpers.clickBy(bottomChose);
    }
    public boolean cityConfirmation(String city){
        String title = driver.findElement(titleH3).getText();
        return title.contains(city);
    }
}

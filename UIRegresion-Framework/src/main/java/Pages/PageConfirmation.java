package Pages;

import Helpers.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageConfirmation {
    WebDriver driver;
    Helpers helpers;

    public PageConfirmation(WebDriver driver){
        this.driver=driver;
        helpers = new Helpers(driver);
    }

    // WEBELEMENT --- WEB ELEMENT

    public By card = By.xpath("//tr[4]/td[2]");


    // FUNCIONES

    public  boolean cardConfirmation(String numberCard ){
        String ncard = driver.findElement(card).getText();
        return ncard.contains(numberCard);
    }

}

package Pages;

import Helpers.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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
    public By title_h1 = By.tagName("h1");



    // FUNCIONES

    public  boolean cardConfirmation(String numberCard ){
        String ncard = driver.findElement(card).getText();
        return ncard.contains(numberCard);
    }
    public boolean post_sale_confirmation(){
        boolean present;
        try{
          driver.findElement(title_h1);
          present=true;
        }catch (NoSuchElementException e){
            present=false;
        }
        return present;
    }
}

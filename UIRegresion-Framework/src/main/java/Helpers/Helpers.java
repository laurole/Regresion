package Helpers;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.util.Random;

public class Helpers {
    private  static WebDriver driver;
    public  Helpers(){}
    public Helpers(WebDriver driver){
        this.driver = driver;
    }
    public String getXMLParameter(String key){
        return Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter(key);
    }
    public void getUrl(String url){
        Print("Se ha ingresado la URL: "+ url);
        driver.get(url);
    }
    public void Print(String text){
        System.out.println(text);
    }

    public void clickByWebElement(WebElement element){
        element.click();
        Print("Se hizo click en el elemento:" + element);
    }
    public void clickBy(By by){
       new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(by)).click();
        Print("Se hizo click en el elemento:" + by);
    }

    public void SendText(By by, String text){
        WebElement element = driver.findElement(by);
        //element.clear();
        element.sendKeys(text);
        Print("Se envia texto: " +text+" al elemento: "+ by);
    }

    public void Pause(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public String getText(By by, String value) {
        String text = driver.findElement(by).getText();
        Print("Se obtiene text:" + text + "del elemento: " + by);
        return text;
    }

    public String returnFullAddress(){
        Faker f = new Faker();
        String street = f.address().streetAddress();
        String number = f.address().streetAddressNumber();
        String apparment = f.address().secondaryAddress();
        String address = street +" " + apparment;
        return address;
    }
    public  String selectByOptionValue(By by, String value){
        Select select = new Select(driver.findElement(by));
        select.selectByValue(value);
        return select.getFirstSelectedOption().getText();
    }
    public  String selectByVisibleText(By by, String txt){
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(txt);
        return select.getFirstSelectedOption().getText();
    }
    public  String selectByIndex(By by, int index){
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(index);
        return select.getFirstSelectedOption().getText();
    }

    public  String selectByIndex(By by){
        Random r = new Random();
        Select select = new Select(driver.findElement(by));
        int option_number = select.getOptions().size();
        int index_options = r.nextInt(option_number-1);
        //size: 1,2,3,4,5
        //index: 0,1,2,3,4
        select.selectByIndex(index_options);
        return select.getFirstSelectedOption().getText();
    }

    public int GetRandomNumber(int bound){
        return new Random().nextInt(bound);
    }

}


/**
 public void getElementClass(){
 List<WebElement> elements= driver.findElements(By.className("brand"));
 for(WebElement element: elements){
 System.out.println(element.getText());
 }
 } // esto para los casos como Tag y Clases donde es posible encontrar mas de un elemento con esas caracteristicas
 // si vas acapturar la información por id o por nombre que solo se debe encontrar 1 vez solo guardamos en un String


 public void getElementXpath(){
 // /html/body/div[2]/div/h1
 List<WebElement> elements= driver.findElements(By.xpath("/html/body/div[2]/div/h1"));
 for(WebElement element: elements){
 System.out.println(element.getText());
 }
 }

 public void click(){
 //btn btn-primary
 WebElement boton = driver.findElement(By.tagName("input"));
 boton.click();
 List<WebElement> elements= driver.findElements(By.xpath("/html/body/div[1]/div/div/a[2]"));
 elements.get(0).click();
 }

 public void cambiosUrl(){
 WebElement boton = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[1]/td[1]/input"));
 boton.click();
 //capturar la info de la URL
 String urlNueva = driver.getCurrentUrl();
 System.out.println(urlNueva);
 }
 **/

/**
 *Esperas Dinamicas:
 * Esperas Explicitas -> Esperas donde EXPLICITAMENTE se aguarda poor un elemento o condicion del mismo
 * Esperas Implicitas -> que al buscar un elemento, este IMPLICITO que tiene que esperar una cantidad de tiempo.
 *
 *
 * Estaticas
 * Pauses -> !!!!!!!! NUNCA SE OCUPA!!!!!!!!!!!
 * **/
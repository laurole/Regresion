package Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Helpers {
    private  static WebDriver driver;
    public  Helpers(){}
    public Helpers(WebDriver driver){
        this.driver = driver;
    }

    public void getUrl(String url){
        Print("Se ha ingresado la URL: "+ url);
        driver.get(url);
    }
    public void Print(String text){
        System.out.println(text);
    }

    public void clickBy(By by){
        driver.findElement(by).click();
        Print("Se hizo click en el elemento:" + by);
    }

    public void SendText(By by, String text){
        driver.findElement(by).sendKeys(text);
        Print("Se envia texto: " +text+" al elemento: "+ by);
    }

    public String getText(By by){
        String text = driver.findElement(by).getText();
        Print("Se obtiene text:" + text + "del elemento: "+by);
        return text;
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
}

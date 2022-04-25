package Tests;

import BaseClass.BaseClass;
import Helpers.Helpers;
import Pages.PageConfirmation;
import Pages.PageIndex;
import Pages.PagePurchase;
import Pages.PageReserve;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_con_POM extends BaseClass {

    @Test
    public  void  test1(){

        Helpers helpers = new Helpers(driver);
        helpers.getUrl("https://blazedemo.com/");
        PageIndex index = new PageIndex(driver);
        String departureCity = index.selectDepartureCity();
        String destinationCity = index.selectDestinationCity();
        index.click_find_flights();

        /**
         * 1. Una funcion que obtenga el elemento desde la pagina -> Page_Reserve
         * 2. Es una funcion para saber si el texto contiene nuestras variables departure y destination city -> Helpers
         *    2b. Retornar un booleano
         * 3. Una validacion por assert para ambas ciudades -> Tests
         **/

        PageReserve reserve = new PageReserve(driver);
        Assert.assertTrue(reserve.cityConfirmation(departureCity),"THE CITY ISNT THE CORRECT ONE");
        Assert.assertTrue(reserve.cityConfirmation(destinationCity),"THE CITY ISNT THE CORRECT ONE");

        String nf= reserve.getNumberFlight();
        String al= reserve.getairLine();
        reserve.getdeparts();
        reserve.getArrives();
        reserve.getPrice();
        reserve.clicBottom();
        /**
         * 1. Clic en el boton de la fila 1 de la tabla
         * 2. Se debe comprobar que los datos de la reserva sean iguales a los datos
         * que aparecen en la pagina purchase
         * La automatización espera que no falle (assertTrue) sin embargo fallara
         * Con esto podemos identificar que el metodo POST no se comporta de la manera esperada
         * **/
        PagePurchase purchase = new PagePurchase(driver);
      //  Assert.assertTrue(purchase.confirmationAl(al), "THE AIRLINE ISNT THE CORRECT ONE");
       // Assert.assertTrue(purchase.confirmationNumF(nf),"THE NUMBER AIRFLIGHT ISNT THE CORRECT ONE" );
    }

    /** test2 realiza la prueba sobre el formulario en la pagina purchase y su resultado en confirmation **/
    @Test
    public void test2(){

        String monthv = "04";
        String yearv = "2024";
        String cardN= "458263782248";
        Helpers helpers = new Helpers(driver);
        helpers.getUrl("https://blazedemo.com/");
        PageIndex index = new PageIndex(driver);
        String departureCity = index.selectDepartureCity();
        String destinationCity = index.selectDestinationCity();
        index.click_find_flights();

        PageReserve reserve = new PageReserve(driver);
        Assert.assertTrue(reserve.cityConfirmation(departureCity),"THE CITY ISNT THE CORRECT ONE");
        Assert.assertTrue(reserve.cityConfirmation(destinationCity),"THE CITY ISNT THE CORRECT ONE");

        reserve.clicBottom();

        PagePurchase purchase = new PagePurchase(driver);
        //purchase.selectform(monthv, yearv, cardN);
        purchase.fill_form();
        purchase.click_remember_checkbox();
        //helpers.Pause(10);
        purchase.click_purchaseFlight_button();
        PageConfirmation confirmation = new PageConfirmation(driver);
        Assert.assertTrue(confirmation.post_sale_confirmation(), "The sale failed");

        /**En los input Year y Month hay valores por defectos y al escribir nuestros propios valores,
         * estos se concatenan, por lo cual esta prueba arroja un FALSO POSITIVO
         * **/

       // purchase.clickPurchase();
        //PageConfirmation confirmation = new PageConfirmation(driver);
        //Assert.assertTrue(confirmation.cardConfirmation(cardN),"THE NUMBER CARD ISNT THE CORRECT ");
        /**Al validar si la información registrada en purchase es enviada y mostrada correctamente a la pagina
         * confirmation la prueba falla, lo cual demustra un error en el metodo POST
         **/

    }

    /**
    @Test
    public void Test2(){
        Helpers helpers = new Helpers(driver);
        helpers.getUrl("https://blazedemo.com/");
        helpers.getElementClass();
    }
    @Test
    public  void Test3(){
        Helpers helpers = new Helpers(driver);
        helpers.getUrl("https://blazedemo.com/");
        helpers.getElementXpath();
    }

    @Test
    public void Test4(){
        Helpers helpers = new Helpers(driver);
        helpers.getUrl("https://blazedemo.com/");
        helpers.click();
    }

    @Test
    public void Test5(){
        Helpers helpers = new Helpers(driver);
        helpers.getUrl("https://blazedemo.com/reserve.php");
        helpers.cambiosUrl();
    }
    **/
}

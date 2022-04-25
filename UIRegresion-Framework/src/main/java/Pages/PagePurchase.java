package Pages;

import Helpers.Helpers;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.net.PortUnreachableException;

public class PagePurchase {

    public WebDriver driver;
    public Helpers helpers;

    public PagePurchase(WebDriver driver){
        this.driver = driver;
        helpers = new Helpers(driver);
    }

    //Web Element - Web Element

    public By pairLine = By.xpath("//div[2]/p[1]");
    public By NumFlight = By.xpath("//div[2]/p[2]");
    public By nameuser = By.id("inputName");
    public By address = By.id("address");
    public By city = By.id("city");
    public By state = By.id("state");
    public By zipCode= By.id("zipCode");
    public By TypeCard = By.id("cardType");
    public By creditcardNumber = By.id("creditCardNumber");
    public By creditCardMonth = By.id("creditCardMonth");
    public By creditCardYear = By.id("creditCardYear");
    public By nameOnCard = By.id("nameOnCard");
    private By rememberMeCheck_checkbox = By.name("rememberMe");
    public By BottomPurchase = By.xpath("//input[@value=\"Purchase Flight\"]");


    // Funciones -  Funciones

    public void selectform(String mesv, String aniov, String nCard) {
        driver.findElement(nameuser).sendKeys("Laura Roldán");
        driver.findElement(address).sendKeys("Av. caribe # 45 -115");
        driver.findElement(city).sendKeys("Medellin");
        driver.findElement(state).sendKeys("Antioquia");
        driver.findElement(zipCode).sendKeys("47000");
        driver.findElement(TypeCard).sendKeys("American Express");
        driver.findElement(creditcardNumber).sendKeys(nCard);
        driver.findElement(creditCardMonth).sendKeys(mesv);
        driver.findElement(creditCardYear).sendKeys(aniov);
        driver.findElement(nameOnCard).sendKeys("Lala");

    }

    public  void fill_form(){
        Faker faker = new Faker();
        helpers.SendText(nameuser, faker.name().fullName());
        helpers.SendText(address, helpers.returnFullAddress());
        helpers.SendText(city, faker.address().city());
        helpers.SendText(state, faker.address().state());
        helpers.SendText(zipCode, faker.address().zipCode());
        helpers.selectByIndex(TypeCard);
        helpers.SendText(creditcardNumber, faker.business().creditCardNumber());
        helpers.SendText(creditCardMonth, String.valueOf(helpers.GetRandomNumber(12)));
        helpers.SendText(creditCardYear, String.valueOf(helpers.GetRandomNumber(2050)));
        helpers.SendText(nameOnCard, faker.name().fullName());
        helpers.SendText(address, helpers.returnFullAddress());


    }

    public void click_remember_checkbox(){
        helpers.clickBy(rememberMeCheck_checkbox);
    }
    public void click_purchaseFlight_button(){
        helpers.clickBy(BottomPurchase);
    }

    public boolean confirmationAl(String airl){
        String al = driver.findElement(pairLine).getText();
        System.out.println(al);
        return al.contains(airl);
    }

    public boolean confirmationNumF(String num){
        String nFlight =driver.findElement(NumFlight).getText();
        System.out.println(nFlight);
        return nFlight.contains(num);
    }
}

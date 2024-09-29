package day08_JsAlerts_Iframe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C03_BasicAuthentication extends TestBase_Each {

    @Test
    public void test01(){

        //1- Bir class olusturun : BasicAuthentication
        //2- https://testotomasyonu.com/basicauth sayfasina gidin

        // driver.get("https://testotomasyonu.com/basicauth");


        //3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
        //
        //Html komutu : https://username:password@URL
        //	Username     : membername
        // 	password      : sunflower
        //


        driver.get("https://membername:sunflower@testotomasyonu.com/basicauth");
        ReusableMethods.bekle(2);


        //4- Basarili sekilde sayfaya girildigini dogrulayin
        WebElement congratulationsYaziElementi = driver.findElement(By.tagName("i"));

        Assertions.assertTrue(congratulationsYaziElementi.isDisplayed());


        ReusableMethods.bekle(2);
    }
}
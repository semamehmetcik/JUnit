package day10_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C01_DoubleClick extends TestBase_Each {

    @Test
    public void test01(){

        //1- https://testotomasyonu.com/click sitesine gidin
        driver.get("https://testotomasyonu.com/click");
        ReusableMethods.bekle(1);

        //2- “DGI Drones” uzerinde sag click yapin
        // sag click yapabilmek icin actions class'ina ihtiyacimiz var
        // 1.adim actions objesi olustur
        Actions actions = new Actions(driver);

        // 2.adim uzerinde calisacagimiz WebElement'i locate edin
        WebElement dgiDronesElementi = driver.findElement(By.id("pic2_thumb"));

        // 3.adim istenen actions islevini kullanin
        //        sonuna perform() demeyi unutmayin
        actions.contextClick(dgiDronesElementi)
                .perform();

        ReusableMethods.bekle(1);
        //3- Alert’te cikan yazinin “Tebrikler!... Sağ click yaptınız.” oldugunu test edin.

        String expectedAlertYazisi = "Tebrikler!... Sağ click yaptınız.";
        String actualAlertYazi = driver
                .switchTo()
                .alert()
                .getText();

        Assertions.assertEquals(expectedAlertYazisi,actualAlertYazi);


        //4- Tamam diyerek alert’i kapatin
        driver.switchTo()
                .alert()
                .accept();


        ReusableMethods.bekle(2);

    }
}
package day08_JsAlerts_Iframe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_All;

public class C02_JsAlerts extends TestBase_All {

    //3 test method'u olusturup asagidaki gorevi tamamlayin


    @Test
    public void test01(){
        //1. Test
        //	-  https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");
        ReusableMethods.bekle(1);
        //	- 1.alert'e tiklayin
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']"))
                .click();
        ReusableMethods.bekle(1);
        //	-  Alert'deki yazinin "I am a JS Alert" oldugunu test edin
        String expectedAlertYazisi = "I am a JS Alert";

        String actualAlertYazisi = driver.switchTo().alert().getText();

        Assertions.assertEquals(expectedAlertYazisi,actualAlertYazisi);

        //	-  OK tusuna basip alert'i kapatin
        driver.switchTo().alert().accept();
        ReusableMethods.bekle(1);
    }

    @Test
    public void test02(){
        //2.Test
        //	- https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");
        ReusableMethods.bekle(1);
        //	- 2.alert'e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']"))
                .click();
        ReusableMethods.bekle(1);
        //	- Cancel'a basip,
        driver.switchTo().alert().dismiss();

        //	cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
        String expectedSonucYazisi = "You clicked: Cancel";

        WebElement sonucYaziElementi = driver.findElement(By.id("result"));

        String actualSonucYazisi = sonucYaziElementi.getText();

        Assertions.assertEquals(expectedSonucYazisi,actualSonucYazisi);
        ReusableMethods.bekle(1);
    }

    @Test
    public void test03(){
        //3.Test
        //	- https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");
        ReusableMethods.bekle(1);
        //	- 3.alert'e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']"))
                .click();
        ReusableMethods.bekle(1);
        //	- Cikan prompt ekranina "Furkan" yazdiralim
        driver.switchTo()
                .alert()
                .sendKeys("Furkan");
        ReusableMethods.bekle(1);
        //	- OK tusuna basarak alert'i kapatalim
        driver.switchTo()
                .alert()
                .accept();

        ReusableMethods.bekle(1);
        //	- Cikan sonuc yazisinin Furkan icerdigini test edelim

        String expectedSonucYaziIcerigi = "Furkan";

        WebElement sonucYaziElementi = driver.findElement(By.id("result"));

        String actualSonucYazisi = sonucYaziElementi.getText();

        Assertions.assertTrue(actualSonucYazisi.contains(expectedSonucYaziIcerigi));


    }



}
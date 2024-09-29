package day11_fileTestleri_Waits;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.List;

public class C04_ImplicitlyWaitIleBekleme extends TestBase_Each {

    @Test
    public void aramaTesti(){

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");
        ReusableMethods.bekle(1);

        // verilen kelime icin arama yapin

        String verilenKelime = "java";

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys(verilenKelime + Keys.ENTER);
        ReusableMethods.bekle(1);

        // arama sonucunda urun bulunabildigini test edin

        List<WebElement> bulunanUrunElementleriList = driver.findElements(By.className("prod-img"));

        Assertions.assertTrue(bulunanUrunElementleriList.size() > 0);

        ReusableMethods.bekle(1);
    }
}
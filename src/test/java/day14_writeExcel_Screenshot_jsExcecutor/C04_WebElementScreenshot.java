package day14_writeExcel_Screenshot_jsExcecutor;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.io.File;
import java.io.IOException;

public class C04_WebElementScreenshot extends TestBase_Each {

    @Test
    public void aramaTesti() throws IOException {

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");
        ReusableMethods.bekle(1);

        // Java icin arama yapin

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));

        aramaKutusu.sendKeys("Java" + Keys.ENTER );

        // arama sonucunda urun bulunamadigini test edin
        ReusableMethods.bekle(1);
        String expectedAramaSonucu = "0 Products Found";
        String actualAramaSonucu = driver.findElement(By.className("product-count-text"))
                .getText();

        Assertions.assertEquals(expectedAramaSonucu,actualAramaSonucu);


        // rapora eklenmek uzere arama sonuc yazisinin screenshot'ini alin

        // 1- dosya yolu olustur

        String dosyaYolu = "target/screenshots/webElementSS.png";

        // 2- kullanacagimiz WebElementi locate edip, WebElement olarak kaydedin
        WebElement aramaSonucElementi = driver.findElement(By.className("product-count-text"));

        // 3- kaydedecegimiz file'i olusturun

        File webElementSS = new File(dosyaYolu);

        // 4- webElement uzerinden screenshot'i alip, gecici dosya olarak kaydedin

        File geciciDosya = aramaSonucElementi.getScreenshotAs(OutputType.FILE);

        // 5- gecici dosyayi asil dosyaya kopyala

        FileUtils.copyFile(geciciDosya,webElementSS);

    }
}
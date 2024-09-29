package day14_writeExcel_Screenshot_jsExcecutor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C05_WebElementScreenshot extends TestBase_Each {


    @Test
    public void aramaTesti(){

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");
        ReusableMethods.bekle(1);

        // url'in testotomasyonu icerdigini test edin
        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        Assertions.assertTrue(actualUrl.contains(expectedUrlIcerik));

        // tum sayfanin screenshot'ini alin
        ReusableMethods.getScreenshotTumSayfa(driver);

        // phone icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);
        ReusableMethods.bekle(1);
        // urun bulunabildigini test edin

        String unExpectedAramaSonucu = "0 Products Found";
        String actualAramaSonucu = driver.findElement(By.className("product-count-text"))
                .getText();

        Assertions.assertNotEquals(unExpectedAramaSonucu,actualAramaSonucu);

        // sonuc yazisinin screenshot'ini alip kaydedin
        WebElement aramaSonucElementi = driver.findElement(By.className("product-count-text"));

        ReusableMethods.getScreenshotWebElement(driver,aramaSonucElementi);

        // ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@class='prod-img'])[1]"))
                .click();
        ReusableMethods.bekle(1);
        // acilan sayfada urun isminin case sensitive olmadan "phone" icerdigini test edin

        String expectedUrunIsimIcerigi = "phone";
        String actualUrunIsmi = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"))
                .getText()
                .toLowerCase();

        Assertions.assertTrue(actualUrunIsmi.contains(expectedUrunIsimIcerigi));

        // urun isim elementinin screenshot'ini alip kaydedin

        WebElement urunIsimElementi = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));

        ReusableMethods.getScreenshotWebElement(driver,urunIsimElementi);

    }
}
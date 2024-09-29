package day14_writeExcel_Screenshot_jsExcecutor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C03_ScreenshotAlma extends TestBase_Each {

    // 3 farkli test method'u olusturun ve asagidaki gorevleri yapin
    // 1- testotomasyonu anasayfaya gidin
    //    title'in "Test Otomasyonu" icerdigini test edin ve tum sayfa screenshot alin
    // 2- wisequarter anasayfaya gidin
    //    url'in "wisequarter" icerdigini test edin ve tum sayfa screenshot alin
    // 3- youtube anasayfaya gidin
    //    url'in "youtube" icerdigini test edin ve tum sayfa screenshot alin

    @Test
    public void testotomasyonuTesti(){
        driver.get("https://www.testotomasyonu.com");
        ReusableMethods.bekle(1);

        String expectedTitleIcerik = "Test Otomasyonu";
        String actualTitle = driver.getTitle();

        Assertions.assertTrue(actualTitle.contains(expectedTitleIcerik));

        ReusableMethods.getScreenshotTumSayfa(driver);

    }

    @Test
    public void wisequarterTesti(){
        driver.get("https://www.wisequarter.com");
        ReusableMethods.bekle(1);

        String expectedUrlIcerik = "wisequarter";
        String actualUrl = driver.getCurrentUrl();

        Assertions.assertTrue(actualUrl.contains(expectedUrlIcerik));

        ReusableMethods.getScreenshotTumSayfa(driver);

    }

    @Test
    public void youtubeTesti(){
        driver.get("https://www.youtube.com");
        ReusableMethods.bekle(1);

        String expectedUrlIcerik = "youtube";
        String actualUrl = driver.getCurrentUrl();

        Assertions.assertTrue(actualUrl.contains(expectedUrlIcerik));

        ReusableMethods.getScreenshotTumSayfa(driver);

    }
}
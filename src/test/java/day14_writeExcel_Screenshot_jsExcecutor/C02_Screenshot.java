package day14_writeExcel_Screenshot_jsExcecutor;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.io.File;
import java.io.IOException;

public class C02_Screenshot extends TestBase_Each {


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


        // rapora eklenmek uzere tum sayfanin screenshot'ini alin

        // 1.adim olusturacagimiz dosyayolunu hazirlayalim
        String dosyaYolu = "target/screenshots/tumsayfaScreenshot.png";

        // 2. TakesScreenshot objesi olusturalim

        // TakesScreenshot tss = new TakesScreenshot();
        // 'TakesScreenshot' is abstract; cannot be instantiated

        TakesScreenshot tss = (TakesScreenshot) driver;

        // 3.adim screenshot'i kaydedecegimiz File'i olusturalim

        File tumsayfaSS = new File(dosyaYolu);

        // 4.adim screenshot'i alip gecici dosua olarak kaydedin

        File geciciResim = tss.getScreenshotAs(OutputType.FILE);

        // 5.adim gecici resmi asil dosyaya kopyalayalim

        FileUtils.copyFile(geciciResim,tumsayfaSS);



    }

}
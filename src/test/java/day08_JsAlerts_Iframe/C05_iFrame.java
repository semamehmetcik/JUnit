package day08_JsAlerts_Iframe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.List;

public class C05_iFrame extends TestBase_Each {

    @Test
    public void test01(){
        //1- https://testotomasyonu.com/discount adresine gidin
        driver.get("https://testotomasyonu.com/discount");
        ReusableMethods.bekle(1);
        //2- Elektronics Products yazisinin gorunur olduğunu test edin

        // ulasmak istedigimiz elementin iframe icinde oldugunu gorduk
        // once iframe'i locate edip, iframe'e gecis yapmaliyiz

        WebElement electronicsIFrame =
                driver.findElement(By.xpath("(//iframe[@frameborder='1'])[1]"));

        driver.switchTo().frame(electronicsIFrame);

        ReusableMethods.bekle(1);
        WebElement electronicsProductYaziElementi =
                driver.findElement(By.xpath("//*[text()='Electronics Products']"));

        Assertions.assertTrue(electronicsProductYaziElementi.isDisplayed());

        //3- Dell bilgisayar urun isminin ‘DELL Core I3 11th Gen’ olduğunu test edin

        WebElement dellIsimElementi =
                driver.findElement(By.xpath("//span[text()='DELL Core I3 11th Gen ']"));

        String expectedDellUrunIsim = "DELL Core I3 11th Gen";
        String actualDellUrunIsim = dellIsimElementi.getText();

        Assertions.assertEquals(expectedDellUrunIsim,actualDellUrunIsim);


        // 5- sag bolumde bolum ismi olan "Fashion" yazisinin gorunur oldugunu test edin
        // Fashion yazisi sag tarafta bulunan BASKA BIR iframe'in icinde

        // biz yukarda (25.satir) electronics iFrame'ine gecis yapmistik
        // Fashion iFrame'ine gecmekl icin once
        // electronics iFrame'inden anasayfaya cikmaliyiz

        driver.switchTo().defaultContent();
        // eger ic ice birden fazla iFrame varsa en ustteki anasayfaya goturur
        // driver.switchTo().parentFrame();
        // eger ic ice birden fazla iFrame varsa bir ustteki iFrame'e goturur


        // anasayfaya ciktik, artik fashion iFrame'ine gecis yapabiliriz

        WebElement fashionIFrame =
                driver.findElement(By.xpath("(//iframe[@frameborder='1'])[2]"));

        driver.switchTo().frame(fashionIFrame);

        ReusableMethods.bekle(1);

        WebElement fashionBolumYaziElementi =
                driver.findElement(By.xpath("//h2[text() = 'Fashion']"));

        Assertions.assertTrue(fashionBolumYaziElementi.isDisplayed());

        //4- Sagdaki bolumde gorunen urunler arasinda
        //   ‘Men Slim Fit’ içeren en az 1 urun olduğunu test edin

        List<WebElement> urunIsimElementleriList = driver.findElements(By.tagName("p"));

        int sayac = 0;

        for(WebElement eachElement : urunIsimElementleriList ){

            if (eachElement.getText().contains("Men Slim Fit")){
                sayac++;
            }
        }

        Assertions.assertTrue(sayac>0);

        //6- ‘Here are some products’ yazisinin gorunur olduğunu test edin

        // bu yazi elementi anasayfada oldugundan
        // once fashionIFrame'inden anasayfaya cikmaliyiz

        driver.switchTo().defaultContent();
        ReusableMethods.bekle(1);

        WebElement hereAreSomeYaziElementi =
                driver.findElement(By.xpath("//*[text()='Here are some products.']"));

        Assertions.assertTrue(hereAreSomeYaziElementi.isDisplayed());


        ReusableMethods.bekle(1);
    }
}
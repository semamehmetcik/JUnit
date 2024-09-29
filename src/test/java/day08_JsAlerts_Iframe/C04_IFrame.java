package day08_JsAlerts_Iframe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C04_IFrame extends TestBase_Each {

    @Test
    public void test01(){

        // Bu class test sayfasi calismadigi icin iptal

        // 1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
        ReusableMethods.bekle(3);

        // 2 ) Bir metod olusturun: iframeTest
        //	- “An IFrame containing….” textinin erisilebilir oldugunu test edin ve
        //     konsolda yazdirin.

        WebElement anIframeYaziElementi = driver.findElement(By.tagName("h3"));

        Assertions.assertTrue(anIframeYaziElementi.isEnabled());

        System.out.println(anIframeYaziElementi.getText());


        //	- Text Box’a “Merhaba Dunya!” yazin.

        // TexBox'in bir iFrame icinde oldugunu gorduk
        // TextBox'i kullanabilmek icin once o iFrame'e gecis yapmaliyiz
        ReusableMethods.bekle(3);

        WebElement iframeElementi = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframeElementi);

        ReusableMethods.bekle(3);

        WebElement textBoxElementi = driver.findElement(By.xpath("//p"));

        textBoxElementi.sendKeys("Merhaba Dunya!");


        //	- TextBox’in altinda bulunan “Elemental Selenium” linkinin
        //    gorunur oldugunu dogrulayin ve yazisini konsolda yazdirin.

        ReusableMethods.bekle(3);
    }
}
package day09_switchingWindows_actions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.List;

public class C06_KontrolsuzWindowGecisi extends TestBase_Each {

    @Test
    public void test01(){
        //● https://testotomasyonu.com/addremove/ adresine gidin.
        driver.get("https://testotomasyonu.com/addremove/");
        ReusableMethods.bekle(1);
        //● Sayfadaki textin “Add/Remove Elements” olduğunu doğrulayın.
        String expectedyazi = "Add/Remove Elements";
        String actualyazi = driver.findElement(By.tagName("h2"))
                .getText();

        Assertions.assertEquals(expectedyazi,actualyazi);

        //● Sayfa başlığının(title) “Test Otomasyonu” icerdigini doğrulayın.

        String expectedTitle = "Test Otomasyonu";
        String actualTitle = driver.getTitle();

        Assertions.assertEquals(expectedTitle,actualTitle);

        //● ’Please click for Electronics Products’ linkine tiklayin.

        driver.findElement(By.xpath("//*[text()='Electronics Products']")).click();

        //● Electronics sayfasinin acildigini test edin
        // linki tikladigimizda kontrolsuz bir window acildigi icin
        // once o window'a gecmemiz gerekiyor
        ReusableMethods.bekle(1);
        ReusableMethods.switchToWindowByTitle(driver,"Test Otomasyonu - Electronics");
        ReusableMethods.bekle(1);

        // electronics sayfasinin acildigini test etmek icin Title'in Electronics icerdigini test edelim

        String expectedTitleIcerik = "Electronics";
        actualTitle = driver.getTitle();

        Assertions.assertTrue(actualTitle.contains(expectedTitleIcerik));

        //● Bulunan urun sayisinin 16 olduğunu test edin

        List<WebElement> bulunanUrunElementleriList =
                driver.findElements(By.xpath("//*[@class='prod-img']"));

        int expectedUrunSayisi = 16;
        int actualUrunSayisi = bulunanUrunElementleriList.size();

        Assertions.assertEquals(expectedUrunSayisi,actualUrunSayisi);


        //● Ilk actiginiz addremove sayfasinin oldugu window’a donun

        ReusableMethods.switchToWindowByTitle(driver,"Test Otomasyonu");


        //● Url’in addremove icerdigini test edin

        String expectedUrlIcerik = "addremove";
        String actualUrl = driver.getCurrentUrl();

        Assertions.assertTrue(actualUrl.contains(expectedUrlIcerik));

        ReusableMethods.bekle(1);
    }
}
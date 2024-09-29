package day09_switchingWindows_actions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C05_KontrolsuzAcilanWindow extends TestBase_Each {

    @Test
    public void test01(){
        //● https://the-internet.herokuapp.com/windows adresine gidin.

        driver.get("https://the-internet.herokuapp.com/windows");
        ReusableMethods.bekle(1);

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String expectedYazi = "Opening a new window";
        String actualYazi = driver.findElement(By.tagName("h3")).getText();

        Assertions.assertEquals(expectedYazi,actualYazi);

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.

        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();

        Assertions.assertEquals(expectedTitle,actualTitle);

        //● Click Here butonuna basın.
        driver.findElement(By.xpath("//*[text()='Click Here']"))
                .click();

        //● Acilan yeni window'un sayfa başlığının (title) “New Window” oldugunu test edin

        // Yeni window'da test yapabilmek icin, once driver'i yeni window'a gecirelim
        ReusableMethods.switchToWindowByTitle(driver,"New Window");

        String expectedYeniSayfaTitle = "New Window";
        String actualYeniSayfaTitle = driver.getTitle();

        Assertions.assertEquals(expectedYeniSayfaTitle,actualYeniSayfaTitle);


        //● Sayfadaki textin “New Window” olduğunu doğrulayın.

        String expectedYeniSayfaYazi = "New Window";
        String actualYeniSayfaYazi = driver.findElement(By.tagName("h3")).getText();

        Assertions.assertEquals(expectedYeniSayfaYazi,actualYeniSayfaYazi);

        //● Bir önceki pencereye geri döndükten sonra
        //  sayfa başlığının “The Internet” olduğunu test edin

        ReusableMethods.switchToWindowByTitle(driver,"The Internet");

        expectedTitle = "The Internet";
        actualTitle = driver.getTitle();

        Assertions.assertEquals(expectedTitle,actualTitle);
    }
}
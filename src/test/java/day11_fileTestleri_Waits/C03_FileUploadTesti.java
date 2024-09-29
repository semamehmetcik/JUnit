package day11_fileTestleri_Waits;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C03_FileUploadTesti extends TestBase_Each {

    @Test
    public void test01(){

        /*
            Eger chooseFile butonuna basarsak
            bilgisayarimizdan dosya secmemiz gerekir
            AMMA WebDriver bilgisayarimizdan dosya secemez

            bu durumda Selenium'un cozumunu kullanacagiz

            Cozum :  chooseFile butonunu locate edip
                     bir WebElement olarak kaydedecegiz
                     sonra yuklemek istedigimiz dosyanin
                     dinamik dosya yolunu chooseFile butonuna sendKeys() ile yollayacagiz
         */


        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //chooseFile butonuna basalim
        //Yuklemek istediginiz dosyayi secelim.

        WebElement chooseFileButonu = driver.findElement(By.id("file-upload"));

        String dinamikDosyaYolu = System.getProperty("user.home") + "/Downloads/funnyImage.jpg";

        chooseFileButonu.sendKeys(dinamikDosyaYolu);

        //Upload butonuna basalim.
        driver.findElement(By.id("file-submit"))
                .click();

        //“File Uploaded!” textinin goruntulendigini test edelim.

        String expectedYazi = "File Uploaded!";

        WebElement yaziElementi = driver.findElement(By.tagName("h3"));

        String actualYazi = yaziElementi.getText();

        Assertions.assertEquals(expectedYazi,actualYazi);

        ReusableMethods.bekle(3);
    }
}
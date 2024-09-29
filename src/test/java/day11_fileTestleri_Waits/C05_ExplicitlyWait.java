package day11_fileTestleri_Waits;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReusableMethods;

import java.time.Duration;

public class C05_ExplicitlyWait {

    /*
        Bazen belirlenmis bir WebElement
        uzerinde belirlenmis bir islem yaparken
        implicitly wait suresi az gelebilir

        implicitly wait suresi genel bir bekleme oldugundan
        onu cok uzun yapmak istemeyiz

        Bu tur ozel islemler icin
        o isleme ozel olarak tanimlanan
        explicitly Wait kullaniriz
     */

    /*
    Iki tane metod olusturun : implicitWaitTest , explicitWaitTest
    Iki metod icin de asagidaki adimlari test edin.
    1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    2. Textbox’in etkin olmadigini(enabled) dogrulayın
    3. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
    4. Textbox’in etkin oldugunu(enabled) dogrulayın.
    5. “It’s enabled!” mesajinin goruntulendigini dogrulayın.

     */
    WebDriver driver;

    @Test
    public void implicitWaitTest(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //    1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //    2. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));
        Assertions.assertFalse(textBox.isEnabled());

        //    3. Enable butonuna tıklayın
        driver.findElement(By.xpath("//*[text()='Enable']"))
                .click();
        //       ve textbox etkin oluncaya kadar bekleyin

        /*
            implicitly wait 2 islem icin bekler
            1- sayfanin yuklenmesi
            2- webelement'lerin locate edilebilmesi

            burada ne sayfa yuklemesi gerekiyor,
            ne de locate edilemeyen bir webelement var
            dolayisiyla implicitlyWait BEKLEMEYE GEREK DUYMUYOR
         */
        ReusableMethods.bekle(3);

        //    4. Textbox’in etkin oldugunu(enabled) dogrulayın.
        Assertions.assertTrue(textBox.isEnabled());

        //    5. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        WebElement mesajElementi = driver.findElement(By.id("message"));

        String expectedYazi = "It's enabled!";
        String actualYazi = mesajElementi.getText();

        Assertions.assertEquals(expectedYazi,actualYazi);

    }


    @Test
    public void explicitWaitTest(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //    1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //    2. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));
        Assertions.assertFalse(textBox.isEnabled());
        //    3. Enable butonuna tıklayın
        driver.findElement(By.xpath("//*[text()='Enable']"))
                .click();

        //    ve textbox etkin oluncaya kadar bekleyin
        // 1- Bir wait objesi olustur
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        // 2- Kullanacagimiz WebElementi locate edin
        //    bu soru icin kullanilacak textBox zaten yukarda locate edilip, kaydedildi

        // 3- wait objesi ile belirlenmis bekleme senaryolarindan uygun olani secin
        wait.until(ExpectedConditions.elementToBeClickable(textBox));

        //    4. Textbox’in etkin oldugunu(enabled) dogrulayın.
        Assertions.assertTrue(textBox.isEnabled());

        //    5. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        WebElement mesajElementi = driver.findElement(By.id("message"));

        String expectedYazi = "It's enabled!";
        String actualYazi = mesajElementi.getText();

        Assertions.assertEquals(expectedYazi,actualYazi);

    }

    @AfterEach
    public void teardown(){
        driver.quit();
    }


}
package day09_switchingWindows_actions;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.Set;

public class C03_KontrolsuzAcilanWindowlarArasiGecis extends TestBase_Each {

    @Test
    public void test01(){
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        ReusableMethods.bekle(1);

        // window handle degerini kaydedin ve yazdirin
        String herokuWhd = driver.getWindowHandle();
        System.out.println("Herokuapp WHD : " + herokuWhd);

        // click here linkini tiklayin
        driver.findElement(By.xpath("//*[text()='Click Here']"))
                .click();
        ReusableMethods.bekle(3);
        System.out.println("Click yaptiktan sonra driver'in bulundugu window'un WHD : " + driver.getWindowHandle());

        /*
            Kontrolsuz bir window acildiginda
            driver bunu bilemeyecegi icin eski window'da kalir

            Yeni acilan window'un WHD'ini bilmiyoruz
            yeni window'un WHD'ini almak icin once yeni window'a gecmeliyiz
            AMMA yeni window'a gecmek icin de WHD'ini bilmemiz gerekiyor

            Burada imdadimiza Zor gunlerin dostu,
            gariplerin kahramani Java yetisir
         */

        Set<String> acikTumWindowlarinWhdSeti =   driver.getWindowHandles();

        System.out.println(acikTumWindowlarinWhdSeti);
        /*
            yukardaki acikTumWindowlarinWhdSeti'inde 2 tane WHD var
            bunlardan biri 19.satirda kaydettigimiz herokuWhd ile ayni deger,
            digeri farkli bir deger

            biz bir for each loop ile
            Set'deki WHD'lerini gozden gecirip
            herokuWhd'a esit olmayani 2.windowun WHD'i olarak atayabiliriz
         */

        String yeniWindowWhd = "";

        for (String eachWhd : acikTumWindowlarinWhdSeti){

            if (  !eachWhd.equals(herokuWhd) ){
                yeniWindowWhd = eachWhd;
            }
        }

        driver.switchTo().window(yeniWindowWhd);

        System.out.println("Gecilen yeni window'un title'i : " + driver.getTitle());

        System.out.println("Gecilen yeni window'un WHD : " + driver.getWindowHandle());

        ReusableMethods.bekle(3);
    }
}
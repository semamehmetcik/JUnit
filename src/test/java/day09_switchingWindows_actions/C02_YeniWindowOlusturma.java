package day09_switchingWindows_actions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C02_YeniWindowOlusturma extends TestBase_Each {

    @Test
    public void test01(){

        /*
            Biz testlerimiz sirasinda pek cok kere
            bir webelementi tiklayabiliriz

            NORMAL OLARAK bir web elementi tikladigimizda
            yeni bir window acilmaz
            ayni window'da farkli bir URL'e sahip olan
            baska bir sayfaya yonlendiriliriz

            EGER yeni bir window acarak
            acilan yeni window'da bir sayfaya gitmemiz istenirse

           driver.switchTo().newWindow() kullanabiliriz.

           yeni window'u driver'a actirdigimiz icin
           driver otomatik olarak yeni window'a gecer

           EGER test sirasinda eski window'lara donmemiz gerekecekse
           gectigimiz her window'un window handle degerini kaydederiz
           ve sonra bu WHD'lerini kullanarak
           istenen window'a gecis yapariz

         */

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // WHD'ini kaydedin ve yazdirin

        String toWhd = driver.getWindowHandle();

        System.out.println("Testotomasyonu Whd : " + toWhd);
        ReusableMethods.bekle(3);

        // yeni bir tab'da wisequarter anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://www.wisequarter.com");

        // WHD'ini kaydedin ve yazdirin
        String wiseWhd = driver.getWindowHandle();

        System.out.println("Wise WHD : " + wiseWhd);

        ReusableMethods.bekle(3);

        // Yeni bir window acip

        driver.switchTo().newWindow(WindowType.WINDOW);

        // testotomasyonu sayfasina gidip, electronics linkine tiklayin
        driver.get("https://www.testotomasyonu.com");
        ReusableMethods.bekle(1);
        driver.findElement(By.xpath("(//a[text()='Electronics'])[3]"))
                .click();

        // WHD'ini kaydedin ve yazdirin

        String electronicsWhd = driver.getWindowHandle();

        System.out.println("Electronics WHD : " + electronicsWhd);

        ReusableMethods.bekle(3);

        // Testotomasyonu anasayfanin acik oldugu window'a donun

        driver.switchTo().window(toWhd);

        // Title'in "Test Otomasyonu - Test Otomasyonu" oldugunu test edin

        String expectedTitle = "Test Otomasyonu - Test Otomasyonu";
        String actualTitle = driver.getTitle();

        Assertions.assertEquals(expectedTitle,actualTitle);

        ReusableMethods.bekle(3);

        // Wisequarter anasayfanin acik oldugu window'a gidin
        driver.switchTo().window(wiseWhd);

        // url'in https://wisequarter.com/ oldugunu test edin

        String expectedUrl = "https://www.wisequarter.com/";
        String actualUrl = driver.getCurrentUrl();

        Assertions.assertEquals(expectedUrl,actualUrl);

        ReusableMethods.bekle(3);
    }
}
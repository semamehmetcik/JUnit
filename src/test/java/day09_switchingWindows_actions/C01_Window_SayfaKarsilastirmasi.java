package day09_switchingWindows_actions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C01_Window_SayfaKarsilastirmasi extends TestBase_Each {

    @Test
    public void test01(){

        // testotomasyonu anasayfaya gidin ve window handle degerini yazdirin

        driver.get("https://www.testotomasyonu.com");

        System.out.println("Test otomasyonu sayfasinda WHD : " + driver.getWindowHandle());
        String toWhd = driver.getWindowHandle();

        ReusableMethods.bekle(3);

        // wisequarter sayfasina gidin

        driver.get("https://www.wisequarter.com");

        // WHD'nin degismedigini test edin

        String wiseWhd = driver.getWindowHandle();
        System.out.println("Wisequarter sayfasinda WHD : " + driver.getWindowHandle());

        Assertions.assertEquals(toWhd,wiseWhd);

        ReusableMethods.bekle(3);

        // testotomasyonu sayfasina geri donup
        driver.navigate().back();
        // electronics linkini tiklayin
        driver.findElement(By.xpath("(//a[text()='Electronics'])[3]"))
                .click();

        // WHD'nin degismedigini test edin

        String electronicsWhd = driver.getWindowHandle();

        System.out.println("Electronics sayfasinda WHD : " + driver.getWindowHandle());

        Assertions.assertEquals(toWhd,electronicsWhd);

        ReusableMethods.bekle(3);
    }
}
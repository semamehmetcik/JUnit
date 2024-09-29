package day06_jUnitFramework;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utilities.ReusableMethods;

import java.time.Duration;

public class C01_SetupVeTeardownMethodlari {

    /*
        Bir test method'unun otomasyon ile
        istedigimiz islemleri yapabilmesi icin
        ONCELIKLE WebDriver objesi edinmek ve ilgili ayarlari yapmak gereklidir

        Ama her method icin tekrar tekrar bu satirlari yazmak yerine
        baslangic ayarlari icin setup(),
        ve bitis islemleri icin teardown() olusturalim
     */

    WebDriver driver;

    public void setup(){


        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    public void teardown(){
        ReusableMethods.bekle(3);
        driver.quit();
    }

    @Test
    public void testOtomasyonuTesti(){
        setup();
        driver.get("https://www.testotomasyonu.com");
        teardown();
    }

    @Test
    public void wisequarterTesti(){
        setup();
        driver.get("https://www.wisequarter.com");
        teardown();
    }

    @Test
    public void youtubeTesti(){
        setup();
        driver.get("https://www.youtube.com");
        teardown();
    }
}
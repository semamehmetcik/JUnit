package day06_jUnitFramework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utilities.ReusableMethods;

import java.time.Duration;

public class C02_BeforeVeAfterNotasyonlari {

    // 3 farkli test method'u olusturup
    // asagidaki verilen gorevleri yapin
    // 1- Test otomasyonu anasayfaya gidip url'in testotomasyonu icerdigini test edin
    // 2- Wisequarter anasayfaya gidin ve logonun gorundugunu test edin
    // 3- bestbuy anasayfaya gidin ve title'in BestBuy icerdigini test edin

    /*
        @BeforeEach ve @AfterEach method'lari her bir test method'undan once ve sonra
        otomatik olarak calisir

        Biz bu class'i class level'dan run ettigimizde
        asagidaki method'lar calisir

        setup
        test otomasyonu url testi PASSED
        teardown
        setup
        Wisequarter logo testi PASSED
        teardown
        setup
        Bestbuy title testi PASSED
        teardown
     */

    WebDriver driver;
    @BeforeEach // her test method'undan once calis
    public void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:/path/to/your/custom/profile");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterEach // her test method'undan sonra calis
    public void teardown(){
        ReusableMethods.bekle(2);
        driver.quit();
    }

    @Test
    public void bestbuyTesti(){
        // 3- bestbuy anasayfaya gidin ve title'in Best Buy icerdigini test edin

        driver.get("https://www.bestbuy.com");

        String expectedTitleIcerik = "Best Buy";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Bestbuy title testi PASSED");
        }else {
            System.out.println("Bestbuy title testi FAILED");
            System.out.println("Actual title : " + driver.getTitle());
        }

    }

    @Test
    public void wisequarterTesti(){
        // 2- Wisequarter anasayfaya gidin ve logonun gorundugunu test edin
        driver.get("https://www.wisequarter.com");

        WebElement logoElementi = driver.findElement(By.xpath("//*[@*='attachment-large size-large wp-image-3799']"));

        if (logoElementi.isDisplayed()){
            System.out.println("Wisequarter logo testi PASSED");
        }else System.out.println("Wisequarter logo testi FAILED");
    }

    @Test
    public void testOtomasyonuTesti(){
        // 1- Test otomasyonu anasayfaya gidip url'in testotomasyonu icerdigini test edin
        driver.get("https://www.testotomasyonu.com");

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("test otomasyonu url testi PASSED");
        }else System.out.println("test otomasyonu url testi FAILED");

    }



}
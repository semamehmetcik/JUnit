package day06_jUnitFramework;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;

public class C03_BeforeVeAfterNotasyonlari {

    /*
            1- JUnit test method'larini kafasina gore calistirir
               Hangi test method'unun once calisacagini ONGOREMEYIZ
               ve KONTROL EDEMEYIZ
            2- Eger sira bizim icin onemli ise
               test method'larinin isimlerini
               method01, method02,... seklinde verirsek
               bu siralamaya uygun calistirir
            3- test01'de anasayfaya gidip url testini yaptiktan sonra driver'i kapatirsak
               test02 calistiginda phone icin ARAMA YAPAMAZ
            4- Bu tur birbirine bagimli test method'lari oldugunda
               en basta setup calismali, tum test method'lari calisip[ bittikten sonra
               teardown devreye girmeli
            5- JUnit bu modeli @BeforeAll ve @AfterAll ile gerceklestirir
               ANCAKKK bu notasyonlari kullanan method'larin
               MECBUREN static olmasi gerekir


     */

    // 3 farkli test method'u olusturun ve asagidaki gorevleri yapin
    // 1- testotomasyonu anasayfaya gidin ve url'in testotomasyonu icerdigini test edin
    // 2- phone icin arama yapin ve arama sonucunda urun bulunabildigini test edin
    // 3- bulunan urunlerden ilkini tiklayin
    //    ve acilan sayfadaki urun isminde case sensitive olmadan phone gectigini test edin
    List<WebElement> bulunanUrunElementleriList;
    static WebDriver driver;
    @BeforeAll // her test method'undan once calis
    public static void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:/path/to/your/custom/profile");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterAll // her test method'undan sonra calis
    public static void teardown(){
        ReusableMethods.bekle(2);
        driver.quit();
    }


    @Test
    public void test01(){
        // anaSayfaUrltesti
        // 1- testotomasyonu anasayfaya gidin ve url'in testotomasyonu icerdigini test edin

        driver.get("https://www.testotomasyonu.com");

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Testotomasyonu url testi PASSED");
        }else System.out.println("Testotomasyonu url testi FAILED");

    }

    @Test
    public void test02(){
        // phoneAramaTesti
        // 2- phone icin arama yapin ve arama sonucunda urun bulunabildigini test edin

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));

        aramaKutusu.sendKeys("phone" + Keys.ENTER );

        // urun bulunabildigini test etmek icin
        // bulunan tum urunleri bir listeye kaydedip size > 0 seklinde test edebiliriz

        bulunanUrunElementleriList = driver.findElements(By.className("prod-img"));

        if ( bulunanUrunElementleriList.size() > 0 ){
            System.out.println("Urun bulabilme testi PASSED");
        }else System.out.println("Urun bulabilme testi FAILED");

    }

    @Test
    public void test03(){
        // urunIsimTesti
        // 3- bulunan urunlerden ilkini tiklayin
        //    ve acilan sayfadaki urun isminde case sensitive olmadan phone gectigini test edin
        bulunanUrunElementleriList = driver.findElements(By.className("prod-img"));
        bulunanUrunElementleriList.get(0)
                .click();

        WebElement urunIsimElementi =
                driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));

        String expectedUrunIsimIcerik = "phone";
        String actualUrunIsmiKucukHarf = urunIsimElementi.getText().toLowerCase();

        if (actualUrunIsmiKucukHarf.contains(expectedUrunIsimIcerik)){
            System.out.println("Urun isim icerik testi PASSED");
        }else System.out.println("Urun isim icerik testi FAILED");


    }

}
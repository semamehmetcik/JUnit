package day07_assertions_testBaseClass;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C02_Assertions {

    // https://www.bestbuy.com/ Adresine gidin
    // farkli test method’lari olusturarak asagidaki testleri yapin

    //	○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
    //	○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    //	○ logoTest => BestBuy logosunun görüntülendigini test edin
    //	○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

    static WebDriver driver;
    @BeforeAll
    public static void setup(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeEach
    public void setupEach(){
        driver.get("https://www.bestbuy.com");
    }

    @AfterAll
    public static void teardown(){
        driver.quit();
    }

    @Test
    public void urlTest(){

        ReusableMethods.bekle(1);

        //	○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin

        String expectedUrl = "https://www.bestbuy.com/";
        String actualUrl = driver.getCurrentUrl();

        Assertions.assertEquals(expectedUrl,actualUrl);

    }

    @Test
    public void titleTest(){
        //	○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        ReusableMethods.bekle(1);
        String unExpectedTitleIcerik = "Rest";
        String actualTitle = driver.getTitle();

        Assertions.assertFalse(actualTitle.contains(unExpectedTitleIcerik));

    }

    @Test
    public void logoTest(){
        //	○ logoTest => BestBuy logosunun görüntülendigini test edin
        ReusableMethods.bekle(1);
        WebElement logoElementi = driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));

        Assertions.assertTrue(logoElementi.isDisplayed());
    }

    @Test
    public void FrancaisLinkTest(){
        //	○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

        ReusableMethods.bekle(1);

        WebElement francaisLinkElementi = driver.findElement(By.xpath("//*[text()='Français']"));

        Assertions.assertTrue(francaisLinkElementi.isDisplayed());

    }


}
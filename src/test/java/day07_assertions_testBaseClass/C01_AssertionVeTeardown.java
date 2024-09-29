package day07_assertions_testBaseClass;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C01_AssertionVeTeardown {

    // Yapilan islem tek bir test method'unda yapilacak kadar kucuk olsa da
    // teardown() kullanmak daha mantiklidir
    // Cunku, eger driver.quit(); assertion ile ayni method'da olursa
    // assertion failed oldugunda driver.quit(); calisamaz, yani window acik kalir
    // OZELLIKLE TOPLU CALISTIRMALARDA failed olan her window'un acik kalmasi sorun olacaktir
    // Eger driver.quit(); ayri bir teardown method'unda olursa,
    // test method'unda assertion failed olsa bile teardown calisir ve window'u kapatir


    WebDriver driver;

    @BeforeEach
    public void setup(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterEach
    public void teardown(){
        ReusableMethods.bekle(3);
        driver.quit();
    }

    @Test
    public void titleTesti(){

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // Title'in Test Otomasyonu oldugunu test edin

        String expectedTitle = "Test Otomasyonu";
        String actualTitle = driver.getTitle();

        Assertions.assertEquals(expectedTitle,actualTitle);

    }
}
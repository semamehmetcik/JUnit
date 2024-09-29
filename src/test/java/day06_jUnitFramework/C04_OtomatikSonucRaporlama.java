package day06_jUnitFramework;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utilities.ReusableMethods;

import java.time.Duration;

public class C04_OtomatikSonucRaporlama {

    /*
        JUnit bir test method'unun FAILED oldugunu
        o test method'unda exception olusmasiyla anlayabilir

        bugune kadar yaptigimiz gibi
        if-else ile test yaparsak
        kod sorunsuz olarak calisip biitigi icin
        JUnit test'i PASSED olarak algilar

        JUnit ile uyumlu bir sonuc raporu gorebilmek icin
        - ya if-else ile yapip FAILED oldugunda exception firlatacagiz
        - ya da JUnit'in bize verdigi promosyonlardan
          assertion method'larini kullanacagiz
     */

    @Test
    public void titleTesti(){
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("user-data-dir=C:/path/to/your/custom/profile");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // Title'in Test Otomasyonu oldugunu test edin

        String expectedTitle = "Test Otomasyonu";
        String actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle)){
            System.out.println("Title testi PASSED");
        } else {
            System.out.println("Title testi FAILED");
            throw new AssertionError("Actual sayfa title : " + actualTitle);
        }

        ReusableMethods.bekle(3);
        driver.quit();
    }
}
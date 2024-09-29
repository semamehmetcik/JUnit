package day06_jUnitFramework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C05_Assertions {

    @Test
    public void titleTesti(){
        //ChromeOptions options = new ChromeOptions();
        // options.addArguments("user-data-dir=C:/path/to/your/custom/profile");

        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // Title'in Test Otomasyonu oldugunu test edin

        String expectedTitle = "Test Otomasyonu";
        String actualTitle = driver.getTitle();

        Assertions.assertEquals(expectedTitle,actualTitle);
        // JUnit problem olan kod bolumunu daha rahat bulabilmemiz icin
        // altini TURUNCU NOKTA yapar
        // bu CTE degildir sadece bize bulmada kolaylik saglayan bir gosterim bicimidir


        // Assertions.assertTrue(expectedTitle.equals(actualTitle));
        // equals method'u expected ve actual'i raporladigindan daha cok tercih edilir

        ReusableMethods.bekle(3);
        driver.quit();
    }
}
package day05_maven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utilities.ReusableMethods;

import java.time.Duration;

public class C01_mavenIleTest {

    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:/path/to/your/custom/profile");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        driver.get("https://www.testotomasyonu.com");


        ReusableMethods.bekle(3);
        driver.quit();
    }
}
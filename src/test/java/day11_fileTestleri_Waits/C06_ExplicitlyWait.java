package day11_fileTestleri_Waits;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C06_ExplicitlyWait {

    WebDriver driver;

    @Test
    public void implicitlyWaitTesti(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //2. Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']"))
                .click();

        //3. “It’s gone!” mesajinin goruntulendigini dogrulayin.

        WebElement itsGoneYaziElementi = driver.findElement(By.id("message"));

        Assertions.assertTrue(itsGoneYaziElementi.isDisplayed());


        //4. Add buttonuna basin

        driver.findElement(By.xpath("//*[text()='Add']"))
                .click();

        //5. It’s back mesajinin gorundugunu test edin

        WebElement itsBackElementi = driver.findElement(By.id("message"));

        Assertions.assertTrue(itsBackElementi.isDisplayed());
    }

    @Test
    public void explicitlyWaitTesti(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //2. Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']"))
                .click();
        //3. “It’s gone!” mesajinin goruntulendigini dogrulayin.

        // 1.adim wait objesi olustur
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));

        // 2.adim kullanacagimiz webelementi locate edin
        // 3.adim wait objesi ve webelemnt ile istege uygun method'u kullanip bekleyin

        // WebElement itsGoneYaziElementi = driver.findElement(By.id("message"));
        // bu element gorunmedigi icin locate edemiyoruz
        // bu durumda locate ve wait islemini (2.ve 3.adimlari) birlestiriyoruz

        WebElement itsGoneYaziElementi =
                wait.until(ExpectedConditions.elementToBeClickable(By.id("message")));

        Assertions.assertTrue(itsGoneYaziElementi.isDisplayed());

        //4. Add buttonuna basin
        driver.findElement(By.xpath("//*[text()='Add']"))
                .click();

        //5. It’s back mesajinin gorundugunu test edin
        //   It's Back elementi gorunur olmadigindan, locate edemiyoruz
        //   bu durumda explicit wait'deki 2. ve 3.adimlari
        //   yani locate ve beklemeyi birlikte yapabiliriz


        WebElement itsBackElementi =
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"It's back!\"]")));
        //driver.findElement(By.id("message"));



        Assertions.assertTrue(itsBackElementi.isDisplayed());

    }

    @AfterEach
    public void teardown(){
        driver.quit();
    }

}
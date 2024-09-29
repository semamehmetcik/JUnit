package day10_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C05_FormDoldurma extends TestBase_Each {

    @Test
    public void test01(){

        //1- https://www.testotomasyonu.com adresine gidelim
        driver.get("https://www.testotomasyonu.com");
        ReusableMethods.bekle(1);
        //2- Account linkine tiklayin
        driver.findElement(By.xpath("(//*[@class='menu-icon-text'])[1]"))
                .click();
        ReusableMethods.bekle(1);
        //3- Sign Up linkine basalim
        driver.findElement(By.xpath("//*[text()=' Sign Up']"))
                .click();


        //4- Ad, soyad, mail ve sifre kutularina deger yazalim ve Sign Up butonuna basalim

        WebElement isimKutusu = driver.findElement(By.xpath("//*[@id='firstName']"));

        Actions actions = new Actions(driver);
        ReusableMethods.bekle(1);
        actions.click(isimKutusu)
                .sendKeys("Wise")
                .sendKeys(Keys.TAB)
                .sendKeys("Quarter")
                .sendKeys(Keys.TAB)
                .sendKeys("wise@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("12345")
                .sendKeys(Keys.TAB)
                .sendKeys("12345").perform();

        // signUp butonuna click yapalim
        ReusableMethods.bekle(1);
        driver.findElement(By.xpath("//*[@*='submitbtn btn-lg']"))
                .click();

        //5- Kaydin olusturuldugunu test edin
        //  kayit icin alanlari doldurup sign up butonuna basinca bizi sign in ekranina yonlendirdi
        // kaydin olusturuldugunu anlamak icin giris yapabiliriz
        ReusableMethods.bekle(1);
        WebElement emailKutusu = driver.findElement(By.xpath("//input[@id='email']"));
        WebElement passwordKutusu = driver.findElement(By.xpath("//input[@id='password']"));
        WebElement signInButonu = driver.findElement(By.id("submitlogin"));

        emailKutusu.sendKeys("wise@gmail.com");
        passwordKutusu.sendKeys("12345");
        signInButonu.click();
        ReusableMethods.bekle(1);

        WebElement logoutButonu = driver.findElement(By.xpath("//span[text()='Logout']"));


        Assertions.assertTrue(logoutButonu.isDisplayed());

        logoutButonu.click();

        ReusableMethods.bekle(1);
    }
}
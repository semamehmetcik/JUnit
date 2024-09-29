package day10_actionsClass;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C07_FakeBilgilerleFormDoldurma extends TestBase_Each {

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
        Faker faker = new Faker();
        String sifre = faker.internet().password();
        String email = faker.internet().emailAddress();

        ReusableMethods.bekle(1);
        actions.click(isimKutusu)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(sifre)
                .sendKeys(Keys.TAB)
                .sendKeys(sifre).perform();

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

        emailKutusu.sendKeys(email);
        passwordKutusu.sendKeys(sifre);
        ReusableMethods.bekle(5);
        signInButonu.click();
        ReusableMethods.bekle(1);

        WebElement logoutButonu = driver.findElement(By.xpath("//span[text()='Logout']"));


        Assertions.assertTrue(logoutButonu.isDisplayed());

        logoutButonu.click();

        ReusableMethods.bekle(1);
    }
}
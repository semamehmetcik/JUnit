package day07_assertions_testBaseClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_All;

public class C05_RadioButton extends TestBase_All {

    // Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    //	a. Verilen web sayfasına gidin.
    //	      https://testotomasyonu.com/form
    //	b. Cinsiyet Radio button elementlerini locate edin
    //	c. Iki farkli test method’u oluşturup yazidan veya direk buton’dan size uygun olani secin
    //	d. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin

    @Test
    public void butondanSecmeTesti(){
        //	a. Verilen web sayfasına gidin.
        //	      https://testotomasyonu.com/form

        driver.get("https://testotomasyonu.com/form");
        ReusableMethods.bekle(1);
        //	b. Cinsiyet Radio button elementlerini locate edin
        WebElement kadinRadioButton = driver.findElement(By.xpath("//*[@id='inlineRadio1']"));
        WebElement erkekRadioButton = driver.findElement(By.xpath("//*[@id='inlineRadio2']"));
        WebElement digerRadioButton = driver.findElement(By.xpath("//*[@id='inlineRadio3']"));

        //	c.  direk buton’dan size uygun olani secin

        erkekRadioButton.click();

        //	d. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin

        Assertions.assertFalse(kadinRadioButton.isSelected());
        Assertions.assertTrue(erkekRadioButton.isSelected());
        Assertions.assertFalse(digerRadioButton.isSelected());

    }

    @Test
    public void yazidanSecmeTesti(){
        //	a. Verilen web sayfasına gidin.
        //	      https://testotomasyonu.com/form
        driver.get("https://testotomasyonu.com/form");
        ReusableMethods.bekle(1);
        //	b. Cinsiyet Radio button elementlerini locate edin
        WebElement kadinRadioButton = driver.findElement(By.xpath("//*[@id='inlineRadio1']"));
        WebElement erkekRadioButton = driver.findElement(By.xpath("//*[@id='inlineRadio2']"));
        WebElement digerRadioButton = driver.findElement(By.xpath("//*[@id='inlineRadio3']"));


        //	c. yazidan size uygun olani secin
        WebElement erkekRadioButtonYaziElementi = driver.findElement(By.xpath("//*[@for='inlineRadio2']"));
        erkekRadioButtonYaziElementi.click();
        ReusableMethods.bekle(3);
        //	d. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin

        Assertions.assertFalse(kadinRadioButton.isSelected());
        Assertions.assertTrue(erkekRadioButton.isSelected());
        Assertions.assertFalse(digerRadioButton.isSelected());
    }
}
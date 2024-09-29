package day14_writeExcel_Screenshot_jsExcecutor;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C06_JavaScriptExecutor extends TestBase_Each {

    @Test
    public void test01(){

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        // javascriptexecutor 2 parametre ile calisir
        // 1. ilgili javaScript script'i
        // 2. islevin ilgili oldugu webElement

        jse.executeScript("","");

        // 1. scroolIntoView

        // testotomasyonu form sayfasina gidin
        driver.get("https://testotomasyonu.com/form");
        ReusableMethods.bekle(3);

        // hastalik textbox'a kadar asagi inin

        WebElement hastalikTextBox = driver.findElement(By.id("diger-hastalik"));

        jse.executeScript("arguments[0].scrollIntoView({block: 'center'}); ", hastalikTextBox);

        hastalikTextBox.sendKeys("Furkan nerdesin ? ");

        ReusableMethods.bekle(3);

        jse.executeScript("alert('JUnit BITTI');");


        ReusableMethods.bekle(3);
    }
}
package day10_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C02_DragAndDrop extends TestBase_Each {

    @Test
    public void test01(){
        //1- https://testotomasyonu.com/droppable adresine gidelim
        driver.get("https://testotomasyonu.com/droppable");
        ReusableMethods.bekle(1);

        //2- Accept bolumunde “Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim
        Actions actions = new Actions(driver);

        WebElement accaptableBox = driver.findElement(By.id("draggable2"));
        WebElement hedefAlan = driver.findElement(By.id("droppable2"));

        actions.dragAndDrop(accaptableBox,hedefAlan).perform();

        ReusableMethods.bekle(1);
        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin

        String expectedYazi = "Dropped!";
        String actualYazi = hedefAlan.getText();

        Assertions.assertEquals(expectedYazi,actualYazi);

        //4- Sayfayi yenileyin

        driver.navigate().refresh();
        ReusableMethods.bekle(1);

        //5- “Not Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim

        WebElement notAcceptableBox = driver.findElement(By.id("draggable-nonvalid2"));
        hedefAlan = driver.findElement(By.id("droppable2"));

        actions.dragAndDrop(notAcceptableBox,hedefAlan).perform();


        //6- “Drop Here” yazisinin degismedigini test edin

        expectedYazi = "Drop Here";
        actualYazi = hedefAlan.getText();

        Assertions.assertEquals(expectedYazi,actualYazi);

        ReusableMethods.bekle(3);
    }
}

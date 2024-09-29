package day07_assertions_testBaseClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.List;

public class C07_DropdownMenu extends TestBase_Each {


    @Test
    public void dropdownMenuTesti(){
        //● https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");

        WebElement ddm = driver.findElement(By.id("dropdown"));
        Select select = new Select(ddm);

        //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByIndex(1);
        System.out.println( select.getFirstSelectedOption().getText());

        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın

        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());

        //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın

        select.selectByVisibleText("Option 1");

        System.out.println(select.getFirstSelectedOption().getText());

        //4.Tüm dropdown değerleri(value) yazdırın

        List<WebElement> optionElementleriList  = select.getOptions();

        System.out.println(ReusableMethods.stringListeyeCevir(optionElementleriList));
        // [Please select an option, Option 1, Option 2]

        //5. Dropdown’un boyutunun 4 olduğunu test edin

        int expectedDropdownBoyutu = 4;
        int actualDropdownBoyutu = optionElementleriList.size();

        Assertions.assertEquals(expectedDropdownBoyutu,actualDropdownBoyutu);
    }
}
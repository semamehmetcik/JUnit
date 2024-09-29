package day12_cookies_webTables;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class C02_WebTables extends TestBase_Each {

    @Test
    public void test01(){

        //1."https://testotomasyonu.com/webtables" adresine gidin
        driver.get("https://testotomasyonu.com/webtables");

        //2.Web table tum body’sini yazdirin
        WebElement tumBodyElementi = driver.findElement(By.tagName("tbody"));
        System.out.println(tumBodyElementi.getText());

        //3. Web tablosunda "Comfortable Gaming Chair" bulundugunu test edin
        String expectedTabloIcerigi = "Comfortable Gaming Chair";
        String actualTumBodyMetinOlarak = tumBodyElementi.getText();

        assertTrue(actualTumBodyMetinOlarak.contains(expectedTabloIcerigi));

        //4. Web table’daki satir sayisinin 5 oldugunu test edin
        List<WebElement> satirElementleriList =
                driver.findElements(By.xpath("//tbody/tr"));


        int expectedSatirSayisi = 5;
        int actualSatirSayisi = satirElementleriList.size();

        assertEquals(expectedSatirSayisi,actualSatirSayisi);

        //5. Tum satirlari yazdirin
        //  - Reusable methods ile String'den olusan listeye cevirip yazdirabiliriz

        System.out.println( ReusableMethods.stringListeyeCevir(satirElementleriList)   );
        /*
            [DELL Core I3 11th Gen
            8 GB/256 GB SSD/32 GB EMMC Storage/Ubuntu
            Electronics
            $399.00 Go, Samsung White Smart Watch
            Electronics
            $40.00 Go, Medium 25 L Laptop Backpack
            For Office/College/Travel (Black, Yellow)
            Travel
            $99.00 Go, Comfortable Gaming Chair
            Furniture
            $39.00 Go, Men Sun Glasses
            Men Fashion
            $15.00 Go]
         */

        //  - bir for loop ile listedeki satirlari tek tek yazdirabiliriz

        for (int i = 0; i <satirElementleriList.size() ; i++) {

            System.out.println(i+1 + ". satir  : " +   satirElementleriList.get(i).getText()   );
        }
        /*
                1. satir  : DELL Core I3 11th Gen
                8 GB/256 GB SSD/32 GB EMMC Storage/Ubuntu
                Electronics
                $399.00 Go
                2. satir  : Samsung White Smart Watch
                Electronics
                $40.00 Go
                3. satir  : Medium 25 L Laptop Backpack
                For Office/College/Travel (Black, Yellow)
                Travel
                $99.00 Go
                4. satir  : Comfortable Gaming Chair
                Furniture
                $39.00 Go
                5. satir  : Men Sun Glasses
                Men Fashion
                $15.00 Go


         */


        //6. Web table’daki sutun sayisinin 4 olduğunu test edin

        // Web table'da sutun yapisi yoktur
        // satirlar ve satirlardaki datalar vardir
        // biz sutun sayisini bulmak icin, herhangi bir satirdaki data sayisina bakabiliriz

        List<WebElement> birinciSatirElementleriList =
                driver.findElements(By.xpath("//tbody/tr[1]/td"));

        int expectedSutunSayisi = 4;
        int actualSutunSayisi = birinciSatirElementleriList.size();

        assertEquals(expectedSutunSayisi,actualSutunSayisi);

        //7. 3.sutunu yazdirin

        List<WebElement> ucuncuSutunElementleriList =
                driver.findElements(By.xpath("//tbody/tr[*]/td[3]"));

        System.out.println(ReusableMethods.stringListeyeCevir(ucuncuSutunElementleriList));
        // [$399.00, $40.00, $99.00, $39.00, $15.00]

        //8. Tablodaki basliklari yazdirin
        System.out.println( driver.findElement(By.tagName("thead")).getText());

        //  Produt Name Category Price Actions


        //9. Satir ve sutunu parametre olarak alip,
        //   hucredeki bilgiyi döndüren bir method olusturun

        System.out.println(getCellData(2, 3)); // $40.00

        System.out.println( getCellData(1,2)); // Electronics


        //10. 4.satirdaki category degerinin "Furniture" oldugunu test edin

        String expected4satir2sutun = "Furniture";

        String actual4satir2sutun = getCellData(4,2);

        assertEquals(expected4satir2sutun,actual4satir2sutun);

        ReusableMethods.bekle(2);
    }

    public String getCellData( int satirNo , int sutunNo){

        //                    //tbody/tr[  4  ]/td[    1   ]
        String dinamikXpath = "//tbody/tr[" + satirNo + "]/td[" + sutunNo + "]";
        WebElement istenenCellDataElementi = driver.findElement(By.xpath(dinamikXpath));

        return istenenCellDataElementi.getText();
    }
}
package day13_WebTables_ExcelOtomasyonu;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.List;

public class C01_KlasikOlmayanWebTablolari extends TestBase_Each {

    @Test
    public void test01(){

        //  1. “https://testotomasyonu.com/webtables2” sayfasina gidin
        driver.get("https://testotomasyonu.com/webtables2");
        ReusableMethods.bekle(1);
        //  2. Headers da bulunan basliklari yazdirin

        List<WebElement> baslikElementleriList = driver.findElements(By.xpath("// *[@role='hdata']"));

        System.out.println(ReusableMethods.stringListeyeCevir(baslikElementleriList));
        // [Product Name, Category, Price, Actions]

        //  3. 3.sutunun basligini yazdirin
        System.out.println("3.sutun basligi : "+ baslikElementleriList.get(2).getText());

        //  4. Tablodaki tum datalari yazdirin

        List<WebElement> tabloDataElementleriList =
                driver.findElements(By.xpath("// *[@role='tdata']"));

        System.out.println(ReusableMethods.stringListeyeCevir(tabloDataElementleriList));
        // [DELL Core I3 11th Gen, Electronics, $399.00, Go,
        // Medium 25 L Laptop Backpack, Electronics, $399.00, Go,
        // Comfortable Gaming Chair, Furniture, $399.00, Go,
        // Samsung White Smart Watch, Electronics, $40.00, Go,
        // Men Sun Glasses, Men Fashion, $15.00, Go]

        //  5. Tabloda kac tane cell (data) oldugunu yazdirin

        System.out.println("Tablodaki data sayisi : " + tabloDataElementleriList.size());
        //Tablodaki data sayisi : 20

        //  6. Tablodaki satir sayisini yazdirin

        List<WebElement> tablodakiSatirElementleriList =
                driver.findElements(By.xpath("// *[@role='trow']"));

        System.out.println("Tablodaki satir sayisi : " + tablodakiSatirElementleriList.size());


        //  7. Tablodaki sutun sayisini yazdirin
        //     tablodaki sutun sayisini bulmak icin baslik sayisini yazdirabiliriz

        System.out.println("Tablodaki sutun sayisi : " + baslikElementleriList.size());


        //  8. Tablodaki 3.kolonu yazdirin

        List<WebElement> ucuncuSutunElementleriList =
                driver.findElements(By.xpath("//*[@role='trow'] / *[@role='tdata'][3]"));

        System.out.println(ReusableMethods.stringListeyeCevir(ucuncuSutunElementleriList));

        // [$399.00, $399.00, $399.00, $40.00, $15.00]


        //  9. Tabloda "Category" si Furniture olan urunlerin fiyatlarini yazdirin

        //   Category elementinin xpath    //*[@role='trow'][     5      ] / *[@role='tdata'][2]
        //   fiyat elementinin xpat        //*[@role='trow'][     1      ] / *[@role='tdata'][3]


        for (int i = 1; i <=5 ; i++) {

            String  categoryXpath = "//*[@role='trow'][" + i + "] / *[@role='tdata'][2]";
            String fiyatXpath = "//*[@role='trow'][" + i + "] / *[@role='tdata'][3]";


            String categoryDegeri = driver.findElement(By.xpath(categoryXpath))
                    .getText();

            if (categoryDegeri.equalsIgnoreCase("Furniture")){

                String fiyatStr = driver.findElement(By.xpath(fiyatXpath))
                        .getText();

                System.out.println(fiyatStr);
            }
        }

        //10. Bir method olusturun, Test method'undan satir ve sutun verildiginde datayi yazdirsin

        datayiyazdir(2,1); // Medium 25 L Laptop Backpack
        datayiyazdir(3,3); // $399.00

    }

    public void datayiyazdir(int satirNo, int sutunNo){

        String  dinamikXpath = "//*[@role='trow'][" + satirNo + "] / *[@role='tdata']["+sutunNo+"]";

        WebElement istenenDataElementi = driver.findElement(By.xpath(dinamikXpath));


        System.out.println("Istenen satir ve sutundaki data : " + istenenDataElementi.getText());

    }
}
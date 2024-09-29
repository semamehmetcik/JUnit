package day13_WebTables_ExcelOtomasyonu;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel {

    @Test
    public void test01() throws IOException {

        /*
            Bu class'da olusturdugumuz workbook objesi
            java FileInputStream sayesinde
            bilgisayarimizdaki ulkeler excelinden TUM DATALARI aldi

            ANCAKK unutmamaliyiz ki workbook excel'in kendisi degil
            exceldeki bilgileri barindiran
            class'imizdaki bir object'dir.
         */

        // Ulkeler excelinde Sayfa1'in 2.satirindaki 2.datayi yazdirin

        // Selenium bilgisayarimizda olan excel'e ulasamaz
        // excel'e ulasmak icin Java'yi kullanacagiz
        String dosyaYolu = "src/test/java/day13_WebTables_ExcelOtomasyonu/ulkeler.xlsx";

        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);

        // Excel ozel bir yapiya sahiptir
        // bir excel workbook'da farkli sheet(sayfa)'ler
        // her sayfada row(satir)'lar ve her satir'da cell(hucre)'ler var

        // yukledigimiz apache poi sayesinde
        // excel'deki yapinin aynisini kod dunyamizda olusturabiliriz

        Workbook workbook = WorkbookFactory.create(fileInputStream);

        Sheet sayfa = workbook.getSheet("Sayfa1"); // parametre olarak yazilan sayfa ismi
        // excel'de gorunen hali olmalidir

        Row row = sayfa.getRow(1); // yazilan degerler index'dir ve 0'dan baslar

        Cell cell = row.getCell(1); // yazilan degerler index'dir ve 0'dan baslar

        System.out.println("2.satirdaki 2.cell : " + cell); // Kabul





    }
}
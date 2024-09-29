package day13_WebTables_ExcelOtomasyonu;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C04_FizikiKullanilanSatirSayisi {

    @Test
    public void test01() throws IOException {

        /*
            Workbook kullanilan satirlarlar icin Row objesi olusturur
            ama kullanilmayan satirlar icin Row objesini null olarak isaretler

            kullanilan satirda Row objesi olusturuldugu icin
            kullanilmayan bir hucreye ulasmak istedigimizde
            Row objesi uzerinden o hucreye gidebilir ve kullanilmadigi icin null sonucunu verir

            AMMA kullanilmayan bir satir null olarak isaretlendiginden
            o satir (null olarak isaretlenen deger) kullanilmak istenirse
            NullPointerException verir.


         */

        // ulkeler excelindeki Sayfa2'ye gidin
        String dosyaYolu = "src/test/java/day13_WebTables_ExcelOtomasyonu/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sayfa2 = workbook.getSheet("Sayfa2");


        // sayfada kullanilan son satirin 20.satir oldugunu test edin

        int expectedSonSatir = 20;
        int actualSonsatir = sayfa2.getLastRowNum()+1;

        Assertions.assertEquals(expectedSonSatir,actualSonsatir);


        // sayfada kullanilan satir sayisinin 8 oldugunu test edin

        int expectedFizikiSatirSayisi = 8;
        int actualFizikiSatirSayisi = sayfa2.getPhysicalNumberOfRows();

        Assertions.assertEquals(expectedFizikiSatirSayisi,actualFizikiSatirSayisi);


        // bos olan 1 satirin 7.hucresini yazdirin

        // System.out.println(sayfa2.getRow(0).getCell(6)); // NullPointerException


        // dolu olan 2.satirin 7.hucresini yazdirin
        System.out.println(sayfa2.getRow(1).getCell(6)); // null


        // dolu olan 20.satirin 3.hucresini yazdirin

        System.out.println(sayfa2.getRow(19).getCell(2)); // null

    }
}
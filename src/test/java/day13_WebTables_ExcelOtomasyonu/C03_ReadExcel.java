package day13_WebTables_ExcelOtomasyonu;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class C03_ReadExcel {

    @Test
    public void readExcelTest() throws IOException {

        //Gerekli ayarlamalari yapip, ulkeler excelindeki Sayfa1’e gidin

        String dosyaYolu = "src/test/java/day13_WebTables_ExcelOtomasyonu/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sayfa = workbook.getSheet("Sayfa1");

        //- 1.satirdaki 2.hucreye gidelim ve yazdirin
        System.out.println(sayfa.getRow(0).getCell(1)); // Başkent (İngilizce)

        //- 1.satirdaki 2.hucreyi bir string degiskene atayin
        //    ve degerinin “Başkent (İngilizce)” oldugunu test edin

        String expectedYazi = "Başkent (İngilizce)";
        String actualYazi = sayfa.getRow(0).getCell(1).getStringCellValue();

        assertEquals(expectedYazi,actualYazi);

        //- 2.satir 4.cell’in afganistan’in baskenti “Kabil” oldugunu test edin

        expectedYazi = "Kabil";
        actualYazi = sayfa.getRow(1).getCell(3).toString();

        assertEquals(expectedYazi,actualYazi);

        //- Ulke sayisinin 190 oldugunu test edin

        int expectedUlkeSayisi = 190 ;

        int actualUlkeSayisi = sayfa.getLastRowNum() +1 -1 ;
        // getLastRowNum index getirdigi icin 1 ekledik,
        // ama en yukarda baslik oldugu icin 1 cikardik

        assertEquals(expectedUlkeSayisi,actualUlkeSayisi);

        //- Fiziki olarak kullanilan satir sayisinin 191 oldugunu test edin

        int expectedFizikiSatirSayisi = 191;
        int actualFizikiSatirSayisi = sayfa.getPhysicalNumberOfRows();

        assertEquals(expectedFizikiSatirSayisi,actualFizikiSatirSayisi);

        //- Ingilizce ismi Netherlands olan ulkenin baskentinin turkce Amsterdam oldugunu test edin

        String ingilizceUlkeIsmi = "";
        String turkceBaskentIsmi = "";

        for (int i = 0; i <sayfa.getLastRowNum() ; i++) {

            ingilizceUlkeIsmi = sayfa.getRow(i).getCell(0).getStringCellValue();
            turkceBaskentIsmi = sayfa.getRow(i).getCell(3).toString();

            if (ingilizceUlkeIsmi.equalsIgnoreCase("Netherlands")){

                assertEquals("Amsterdam",turkceBaskentIsmi);
            }
        }

        //- Turkce baskent isimlerinde Ankara bulundugunu test edin

        boolean ankaraVarMi = false;

        for (int i = 0; i <=sayfa.getLastRowNum() ; i++) {

            turkceBaskentIsmi = sayfa.getRow(i).getCell(3).toString();

            if (turkceBaskentIsmi.equalsIgnoreCase("Ankara")){
                ankaraVarMi = true;
            }


        }


        assertTrue(ankaraVarMi);

    }
}
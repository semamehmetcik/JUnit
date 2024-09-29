package day11_fileTestleri_Waits;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FileExistTesti {

    @Test
    public void test01(){

        // day11 package'i icinde funnyImage.jpg
        // dosyasinin varoldugunu test edin

        /*
            Biz Selenium'da tum islemleri
            olusturdugumuz WebDriver objesi ile yapiyoruz

            adindan da anlasilacagi gibi
            WebDriver Web icin olusturulmustur ve bilgisayarimizdaki dosyalara ERISEMEZ

            Bilgisayarimizdaki dosyalara erismek icin Java'yi kullanacagiz
            Java'nin bilgisayarimizdaki dosyalara ulasmasi icin
            dosya yoluna ihtiyacimiz var
         */


        String dosyaYolu = "src/test/java/day11_fileTestleri_Waits/funnyImage.jpg";

        System.out.println(Files.exists(Paths.get(dosyaYolu)));

        Assertions.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        // src/test/java/day11_fileTestleri_Waits/funnyImage.jpg
        // src/test/java/day11_fileTestleri_SeleniumWaits/funnyImage.jpg
        // src/test/java/day11_fileTestleri_Waits/funnyImage.jpg


    }


    @Test
    public void test02(){
        // Eger dosya projemizin icinde degilse
        //    /Users/ahmetbulutluoz/Downloads/funnyImage.jpg

        String dosyaYolu = "/Users/ahmetbulutluoz/Downloads/funnyImage.jpg";

        Assertions.assertTrue(Files.exists(Paths.get(dosyaYolu)));


        //  C:\Users\WII                \Downloads\funnyImage.jpg
        //  C:\\Users\\rdvny            \\Downloads\\funnyImage.jpg
        //  C:\Users\LENOVO             \Downloads\funnyImage.jpg
        //    /Users/ahmetbulutluoz     /Downloads/funnyImage.jpg
    }
}
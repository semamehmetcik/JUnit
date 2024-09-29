package day11_fileTestleri_Waits;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_DosyaYolunuDinamikhaleGetirme {

    @Test
    public void test01(){

        /*
            Bir ekiple calistigimizda
            olusturulan testlerin her ortamda calismasi beklenir

            File testlerinde dosya yolu onemli oldugundan
            dosya yolunu dinamik hale getirmek icin
            Java'dan yardim aliriz
         */


        // 1- Bilgisayarin ana dosya yolu icin
        System.out.println(System.getProperty("user.home")); // /Users/ahmetbulutluoz


        //  C:\Users\WII                \Downloads\funnyImage.jpg
        //  C:\\Users\\rdvny            \\Downloads\\funnyImage.jpg
        //  C:\Users\LENOVO             \Downloads\funnyImage.jpg
        //    /Users/ahmetbulutluoz     /Downloads/funnyImage.jpg


        String dinamikDosyaYolu = System.getProperty("user.home") + "/Downloads/funnyImage.jpg";

        Assertions.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));


        // 2- icinde oldugumuz proje yolu

        System.out.println(System.getProperty("user.dir"));

        String dinamikProjedekiDosyaDosyaYolu =
                System.getProperty("user.dir") + "/src/test/java/day11_fileTestleri_Waits/funnyImage.jpg";


        // /Users/ahmetbulutluoz/Desktop/My Desktop/course/projeler/Team145_JUnit

        Files.exists(Paths.get(dinamikProjedekiDosyaDosyaYolu));
    }
}
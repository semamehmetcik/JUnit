package utilities;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ReusableMethods {


    // Webelement'lerden olusan listeyi,
    // String'lerden olusan listeye ceviren bir method olusturalim

    public static List<String> stringListeyeCevir(List<WebElement> elementListesi){

        List<String> stringListesi = new ArrayList<>();

        for (WebElement eachElement : elementListesi) {

            stringListesi.add(eachElement.getText());
        }

        return stringListesi;
    }

    public static void bekle(int saniye){

        try {
            Thread.sleep( saniye*1000);
        } catch (InterruptedException e) {

        }

    }
}
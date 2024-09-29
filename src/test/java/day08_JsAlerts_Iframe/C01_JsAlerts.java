package day08_JsAlerts_Iframe;

import org.junit.jupiter.api.Test;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C01_JsAlerts extends TestBase_Each {

    @Test
    public void test01(){

        //Bir web sayfasina gittigimizde
        // cookies kabul etmek gibi bir islev ile bir pop up ile karsilasirsak
        // ilk yapacagimiz islem, pop up'i locate edip edemedigimizi kontrol etmektir



        driver.get("https://www.youtube.com");

        ReusableMethods.bekle(120);
    }
}
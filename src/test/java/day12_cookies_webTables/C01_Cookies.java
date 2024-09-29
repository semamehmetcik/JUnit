package day12_cookies_webTables;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.Set;

public class C01_Cookies extends TestBase_Each {

    @Test
    public void cookiesTesti(){

        driver.get("https://www.arabam.com");

        // butun cookie'leri yazdirin

        cookieleriYazdir(driver.manage().getCookies());


        // ismi source olan cookie'yi yazdirin
        System.out.println("=============================");

        System.out.println(driver.manage().getCookieNamed("source"));


        // ismi source olan cookie'nin degerinin "direct" oldugunu test edin

        String expectedCookieDegeri = "direct";
        String actualCookieDegeri = driver.manage().getCookieNamed("source").getValue();

        Assertions.assertEquals(expectedCookieDegeri,actualCookieDegeri);

        // cookie'ler arasinda ismi "sessionSource" olan bir cookie bulundugunu test edin

        boolean sessionSourceVarMi = false;

        Set<Cookie> cookieSeti = driver.manage().getCookies();

        for (Cookie eachCookie : cookieSeti){

            if (eachCookie.getName().equals("sessionSource")){
                sessionSourceVarMi = true;
            }
        }

        Assertions.assertTrue(sessionSourceVarMi);

        // ismi arabam, degeri corolla olan bir cookie olusturup
        // arabam.com'a yukleyin

        Cookie cookie = new Cookie("arabam","corolla");
        driver.manage().addCookie(cookie);

        cookieleriYazdir(driver.manage().getCookies());

        // ve yuklendigini test edin

        boolean arabamVarMi = false;

        cookieSeti = driver.manage().getCookies();

        for (Cookie eachCookie : cookieSeti){

            if (eachCookie.getName().equals("arabam")){
                arabamVarMi = true;
            }
        }

        Assertions.assertTrue(arabamVarMi);


        // UserGuidValue cookie'sini silin
        driver.manage().deleteCookieNamed("UserGuidValue");

        // ve silindigini test edin
        boolean userGuidValueVarMi = false;

        cookieSeti = driver.manage().getCookies();

        for (Cookie eachCookie : cookieSeti){

            if (eachCookie.getName().equals("UserGuidValue")){
                userGuidValueVarMi = true;
            }
        }

        Assertions.assertFalse(userGuidValueVarMi);


        // Tum cookieleri silin
        driver.manage().deleteAllCookies();

        // ve silindiklerini test edin
        cookieSeti = driver.manage().getCookies();

        Assertions.assertEquals(0,cookieSeti.size());




        ReusableMethods.bekle(3);

    }


    public void cookieleriYazdir( Set<Cookie> cookiesSeti){

        System.out.println("=================================");

        int sayac =1 ;

        for ( Cookie eachCookie: cookiesSeti
        ) {

            System.out.println( sayac + ". cookie    :   " + eachCookie);
            sayac++;
        }

    }
}
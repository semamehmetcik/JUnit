package day09_switchingWindows_actions;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.Set;

public class C04_AcilanWindowTitlelariniYazdirma extends TestBase_Each {

    @Test
    public void test01(){

        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        // click here linkine tiklayin
        driver.findElement(By.xpath("//*[text()='Click Here']"))
                .click();

        // acik olan 2 window'daki sayfalarin title'larini yazdirin

        Set<String> acikOlanWindowlarinWHDSeti = driver.getWindowHandles();

        System.out.println(acikOlanWindowlarinWHDSeti);
        // [e14640de-fe86-4142-80e3-9bc4cef080cc, 08947a73-0450-498c-90f5-9f4c817bbfc9]

        for (String eachWhd : acikOlanWindowlarinWHDSeti){

            driver.switchTo().window(eachWhd);
            ReusableMethods.bekle(1);
            System.out.println(driver.getTitle());

        }

        // window'lardan title'i "New Window" olanda kalin


        for (String eachWhd : acikOlanWindowlarinWHDSeti){

            driver.switchTo().window(eachWhd);
            ReusableMethods.bekle(1);

            if (driver.getTitle().equals("New Window")){
                break;
            }

        }

        System.out.println("Durdugumuz sayfanin title'i : " + driver.getTitle());



    }
}
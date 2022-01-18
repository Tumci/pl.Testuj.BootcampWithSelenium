package webinar14.pl;

import org.testng.Assert;
import org.testng.annotations.Test;
import webinar14.BaseTest;

public class Testuj extends BaseTest {

    @Test
    public void getTitePage(){
        driver.get("httml://www.testuj.pl");
        String title = driver.getTitle();
        String namePage = "Zostań certyfikowanym testerem. Szkolenia z testowania oprogramowania • testuj.pl";
        Assert.assertEquals(title, namePage);
    }
}

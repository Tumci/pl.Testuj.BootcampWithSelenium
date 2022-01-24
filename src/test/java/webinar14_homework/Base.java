package webinar14_homework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Base {
public WebDriver driver;

    @BeforeClass
    public void SetUp(){
        System.setProperty("webdriver.chrome.driver","E:\\Projekty_IT\\Narzedzia\\chromdriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterClass
    public void tearDown(){
        driver.close();
        driver.quit();
    }

    static void sleepFor(int millis){
        try {
            Thread.sleep(millis);
        }catch (Exception e){}
    }
}

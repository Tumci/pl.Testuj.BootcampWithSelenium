package testPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test1 {
    @BeforeTest
    public void Start(){

    }
    @Test(priority = 0, invocationCount = 2)
    public void CalculateSum() {
        System.setProperty("webdriver.chrome.driver","E:\\Projekty_IT\\Narzedzia\\chromdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.onet.pl");
        driver.navigate().to("https://www.wp.pl");

        System.out.println(3+5);

        driver.close();
        driver.quit();
    }
    @Test(priority = 1, dependsOnMethods = "DivisionByZero")
    public void CalculateDivision(){
        System.out.println(5/3);
    }
    @Test(priority = 2)
    public void CalculateMultiple(){
        System.out.println(3*4);
    }

    @Test(alwaysRun = false)
    public void DivisionByZero(){
        System.out.println(5/0);
    }

    @AfterTest
    public void End(){

    }
}

package testPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test2 {
    @BeforeTest
    public void Start(){

    }
    @Test(priority = 0, invocationCount = 3)
    public void CalculateSum() {
        System.out.println(5+8);
    }
    @Test(priority = 1, dependsOnMethods = "DivisionByZero")
    public void CalculateDivision(){
        System.out.println(5/3);
    }
    @Test(priority = 2)
    public void CalculateMultiple(){
        System.out.println("CalculateMultiple -> "+ 3*4);
    }

    @Test()
    public void DivisionByZero(){
        System.out.println(5/0);
    }

    @AfterTest
    public void End(){

    }
}

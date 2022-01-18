package webinar14;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    public WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","E:\\Projekty_IT\\Narzedzia\\chromdriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}

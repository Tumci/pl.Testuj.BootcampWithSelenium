package zadanieDomowe14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PdfHomeWork_select_waits extends Base{
    @Test
    public void titlePageTestujPl_task1(){
//  Napisz test, który wypisze w konsoli tytuł strony
//  https://testuj.pl/

        driver.get("https://testuj.pl");
        String title = driver.getTitle();
        System.out.println(title);
    }
    @Test
    public void howManyLinksAndImg_task2(){
//  Napisz test składający się z następujących kroków:
//  a. Wejdź na stronę: https://www.bbc.com
//  b. Wyświetl w konsoli ilość dostępnych linków na stronie.
//  c. Wyświetl w konsoli ilość dostępnych obrazków na stronie

        driver.get("https://www.bbc.com");
        int linkCount = driver.findElements(By.tagName("a")).size();
        int imgCount = driver.findElements(By.tagName("img")).size();

        System.out.println("Ilość linków na stronie -> " + linkCount);
        System.out.println("Ilość obrazów na stronie -> " + imgCount);
    }

    @Test
    public void correctLoginOrangeHrmLive_task3(){
// Napisz test składający się z następujących kroków:
// a. Wejdź na stronę https://opensource-demo.orangehrmlive.com/
// b. W polu 'Username' wpisz: Admin.
// c. W polu 'Password' wpisz: admin123.
// d. Kliknij przycisk Login.
// e. Upewnij się, że użytkownik się zalogował.

        //configuration
        String correctUrl = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
        driver.get("https://opensource-demo.orangehrmlive.com");

        //body
        WebElement txtUsername = driver.findElement(By.id("txtUsername"));
        txtUsername.clear();
        txtUsername.sendKeys("Admin");

        WebElement txtPassword = driver.findElement(By.id("txtPassword"));
        txtPassword.clear();
        txtPassword.sendKeys("admin123");

        driver.findElement(By.id("btnLogin")).click();

        String url = driver.getCurrentUrl();

        // Assert
        Assert.assertEquals(url, correctUrl, "User is not correct login. This url was show up -> " + url);
    }

    @Test
    public void incorrectLoginOrangeHrmLive_task4(){
//        Napisz test składający się z następujących kroków:
//        a. Wejdź na stronę https://opensource-demo.orangehrmlive.com/
//        b. W polu 'Username' wpisz: WrongUsername.
//        c. W polu 'Password' wpisz: WrongPassword.
//        d. Kliknij przycisk Login.
//        e. Sprawdź, czy wyświetlił się komunikat o błędnych danych logowania - Invalid credentials.

        //configuration
        driver.get("https://opensource-demo.orangehrmlive.com");

        //body
        WebElement txtUsername = driver.findElement(By.id("txtUsername"));
        txtUsername.clear();
        txtUsername.sendKeys("WrongUsername");

        WebElement txtPassword = driver.findElement(By.id("txtPassword"));
        txtPassword.clear();
        txtPassword.sendKeys("WrongPassword");

        driver.findElement(By.id("btnLogin")).click();

        WebElement spanMessage = driver.findElement(By.id("spanMessage"));

        //Assert
        Assert.assertTrue(spanMessage.isDisplayed(), "Span message should be visible!");
        Assert.assertEquals(spanMessage.getText(), "Invalid credentials", "Text should be 'Invalid credentials' but is -> "+ spanMessage.getText());
    }
    @Test
    public void priceFor3ItemsIsCorrect_task5(){
//        Napisz następujący test
//        a. Wejdź na stronę http://demo.guru99.com/payment-gateway/index.php
//        b. Wybierz trzy produkty
//        c. Kliknij 'Buy Now'
//        d. Sprawdź, czy wyliczona cena się zgadza

        driver.get("http://demo.guru99.com/payment-gateway/index.php");
        driver.manage().window().maximize();
        sleepFor(4000);

        // nie wiem czemu w to nie klika!! --------------- pop up
        driver.findElement(By.id("denyAll")).click();
        sleepFor(1000);
        driver.findElement(By.cssSelector("button[class*='okButton']")).click();

        Select drpQuantity = new Select(driver.findElement(By.name("quantity")));
        drpQuantity.selectByValue("3");

        sleepFor(2000);

        driver.findElement(By.cssSelector("input[type='submit']")).click();

        sleepFor(2000);
    }
}

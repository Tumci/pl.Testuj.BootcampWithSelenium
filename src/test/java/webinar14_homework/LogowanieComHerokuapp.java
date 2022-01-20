package webinar14_homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogowanieComHerokuapp extends Base {
//    @channel http://the-internet.herokuapp.com/login przetestować logowanie sprawdzając:
//    1. Czy zmienił się adres url po zalogowaniu
//    2. Czy pojawił się przycisk Logout

    @Test
    public void afterLoginUrlIsDifferent(){
        driver.get("http://the-internet.herokuapp.com/login");
        String urlBeforeLogin = driver.getCurrentUrl();

//        sleepFor(3000);

        WebElement username = driver.findElement(By.id("username"));
        username.clear();
        username.sendKeys("tomsmith");

//        sleepFor(3000);

        WebElement pass = driver.findElement(By.id("password"));
        pass.clear();
        pass.sendKeys("SuperSecretPassword!");

//        sleepFor(3000);

        driver.findElement(By.tagName("button")).click();
        String urlAfterLogin = driver.getCurrentUrl();

//        sleepFor(3000);

        Assert.assertNotEquals(urlBeforeLogin, urlAfterLogin, "Te wartości są sobie równe" );
    }

    @Test
    public void isLogoutButtonDisplay(){
        driver.get("http://the-internet.herokuapp.com/login");

        WebElement username = driver.findElement(By.id("username"));
        username.clear();
        username.sendKeys("tomsmith");

        WebElement pass = driver.findElement(By.id("password"));
        pass.clear();
        pass.sendKeys("SuperSecretPassword!");

        driver.findElement(By.tagName("button")).click();

        WebElement logout = driver.findElement(By.cssSelector("div[class=\"example\"]>a"));
        System.out.println(logout.isDisplayed());

        Assert.assertTrue(logout.isDisplayed());
    }
}

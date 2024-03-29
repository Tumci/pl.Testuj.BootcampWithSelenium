package webinar14_homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Base;

public class LogowanieComHerokuapp extends Base {
//    @channel http://the-internet.herokuapp.com/login przetestować logowanie sprawdzając:
//    1. Czy zmienił się adres url po zalogowaniu
//    2. Czy pojawił się przycisk Logout

    @Test
    public void afterLoginUrlIsDifferent(){
        //Configuration
        driver.get("http://the-internet.herokuapp.com/login");
        String urlBeforeLogin = driver.getCurrentUrl();

        //Body
        WebElement username = driver.findElement(By.id("username"));
        username.clear();
        username.sendKeys("tomsmith");

        WebElement pass = driver.findElement(By.id("password"));
        pass.clear();
        pass.sendKeys("SuperSecretPassword!");

        driver.findElement(By.tagName("button")).click();
        String urlAfterLogin = driver.getCurrentUrl();

        //Assertion
        Assert.assertNotEquals(urlBeforeLogin, urlAfterLogin, "Te wartości są sobie równe" );
    }

    @Test
    public void isLogoutButtonDisplay(){
        //Configuration
        driver.get("http://the-internet.herokuapp.com/login");

        //Body
        WebElement username = driver.findElement(By.id("username"));
        username.clear();
        username.sendKeys("tomsmith");

        WebElement pass = driver.findElement(By.id("password"));
        pass.clear();
        pass.sendKeys("SuperSecretPassword!");

        driver.findElement(By.tagName("button")).click();

        WebElement logout = driver.findElement(By.cssSelector("div[class=\"example\"]>a"));
        System.out.println(logout.isDisplayed());

        //Assertion
        Assert.assertTrue(logout.isDisplayed());
    }
}

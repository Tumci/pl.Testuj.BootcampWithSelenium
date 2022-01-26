package webinar17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Base;

import java.time.Duration;

public class CssAtributeTest extends Base {
    private static WebElement modalAd;
    private static WebElement modalAdTitleBar;

    @Test
    public void setModalAdIsDisplay(){
        //Configuration
        driver.get("http://the-internet.herokuapp.com/entry_ad");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Body
        modalAd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal")));
        modalAdTitleBar = modalAd.findElement(By.cssSelector(".modal-title"));

        //Assertion
        Assert.assertEquals(modalAdTitleBar.getText(), "THIS IS A MODAL WINDOW", "Wrong title -> " + modalAdTitleBar.getText());
    }
}

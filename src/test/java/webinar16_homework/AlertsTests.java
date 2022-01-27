package webinar16_homework;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Base;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AlertsTests extends Base {
//  1. Napisać test do https://the-internet.herokuapp.com/javascript_alerts do JS Confirm, kliknięcie w Anuluj
//  2. Rozbudować metodę jsPromptTest(), aby pobierała wprowadzany tekst jako parametr z pliku (dowolny plik np xml, txt itp)
//  3. Zadania z końca prezentacji 16.pdf
//     Wejdź na stronę https://demoqa.com/alertsWindows i wykonaj testy dla:
//     •Okien (Browser Windows)
//     •Alerts
//     •Ramek (Frames / Nested frames)

    @Test
    public void jsConfirmeCancelTest(){
        //Cofiguration
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //Body
        driver.findElement(By.cssSelector("ul>li:nth-child(2) > button")).click();
        Alert confirm = driver.switchTo().alert();
        String textConfirmAlert = confirm.getText();
        confirm.dismiss();
        WebElement result = driver.findElement(By.id("result"));

        //Asertions
        Assert.assertEquals(result.getText(), "You clicked: Cancel", "Wrong message, in results show up -> " + result.getText());
        Assert.assertEquals(textConfirmAlert, "I am a JS Confirm", "Wrong text from confirm alert. It was -> " + textConfirmAlert);
    }

    @Test
    public void jsPromptTest(){
        //Configuration
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        String sendText = "Testuj.pl";
        String sendTextFromFile = "";

        File file = new File("promptMessage.txt");
        try {
            Scanner scanner = new Scanner(file);
            sendTextFromFile = scanner.nextLine();
            scanner.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

        //Body
        driver.findElement(By.cssSelector("ul>li:nth-child(3) > button")).click();
        Alert jsPrompt = driver.switchTo().alert();
        String promptText = jsPrompt.getText();
        jsPrompt.sendKeys(sendTextFromFile);
        jsPrompt.accept();
        String resultText = driver.findElement(By.id("result")).getText();

        //Assertions
        Assert.assertEquals(resultText, "You entered: " + sendTextFromFile, "Wrong text showed in result. In send message was -> " + resultText);
        Assert.assertEquals(promptText, "I am a JS prompt", "Wrong text from prompt alert. It was -> " + promptText);
    }
}

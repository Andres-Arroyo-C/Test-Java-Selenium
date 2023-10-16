package Chrome;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Date {

    public static void main (String [] args) throws InterruptedException {
        System.out.println("Inicio de la prueba");
        System.setProperty("webdriver.chrome.driver", "C:\\Cursos\\Selenium\\Drivers\\chromedriver.exe");
        WebDriver chrome = new ChromeDriver();
        chrome.manage().window().maximize();
        chrome.get("https://demoqa.com/date-picker");
        System.out.println("Abriendo la página");
        Thread.sleep(5000);
        try{
            Robot robot = new Robot();

           /* WebElement date = chrome.findElement(By.id("dateAndTimePickerInput"));

            Thread.sleep(2000);
            date.sendKeys("06/09/2025");
            robot.keyPress(KeyEvent.VK_ENTER);
            System.out.println("Date");
            Thread.sleep(5000);*/
           // October 16, 2023 11:50 AM


            WebElement date1 = chrome.findElement(By.id("datePickerMonthYearInput"));
            date1.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE); // Borra el contenido actual
            date1.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
            date1.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE);
            date1.sendKeys("06/09/2025");
            //Thread.sleep(2000);
            robot.keyPress(KeyEvent.VK_ENTER);
            System.out.println("Date1");
            Thread.sleep(5000);
        }catch (Exception e){
            System.out.println("error = " + e);
        }finally {
            chrome.quit();
            System.out.println("Fin de la prueba");
        }

    }
}

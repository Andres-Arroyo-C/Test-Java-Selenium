package Chrome;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v113.indexeddb.model.Key;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;

public class Select_Menu {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Inicio de la prueba");
        System.setProperty("webdriver.chrome.driver", "C:\\Cursos\\Selenium\\Drivers\\chromedriver.exe");
        WebDriver chrome = new ChromeDriver();
        chrome.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) chrome;
        WebDriverWait wait = new WebDriverWait(chrome, Duration.ofSeconds(10)); // Espera explícita con tiempo límite de 10 segundos


        chrome.get("https://demoqa.com/");
        System.out.println("Abriendo la página");

        try {

            //div[@class="category-cards"]/child::div[6]
            WebElement widget = chrome.findElement(By.xpath("//div[@class=\"category-cards\"]/child::div[4]"));
            js.executeScript("arguments[0].scrollIntoView();", widget);
            if (widget.isDisplayed() && widget.isEnabled()) {
                widget.click();
                System.out.println("Haciendo click en widget = " + widget);
            } else {
                System.out.println("No se encontro widget");
            }

            WebElement Select_Menu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[ @class=\"menu-list\"]/descendant::span[text()=\"Select Menu\"]")));
            js.executeScript("arguments[0].scrollIntoView();", Select_Menu);
            if (Select_Menu.isEnabled() && Select_Menu.isDisplayed()){
                Select_Menu.click();
                System.out.println("Haciendo click en Select_Menu = " + Select_Menu);
            } else {
                System.out.println("No se encontro Select_Menu");
            }

           WebElement  selectOne = wait.until(ExpectedConditions.elementToBeClickable(By.id("react-select-4-input")));
            selectOne.sendKeys("Black");
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_TAB);
            Thread.sleep(5000);
            robot.keyPress(KeyEvent.VK_ESCAPE);
            System.out.println("robot 1");

            Thread.sleep(5000);
            WebElement selectOne2 = wait.until(ExpectedConditions.elementToBeClickable(By.id("react-select-3-input")));
            selectOne2.sendKeys("Dr.");
            Thread.sleep(2000);
            robot.keyPress(KeyEvent.VK_TAB);
            System.out.println("robot 2");



            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Se produjo un error durante la prueba");
        } finally {
            chrome.quit();
            System.out.println("Fin de la prueba");
        }
    }
}

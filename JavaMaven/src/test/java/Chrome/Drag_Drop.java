package Chrome;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class Drag_Drop {
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
            WebElement Interactions = chrome.findElement(By.xpath("//div[@class=\"category-cards\"]/child::div[5]"));
            js.executeScript("arguments[0].scrollIntoView();", Interactions);
            if (Interactions.isDisplayed() && Interactions.isEnabled()) {
                Interactions.click();
                System.out.println("Haciendo click en Interactions = " + Interactions);
            } else {
                System.out.println("No se encontro Interactions");
            }

            WebElement Droppable = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Droppable\"]")));
            js.executeScript("arguments[0].scrollIntoView();", Droppable);
            if (Droppable.isEnabled() && Droppable.isDisplayed()){
                Droppable.click();
                System.out.println("Haciendo click en Droppable = " + Droppable);
            } else {
                System.out.println("No se encontro Droppable");
            }

            Thread.sleep(5000);
            WebElement draggable = chrome.findElement(By.id("draggable"));
            WebElement droppable = chrome.findElement(By.id("droppable"));
            Actions acciones = new Actions(chrome);

            acciones.dragAndDrop(draggable, droppable).build().perform();

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

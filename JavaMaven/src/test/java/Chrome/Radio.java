package Chrome;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Radio {

    public static void main (String [] args) throws InterruptedException {
        System.out.println("Inicio de la prueba");
        System.setProperty("webdriver.chrome.driver", "C:\\Cursos\\Selenium\\Drivers\\chromedriver.exe");
        WebDriver chrome = new ChromeDriver();
        chrome.manage().window().maximize();
        chrome.get("https://demoqa.com/automation-practice-form");
        System.out.println("Abriendo la página");
        Thread.sleep(5000);
        JavascriptExecutor js =  (JavascriptExecutor) chrome;
        WebDriverWait wait = new WebDriverWait(chrome, Duration.ofSeconds(10));
       /* try{
            WebDriverWait wait = new WebDriverWait(chrome, Duration.ofSeconds(10));

            WebElement radio = wait.until(ExpectedConditions.presenceOfElementLocated((By.id("gender-radio-1"))));
            radio.click();
            Thread.sleep(5000);
        }catch (Exception e){
            System.out.println("error = " + e);
        }finally {
            chrome.quit();
            System.out.println("Fin de la prueba");
        }*/

        WebElement elemento = wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
        js.executeScript("arguments[0].click();", elemento);
        if (elemento.isEnabled() && elemento.isDisplayed()){
            //elemento.click();
            System.out.println("Haciendo click en Select_Menu = " + elemento);
        } else {
            System.out.println("No se encontro Select_Menu");
        }
        Thread.sleep(5000);
        System.out.println("cerrar ");
        chrome.close();
    }
}

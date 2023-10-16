package _2_Acciones;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.sql.Driver;
import java.time.Duration;

public class Seleccionar {
    public static void SeleccionarOpcion(WebDriver driver, By localizador, String texto){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(localizador));
        element.sendKeys(texto);
        try{
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_TAB);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }


    }
}
